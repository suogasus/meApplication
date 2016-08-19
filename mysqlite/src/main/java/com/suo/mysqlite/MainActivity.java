package com.suo.mysqlite;

import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.suo.mysqlite.bean.Student;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btSubmit = (Button)findViewById(R.id.bt_submit);
        btSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //获得输入框姓名
                EditText etName = (EditText)findViewById(R.id.et_name);
                String name = etName.getText().toString();
                //保存到数据库中

                Student student = new Student();
                student.name = name;

                StudentDAO dao = new StudentDAO(MainActivity.this);
                boolean isSuccess = dao.insertStudent(student);

                System.out.println("执行到toast之前？");
                Toast.makeText(MainActivity.this,isSuccess?"插入学生数据成功":"插入学生数据失败",Toast.LENGTH_LONG).show();

            }
        });

        Button btDelete = (Button)findViewById(R.id.bt_delete);
        btDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //获得输入框姓名
                EditText etName = (EditText)findViewById(R.id.et_name);
                String name = etName.getText().toString();

                StudentDAO dao = new StudentDAO(MainActivity.this);

                boolean isSuccess = dao.deleteStudent(name);
                Toast.makeText(MainActivity.this,isSuccess?"删除学生数据成功":"删除学生数据失败",Toast.LENGTH_LONG).show();



            }
        });

        Button btQuery = (Button)findViewById(R.id.bt_query);
        btQuery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //获得输入框姓名
                EditText etName = (EditText)findViewById(R.id.et_name);
                String name = etName.getText().toString();

                StudentDAO dao = new StudentDAO(MainActivity.this);
               ArrayList<Student> studentList = dao.queryStudentByName(name);
                String names ="";
                if (studentList == null){
                    Toast.makeText(MainActivity.this,"没有查询到",Toast.LENGTH_LONG).show();
                }else{
                    for(Student student:studentList){
                    names +=student.name+"\n";
                    }
                  Toast.makeText(MainActivity.this,names,Toast.LENGTH_LONG).show();
                }
            }
        });

        ImageView ivCastle = (ImageView)findViewById(R.id.iv_an_castle);

//        ivCastle.setImageResource(R.drawable.castle1);

//        ivCastle.setImageBitmap(BitmapFactory.decodeResource(getResources(),R.drawable.castle));

          ivCastle.setImageDrawable(getResources().getDrawable(R.drawable.cup1));


        ivCastle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        final ImageView ivTree = (ImageView)findViewById(R.id.iv_tree);

        final ToggleButton tb_button = (ToggleButton)findViewById(R.id.tb_button);

        tb_button.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                 ivTree.setImageResource(isChecked?R.drawable.tree_watercolor:-1);
            }
        });
    }
}
