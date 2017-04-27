package annotation;

import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.HashMap;

/**
 * Author ：yuanyc
 * Time ：2017/4/27
 * Description ：动态代理类
 */

public class DynamicHandler implements InvocationHandler {
    private WeakReference<Object> handlerRef;
    private final HashMap<String, Method> methodMap = new HashMap<String, Method>();

    public DynamicHandler(Object handler) {
        this.handlerRef = new WeakReference<Object>(handler);
    }

    public Object getHandlerRef() {
        return handlerRef.get();
    }

    public void setHandlerRef(Object handler) {
        this.handlerRef = new WeakReference<Object>(handler);
    }

    public void addMethod(String name, Method method) {
        methodMap.put(name, method);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object handler = handlerRef.get();
        if (null != handler) {
            String name = method.getName();
            Method method1 = methodMap.get(name);
            if (null != method1) {
                return method1.invoke(handler, args);
            }
        }
        return null;
    }
}
