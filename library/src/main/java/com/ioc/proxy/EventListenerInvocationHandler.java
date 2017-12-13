package com.ioc.proxy;
import android.content.Context;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Map;
/**
 * Created by zhouguizhi on 2017/12/13.
 */
public class EventListenerInvocationHandler implements InvocationHandler {
    //activity   真实对象
    private Context context;
    private Map<String,Method> map;
    public EventListenerInvocationHandler(Context context, Map<String, Method> map) {
        this.context = context;
        this.map = map;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        String name=method.getName();
        if(null!=map&&!map.isEmpty()){
            //决定是否需要进行代理
            Method m =map.get(name);
            if(m!=null)
            {
                return  m.invoke(context,args);
            }else
            {
                return method.invoke(proxy,args);
            }
        }
        return null;
    }
}
