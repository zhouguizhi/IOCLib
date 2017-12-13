package com.ioc.inject;
import android.content.Context;
import android.view.View;
import com.ioc.annontion.ContentView;
import com.ioc.annontion.ViewInject;
import com.ioc.config.Constant;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
/**
 * Created by zhouguizhi on 2017/12/13.
 */
public class InjectUtils {
    private InjectUtils(){}
    public  static  void inject(Context context)
    {
        injectLayout(context);
        injectView(context);
    }
    public static void injectView(Context context)
    {
        Class<?> clazz=context.getClass();
        //获取到Activity里面所有的成员变量
        Field[] fields=clazz.getDeclaredFields();
        for (Field field:fields)
        {
            //得到成员变量的注解
            ViewInject viewInject=field.getAnnotation(ViewInject.class);
            if(viewInject!=null)
            {
                /**
                 * 获取id 比如
                 * @ViewInject(R.id.tv_username)
                   TextView tv_username;
                   valueId= R.id.tv_username
                 */
                int valueId=viewInject.value();
                try {
                    Method method=clazz.getMethod(Constant.FINDVIEWBYID.getName(),int.class);
                    View view= (View) method.invoke(context,valueId);
                    field.setAccessible(true);
                    field.set(context,view);
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

    public static void injectLayout(Context context)
    {
        int layoutId;
        Class<?> clazz=context.getClass();
        //获取Activity类上面的注解
        ContentView contentView=clazz.getAnnotation(ContentView.class);
        if (contentView != null ) {
            layoutId=contentView.value();
            try {
                Method method=clazz.getMethod(Constant.SETCONTENTVIEW.getName(),int.class);
                method.invoke(context,layoutId);
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
