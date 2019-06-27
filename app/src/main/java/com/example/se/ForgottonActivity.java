package com.example.se;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;

public class ForgottonActivity extends AppCompatActivity {

    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgotton);


        /*
        final EditText forget_1 = (EditText) findViewById(R.id.forget_xuehao);//用户名
        final EditText forget_2 = (EditText) findViewById(R.id.forget_dianhua);//电话
        final EditText forget_3 = (EditText) findViewById(R.id.forget_youxiang);//邮箱

        btn = findViewById(R.id.foget_queren);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String username = forget_1.getText().toString().trim();
                final String phone = forget_2.getText().toString().trim();
                final String mail = forget_3.getText().toString().trim();

                BmobQuery<Teacher_Information> query = new BmobQuery<Teacher_Information>();
                query.addWhereEqualTo("id", username);
                query.findObjects(new FindListener<Teacher_Information>() {
                    @Override
                    public void done(List<Teacher_Information> list, BmobException e) {
                        if (e != null) {
                            Toast.makeText(ForgottonActivity.this, "数据库查找有异常", Toast.LENGTH_LONG).show();
                        } else {


                            if (list.isEmpty()) {
                                if (list.isEmpty()) {
                                    Toast.makeText(ForgottonActivity.this, "用户名不存在", Toast.LENGTH_LONG).show();
                                } else {


                                    if (list.get(0).getPhone().equals(phone) && list.get(0).getMail().equals(mail)) {
                                        Toast.makeText(ForgottonActivity.this, "密码是" + list.get(0).getPassword().toString(), Toast.LENGTH_LONG).show();

                                    } else {

                                        Toast.makeText(ForgottonActivity.this, "电话或者邮箱错误", Toast.LENGTH_LONG).show();
                                        Toast.makeText(ForgottonActivity.this, "!", Toast.LENGTH_LONG).show();
                                    }
                                }


                            }
                        }
                    }
                });


            }
        });
        */
        //获取文本框输入
        final EditText usernameET = (EditText) findViewById(R.id.forget_xuehao);
        final EditText emailET = (EditText) findViewById(R.id.forget_youxiang);
        final EditText mobilenumET = (EditText) findViewById(R.id.forget_dianhua);
        //提交按钮监听
        Button submit = (Button) findViewById(R.id.foget_queren);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //获取文本框中内容trim为过滤前后空格/回车
                final String username = usernameET.getText().toString().trim();
                final String email = emailET.getText().toString().trim();
                final String mobile_phone_num = mobilenumET.getText().toString().trim();
                //判断是否为空
                if(username.equals("")||email.equals("")||mobile_phone_num.equals("")){
                    Toast.makeText(ForgottonActivity.this,"请将信息填写完整",Toast.LENGTH_SHORT).show();
                }/*else {//判断了下手机号
                    if (mobile_phone_num.length()!=11){
                        Toast.makeText(ForgottonActivity.this,"请输入11位的手机号",Toast.LENGTH_SHORT).show();
                    }*/
                    else{
                        //查数据库
                        BmobQuery<Teacher_Information> query = new BmobQuery<Teacher_Information>();
                        query.addWhereEqualTo("id", username);
                        query.findObjects(new FindListener<Teacher_Information>() {
                            @Override
                            public void done(List<Teacher_Information> list, BmobException e) {
                                if (e != null) {
                                    Toast.makeText(ForgottonActivity.this, "数据库查找有异常", Toast.LENGTH_LONG).show();
                                } else {
                                    if (list.isEmpty()) {
                                        Toast.makeText(ForgottonActivity.this,  "用户名不存在", Toast.LENGTH_LONG).show();
                                    } else {//用户名没有重复，则把数据上传数据库//加判空
                                        if(list.get(0).getMail().equals(email)&&list.get(0).getPhone().equals(mobile_phone_num)){
                                            Toast.makeText(ForgottonActivity.this, "密码为："+list.get(0).getPassword(), Toast.LENGTH_LONG).show();
                                            Intent intent = new Intent(ForgottonActivity.this, TeacherloginActivity.class);
                                            startActivity(intent);
                                            finish();
                                        }else {
                                            Toast.makeText(ForgottonActivity.this, "找回密码失败，请输入正确邮箱/手机号", Toast.LENGTH_LONG).show();
                                        }
                                    }
                                }
                            }
                        });
                    }
                }

        });
    }
}
