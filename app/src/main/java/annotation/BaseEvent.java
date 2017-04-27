package annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Author ：yuanyc
 * Time ：2017/4/27
 * Description ：自定义注解
 */
@Target(ElementType.ANNOTATION_TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface BaseEvent {
    Class<?> listenerType();
    String listenerSetter();
    String methodName();

}
