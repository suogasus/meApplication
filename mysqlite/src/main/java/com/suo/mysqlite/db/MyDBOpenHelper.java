package com.suo.mysqlite.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by la on 2016/8/17.
 */
public class MyDBOpenHelper extends SQLiteOpenHelper{
//在一个类创建的时候，都会有默认构造方法,没有参数
    //有继承其他类的时候，都会继承父类的构造方法，
    //只要写一个构造方法，默认构造方法就没有了，如果有类的继承关系的话
    //对象实例化的时候，默认的构造方法必须得调

    public MyDBOpenHelper(Context context){
        super(context,"mydb.sqlite",null,1);//父类的构造方法
        //1、上下文，由MyDBOpenHelper的调用者提供
        //2、数据库的名字，
        //3、游标工厂，
        //4、数据库的版本，用来管理应用升级过程中，如果数据库也会有改变的时候，会根据版本做升级
    }

    public MyDBOpenHelper(Context context, String dbName, SQLiteDatabase.CursorFactory cf, int version){
        super(context,dbName,cf,1);
        //上下文，数据库的名字，游标工厂，版本
    }

    //当第一次访问mydb.sqlite数据库时候调用(mydb.sqlite这个文件并不存在的时候)，一旦这个文件已经存在了，此方法不再调用
    @Override
    public void onCreate(SQLiteDatabase db){
        //创建表，插入基础数据
        String sql = "create table student(id integer not null primary key autoincrement, name text not null)";
        db.execSQL(sql);
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
     if(oldVersion == 1 && newVersion == 2){
         String sql = "create table teacher (id integer not null primary key autoincrement, name text not null)";
         db.execSQL(sql);
     }
    }

}
