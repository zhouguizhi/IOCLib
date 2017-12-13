package com.ioc;
import android.content.Context;
import com.ioc.inject.EventInject;
import com.ioc.inject.InjectUtils;
/**
 * Created by zhouguizhi on 2017/12/13.
 */
public class IocInject {
    private IocInject(){}
    public static void initInject(Context context){
        if(context==null){
            throw new IllegalArgumentException("请传入context参数");
        }
        InjectUtils.inject(context);
        EventInject.inject(context);
    }
}
