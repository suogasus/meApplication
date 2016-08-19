package com.suo.mysqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.suo.mysqlite.bean.Student;
import com.suo.mysqlite.db.MyDBOpenHelper;

import java.util.ArrayList;

/**
 * Created by la on 2016/8/17.
 */
public class StudentDAO {

    private MyDBOpenHelper dbHelper;
    public StudentDAO(Context context){
        dbHelper = new MyDBOpenHelper(context);
    }
    public boolean insertStudent(Student student){
        boolean isSuccess = false;
        SQLiteDatabase db=dbHelper.getReadableDatabase();
        try{
        ContentValues values = new ContentValues();
//        values.put("id",student.id); //与mysql不一样，不管你有没有设置，这里最好去掉
        values.put("name",student.name);

        db.insert("student",null,values);
            isSuccess = true;
        }catch(Exception e){
            isSuccess= false;
        }
        return isSuccess;
    }

    public boolean deleteStudent(String name){
        boolean isSuccess = false;
        SQLiteDatabase db = dbHelper.getReadableDatabase();

         try{
             ContentValues values = new ContentValues();
           String[] args= {String.valueOf(name)};
             db.delete("student","name=?",args);
             isSuccess = true;
         }catch(Exception e){
             isSuccess= false;
         }

        return isSuccess;
    }

    public ArrayList<Student> queryStudentByName(String name){
        ArrayList<Student> studentList = null;
        SQLiteDatabase db = dbHelper.getReadableDatabase();
       Cursor c= db.query("student",new String[]{"id","name"}," name like ? ",new String[]{"%"+name+"%"},null,null,null);
       while (c.moveToNext()){
           int id = c.getInt(c.getColumnIndex("id"));
           String nameInDB = c.getString(c.getColumnIndex("name"));

           Student student = new Student();
           student.id= id;
           student.name=nameInDB;

           if(studentList == null ){
            studentList = new ArrayList<Student>();
           }

           studentList.add(student);

       }

        return studentList;
    }
}
