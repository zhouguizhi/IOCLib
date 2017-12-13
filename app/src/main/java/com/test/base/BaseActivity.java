package com.test.base;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import com.ioc.IocInject;
/**
 * Created by zhouguizhi on 2017/12/13.
 */
public class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        IocInject.initInject(this);
    }
}
