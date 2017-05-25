package annotation;

import android.app.Activity;
import android.view.View;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Objects;

/**
 * Author ：yuanyc
 * Time ：2017/4/27
 * Description ：注解处理器
 */

public class ViewInjectUtils {
    private static final String METHOD_SET_CONTENTVIEW = "setContentView";
    private static final String METHOD_FIND_VIEW_BY_ID = "findViewById";

    /**
     * 初始化方法
     *
     * @param activity
     */
    public static void inject(Activity activity) {
        injectContentView(activity);
        injectViews(activity);
        injectEvent(activity);
    }

    private static void injectContentView(Activity activity) {
        Class<? extends Activity> aClass = activity.getClass();
        //查询类上是否存在ContentView注解
        ContentView contentView = aClass.getAnnotation(ContentView.class);
        if (null != contentView) {
            //存在且不为空
            //得到定义在注解中的值
            int id = contentView.value();
            try {
                Method method = aClass.getMethod(METHOD_SET_CONTENTVIEW, int.class);
                method.setAccessible(true);
                method.invoke(activity, id);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

    private static void injectViews(Activity activity) {
        Class<? extends Activity> aClass = activity.getClass();
        //获取类中所有字段
        Field[] fields = aClass.getDeclaredFields();
        //遍历所有字段
        for (Field field : fields) {
            ViewInject fieldAnnotation = field.getAnnotation(ViewInject.class);
            if (null != fieldAnnotation) {
                //如果不为空
                //获取值
                int value = fieldAnnotation.value();
                if (-1 != value) {
                    //如果不等于-1
                    try {
                        Method method = aClass.getMethod(METHOD_FIND_VIEW_BY_ID, int.class);
                        Object invoke = method.invoke(activity, value);
                        field.setAccessible(true);
                        field.set(activity, invoke);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }

        }
    }
    private static void injectEvent(Activity activity) {
        Class<? extends Activity> aClass = activity.getClass();
        //拿到类中所有方法
        Method[] methods = aClass.getMethods();
        //遍历所有方法
        for (Method method : methods) {
            //拿到方法上的所有注解
            Annotation[] annotations = method.getAnnotations();
            //遍历注解
            for (Annotation annotation : annotations) {
                System.out.println("method:---->"+method);
                System.out.println("annotation:---->"+annotation);
                //拿到注解的类型
                Class<? extends Annotation> annotationType = annotation.annotationType();
                System.out.println("annotationType"+annotationType);
                //获取定义在注解上的指定注解
                BaseEvent baseEvent = annotationType.getAnnotation(BaseEvent.class);
                if (null != baseEvent) {
                    //取出设置监听器的名称，监听器的类型，调用的方法名
                    String listenerSetter = baseEvent.listenerSetter();
                    Class<?> listenerType = baseEvent.listenerType();
                    String methodName = baseEvent.methodName();
                    try {
                        //拿到OnClick注解中value方法
                        Method declaredMethod = annotationType.getDeclaredMethod("value");
                        //取出所有定义的viewId
                        int[] viewIds = (int[]) declaredMethod.invoke(annotation, new Object[]{});
                        //通过InvocationHandler设置代理
                        DynamicHandler dynamicHandler = new DynamicHandler(activity);
                        dynamicHandler.addMethod(methodName, method);
                        Object listener = Proxy.newProxyInstance(listenerType.getClassLoader(), new Class<?>[]{listenerType}, dynamicHandler);
                        //遍历所有的View，设置事件
                        for (int id : viewIds) {
                            View view = activity.findViewById(id);
                            Method setEventListenerMethod = view.getClass().getMethod(listenerSetter, listenerType);
                            setEventListenerMethod.invoke(view, listener);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

}
