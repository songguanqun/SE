package com.example.se;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;

public class TeacherloginActivity extends AppCompatActivity {



    private Button mBtnexit;
    private Button mBforget;

    private Button mBtnButton;  //声明空间
    private Button mBtnTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacherlogin);
        Bmob.initialize(this,"2ccc6140687a4b195b74023bd2a0d248");
        /*mBtnTextView = findViewById(R.id.btn_textview);
        mBtnTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //跳转到TextView演示
                Intent intent = new Intent(TeacherloginActivity.this, TextViewActivity.class);
                startActivity(intent);
            }
        });
        */
        /*
        mBtnButton = findViewById(R.id.btn_1);  //找到空间
        mBtnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //跳转到Buttonactivity
                Intent intent = new Intent(TeacherloginActivity.this,ButtonActivity.class);
                startActivity(intent);
            }
        });
        */
        mBforget = findViewById(R.id.btn_forgetpassword);
        mBforget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TeacherloginActivity.this,ForgottonActivity.class);
                startActivity(intent);
            }
        });
        mBtnexit = findViewById(R.id.btn_2);
        mBtnexit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //转到Exit界面
                Intent intent = new Intent(TeacherloginActivity.this,RegisterActivity.class);
                startActivity(intent);
            }
        });



        final EditText edT2 = (EditText) findViewById(R.id.edT2);//用户名
        final EditText edT1 = (EditText) findViewById(R.id.edT1);//密码


        Button btn = findViewById(R.id.btn_login);

        //登录按钮监听
        btn.setOnClickListener(new View.OnClickListener() {


                                   @Override
                                   public void onClick(View v) {
                                       final String username = edT2.getText().toString().trim();
                                       final String password = edT1.getText().toString().trim();


                                       BmobQuery<Teacher_Information> query = new BmobQuery<Teacher_Information>();
                                       query.addWhereEqualTo("id", username);
                                       query.findObjects(new FindListener<Teacher_Information>() {
                                       @Override
                                         public void done(List<Teacher_Information> list, BmobException e) {
                                           if (e != null) {
                                             Toast.makeText(TeacherloginActivity.this, "数据库查找有异常", Toast.LENGTH_LONG).show();
                                       } else {

                                       if (list.isEmpty()) {
                                           //if (list.isEmpty()) {
                                           Toast.makeText(TeacherloginActivity.this,"用户名不存在", Toast.LENGTH_LONG).show();
                                       } else {//用户名没有重复，则把数据上传数据库//加判空
                                if(list.get(0).getPassword().equals(password)){
                                    Intent intent = new Intent(TeacherloginActivity.this, ExitActivity.class);
                                    startActivity(intent);
                                    finish();
                                }else {
                                    Toast.makeText(TeacherloginActivity.this, "密码错误", Toast.LENGTH_LONG).show();
                                           Toast.makeText(TeacherloginActivity.this, "!", Toast.LENGTH_LONG).show();
                                       }
                                   }



                        }
                   }
                });

            }
        });

    }
}





