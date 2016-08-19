package com.suo.myhello;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by la on 2016/7/21.
 */
public class ThirdActivity extends AppCompatActivity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_third);

        //获得上个界面传递过来的参数，并表示
        Intent intent = getIntent();
//        String msg = intent.getStringExtra("msg");
//        TextView tv = (TextView)findViewById(R.id.tv_second_value);
//        if(null != tv){
//            tv.setText(msg);
//        }

        LinearLayout ll= new LinearLayout(this);//挂载在当前的activity下:容器
        ll.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT));
        ll.setOrientation(LinearLayout.VERTICAL);

        TextView tv1 = new TextView(this);
        tv1.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        tv1.setText(R.string.hello);
        EditText et= new EditText(this);
        et.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        Button bt = new Button(this);
        bt.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        bt.setText(R.string.m_button);

        ll.addView(tv1);
        ll.addView(et);
        ll.addView(bt);

        setContentView(ll);

    }


}
