package com.test;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.ioc.annontion.ContentView;
import com.ioc.annontion.ViewInject;
import com.ioc.annontion.event.OnClick;
import com.ioc.annontion.event.OnItemClick;
import com.ioc.annontion.event.OnLongClick;
import com.ioc.annontion.event.OnTouchView;
import com.test.base.BaseActivity;
import java.util.ArrayList;
import java.util.List;
@ContentView(R.layout.activity_main)
public class MainActivity extends BaseActivity {
    @ViewInject(R.id.tv_username)
    TextView tv_username;
    @ViewInject(R.id.tv_password)
    TextView tv_password;
    @ViewInject(R.id.btn_login)
    private Button btn_login;
    @ViewInject(R.id.listview)
    private ListView listview;
    private List<String> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        list = new ArrayList<>();
        list.add("ioc---1");
        list.add("ioc---2");
        tv_username.setText("zhouguizhi");
        tv_password.setText("123456");
        listview.setAdapter(new MyAdapter());
    }
    @OnClick(R.id.tv_username)
    public void onClick(View view)
    {
        Toast.makeText(this,"用户名是:"+"zhouguizhi",Toast.LENGTH_SHORT).show();
    }
    @OnLongClick(R.id.tv_password)
    public  boolean click(View view)
    {
        Toast.makeText(this,"密码是:"+123456,Toast.LENGTH_SHORT).show();
        return true;
    }
    @OnTouchView(R.id.btn_login)
    public boolean touch(View view,MotionEvent event){
        Toast.makeText(this,"请登录",Toast.LENGTH_SHORT).show();
        return true;
    }
    @OnItemClick(R.id.listview)
    public  void itemClick(AdapterView<?> parent, View view, int position, long id)
    {
        Toast.makeText(this,list.get(position),Toast.LENGTH_SHORT).show();
    }
    class MyAdapter extends BaseAdapter{
        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            TextView textView = new TextView(MainActivity.this);
            textView.setGravity(Gravity.CENTER);
            textView.setText(list.get(position));
            return textView;
        }
    }
}
