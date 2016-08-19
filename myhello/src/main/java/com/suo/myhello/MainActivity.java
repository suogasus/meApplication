package com.suo.myhello;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//
//        Button bt = (Button) findViewById(R.id.m_button);
//        bt.setOnClickListener(new View.OnClickListener() {
//            @Override //匿名内部类  监听回调
//            public void onClick(View v) {
//                System.out.println("按钮被点击了");
//                Log.i("我的第一个android应用","按钮被点击了");
//                Log.e("error","程序发生严重问题");
//                //当按钮点击的时候，处理
//                Toast.makeText(MainActivity.this,"按钮被点击",Toast.LENGTH_LONG).show();
//            }
//        });
//        setContentView(R.layout.my_frame_layout);
//
//        Button bt1 = (Button)findViewById(R.id.bt1);
//        Button bt2 = (Button)findViewById(R.id.bt2);
//
//        bt1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //没有强制转过
//                findViewById(R.id.fbt1).setVisibility(View.VISIBLE);
//                findViewById(R.id.fbt2).setVisibility(View.GONE);
//            }
//        });
//
//        bt2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                findViewById(R.id.fbt1).setVisibility(View.GONE);
//                findViewById(R.id.fbt2).setVisibility(View.VISIBLE);
//            }
//        });

    }

}
