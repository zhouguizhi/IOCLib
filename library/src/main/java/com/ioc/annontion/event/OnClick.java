package com.ioc.annontion.event;
import android.view.View;

import com.ioc.annontion.event.base.EventBase;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/**
 * Created by zhouguizhi on 2017/12/13.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@EventBase(setListener = "setOnClickListener",
        listenerType = View.OnClickListener.class,
        callback = "onClick")
public @interface OnClick
{
    int[] value();
}
