package com.suo.myhello;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class ForthActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        System.out.println("ForthActivity.onCreate()");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forth);

    }

    @Override
    protected void onStart() {
        System.out.println("ForthActivity.onStart()");
        super.onStart();
    }

    @Override
    protected void onRestart() {
        System.out.println("ForthActivity.onRestart()");
        super.onRestart();
    }

    @Override
    protected void onResume() {
        System.out.println("ForthActivity.onResume()");
        super.onResume();
    }

    @Override
    protected void onPause() {
        System.out.println("ForthActivity.onPause()");
        super.onPause();
    }


    @Override
    protected void onStop() {
        System.out.println("ForthActivity.onStop()");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        System.out.println("ForthActivity.onDestroy()");
        super.onDestroy();
    }


    public void doClick42(View v){
        //返回上一个activity，并传递参数
      EditText etReturn = (EditText)findViewById(R.id.et_ret_value);
      Intent intent =new Intent();
      intent.putExtra("retMsg",etReturn.getText().toString());
        setResult(RESULT_OK,intent);
        finish();
        }

        }
