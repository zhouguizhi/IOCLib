package com.ioc.annontion.event.base;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/**
 * Created by zhouguizhi on 2017/12/13.
 * 对所有事件的扩展
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.ANNOTATION_TYPE)
public @interface EventBase {
    /**
     * 设置监听的方法
     * @return
     */
    String setListener();
    /**
     * 事件类型
     * @return
     */
    Class<?> listenerType();
    /**
     * 回调方法
     * 事件被触发后，执行回调方法名称
     */
    String callback();
}
