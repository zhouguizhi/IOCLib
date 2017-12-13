package com.ioc.annontion;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
/**
 * Created by zhouguizhi on 2017/12/13.
 */
public @interface ContentView {
    int value();
}
