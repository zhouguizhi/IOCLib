package com.ioc.inject;
import android.content.Context;
import android.view.View;
import com.ioc.annontion.event.base.EventBase;
import com.ioc.config.Constant;
import com.ioc.proxy.EventListenerInvocationHandler;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;
/**
 * Created by zhouguizhi on 2017/12/13.
 * 事件注入
 */
public final class EventInject {
    private EventInject(){}
    public  static  void inject(Context context)
    {
        injectEvents(context);
    }
    /**
     * 注入事件
     * @param context 上下文
     */
    private static void injectEvents(Context context) {
        Class<?> clazz=context.getClass();
        Method[] methods=clazz.getDeclaredMethods();
        for (Method method:methods)
        {
            Annotation[]  annotations=method.getAnnotations();
            for(Annotation annotation:annotations)
            {
                Class<?> annotationType=annotation.annotationType();
                EventBase eventBase=annotationType.getAnnotation(EventBase.class);
                if(eventBase==null)
                {
                    continue;
                }
                String listenerSetter=eventBase.setListener();
                Class<?> listenerType=eventBase.listenerType();
                String callMethod=eventBase.callback();
                Map<String,Method> methodMap=new HashMap<>();
                methodMap.put(callMethod,method);
                try {
                    Method valueMethod=annotationType.getDeclaredMethod("value");
                    int[] viewIds= (int[]) valueMethod.invoke(annotation);
                    for (int viewId:viewIds)
                    {
                        Method findViewById=clazz.getMethod(Constant.FINDVIEWBYID.getName(),int.class);
                        View view= (View) findViewById.invoke(context,viewId);
                        if(view==null)
                        {
                            continue;
                        }
                        Method eventMethod=view.getClass().getMethod(listenerSetter,listenerType);
                        EventListenerInvocationHandler handler=new EventListenerInvocationHandler(context,methodMap);
                        Object proxy= Proxy.newProxyInstance
                                (listenerType.getClassLoader(),
                                        new Class[]{listenerType},handler);
                        eventMethod.invoke(view,proxy);
                    }
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
