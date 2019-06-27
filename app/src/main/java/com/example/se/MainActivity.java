package com.example.se;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.List;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;
import cn.bmob.v3.listener.SaveListener;

public class MainActivity extends AppCompatActivity {
    RadioGroup rg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button identity_determine = (Button) findViewById(R.id.identity_determine);
        identity_determine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rg = (RadioGroup)findViewById(R.id.identity);
                for(int i=0;i<rg.getChildCount();i++){
                    RadioButton radioButton = (RadioButton) rg.getChildAt(i);
                    if(radioButton.isChecked()){
                        if(radioButton.getText().equals("学生家长")){
                           // Intent intent = new Intent(MainActivity.this,ParentsLogin.class);
                            //startActivity(intent);
                        }else{
                            if(radioButton.getText().equals("教育机构")){
                                Toast.makeText(MainActivity.this,radioButton.getText().toString(),Toast.LENGTH_SHORT).show();
                            }else{
                                if (radioButton.getText().equals("教师")) {
                                    Toast.makeText(MainActivity.this,"教师",Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(MainActivity.this,TeacherloginActivity.class);
                                    startActivity(intent);
                                }
                                else {
                                    Toast.makeText(MainActivity.this,"管理员",Toast.LENGTH_SHORT).show();
                                }
                            }
                        }
                    }
                }
            }
        });
    }





    //注释掉的部分都是关于数据库的操作，觉得没用就删了吧
        /*
        //数据库初始化
        Bmob.initialize(this,"2ccc6140687a4b195b74023bd2a0d248");


        Person person = new Person();
        person.setName("xzq");
        person.setAddress("address");
        person.save(new SaveListener<String>() {
            @Override
            public void done(String s, BmobException e) {
                if (e!=null){
                    Toast.makeText(MainActivity.this,e.getMessage(),Toast.LENGTH_LONG).show();
                }else {
                    Toast.makeText(MainActivity.this,"success",Toast.LENGTH_LONG).show();
                }
            }
        });
        BmobQuery<Person> query = new BmobQuery<Person>();
        query.addWhereEqualTo("name", "xzq");
        query.findObjects(new FindListener<Person>() {
            @Override
            public void done(List<Person> list, BmobException e) {
                if (e != null){
                    Toast.makeText(MainActivity.this,"chabudaoya",Toast.LENGTH_LONG).show();
                }else {
                    for (Person person : list) {
                        Toast.makeText(MainActivity.this, person.getObjectId().toString(), Toast.LENGTH_LONG).show();

                    }
                }
            }
        });
        //Person person = new Person();
        //person.setName("mzn");
        //person.
    */

}//这个大括号是oncreate函数的结束

    /*
    private  void show(String msg){
        Toast.makeText(MainActivity.this,msg,Toast.LENGTH_LONG).show();
    }
    */


