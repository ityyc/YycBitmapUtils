package annotation;

import android.view.View;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Author ：yuanyc
 * Time ：2017/4/27
 * Description ：setOnClickListener注解
 * Onclick是用于写在Activity的某个方法上的
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@BaseEvent(listenerType = View.OnClickListener.class,listenerSetter = "setOnClickListener",methodName = "OnClick")
public @interface OnClick {
    int[] value();
}
