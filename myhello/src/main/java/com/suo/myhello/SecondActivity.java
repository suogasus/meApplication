package com.suo.myhello;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

                                      final EditText et = (EditText) findViewById(R.id.et_text);
        //从一个activity进入下一个activity ，传递参数： 资料编辑进入分页面
        Button bt23 =(Button) findViewById(R.id.sec_three_button);

        if( bt23 != null){
            bt23.setOnClickListener(new View.OnClickListener() {//匿名内部类的对象监听
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(SecondActivity.this,ThirdActivity.class);//反射类，并建立一个对象实例
                     String msg =et.getText().toString();
                    //把数据绑定到intent
                    Log.i("获取EditText文本",msg);
                    intent.putExtra("msg",msg);
                    //启动第二个activity
                    startActivity(intent);
                }
            });}else{
            Toast.makeText(SecondActivity.this,"没有找到该按钮",Toast.LENGTH_LONG).show();
        }
    }


    @Override
    protected void onRestart() {
        System.out.println("SecondActivity.onRestart()");
        super.onRestart();
    }

    @Override
    protected void onResume() {
        System.out.println("SecondActivity.onResume()");
        super.onResume();
    }

    @Override
    protected void onPause() {
        System.out.println("SecondActivity.onPause()");
        super.onPause();
    }


    @Override
    protected void onStop() {
        System.out.println("SecondActivity.onStop()");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        System.out.println("SecondActivity.onDestroy()");
        super.onDestroy();
    }




//从一个activity进入下一个activity, 然后返回获取下一个activity的数据: 头像上传/资料编辑返回总页面

    public void  doClick24(View v){
     //建立意图通道
        Intent intent = new Intent(SecondActivity.this,ForthActivity.class);////反射类，并建立一个对象实例

        startActivityForResult(intent,1);//识别是哪一个activity返回的数据


    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
       if(resultCode == RESULT_OK){
           //第二个activity获取数据成功
           String retMsg = data.getStringExtra("retMsg");
           //设置到街面上
           EditText et2 = (EditText)findViewById(R.id.et_text2);
           et2.setText(retMsg);
       }

        super.onActivityResult(requestCode, resultCode, data);
    }
}
