package com.example.se;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.List;

import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;
import cn.bmob.v3.listener.SaveListener;

public class RegisterActivity extends AppCompatActivity {

    private Button mBtnregister,mBtnreturn;
  //  private MyDatabaseHelper myDBHelper;
    private EditText mEdtname,mEdtid,mEdtpassword,mEdtphone,mEdtage,realid,mmail,nianxian,lingyu,shiling,jieshao;
    private RadioGroup mRadsex;
    private RadioButton mRadbtn;
    private String selectsex;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        //各文本框实例化
        mEdtname = (EditText)findViewById(R.id.edT1) ;
        mEdtid = (EditText)findViewById(R.id.edT2) ;
        mEdtpassword = (EditText)findViewById(R.id.edT3) ;
        mEdtage = (EditText)findViewById(R.id.edT6) ;
        mEdtphone = (EditText)findViewById(R.id.edT7) ;
        mRadsex = (RadioGroup)findViewById(R.id.rdG);
        realid =  (EditText) findViewById(R.id.id_2);
        mmail = findViewById(R.id.mail_1);
        nianxian = findViewById(R.id.nianxian_1);
        lingyu = findViewById(R.id.lingyu_1);
        shiling = findViewById(R.id.shiling_1);
        jieshao = findViewById(R.id.jianjie_1);

        //男女选项监听事件
        mRadsex.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                selectsex = selectRadioBtn();
            }
        });
        //按钮事件
        //注册键向数据库中插入信息
        mBtnregister = (Button)findViewById(R.id.btn_register);
        mBtnregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isTrue = true;
                final String username = mEdtname.getText().toString().trim();
                final String password = mEdtpassword.getText().toString().trim();
                final String yonghuming = mEdtid.getText().toString().trim();
               // final String email = emailET.getText().toString().trim();
                final String mobile_phone_num = mEdtphone.getText().toString().trim();
                //final String child_name = child_nameET.getText().toString().trim();
                final String teacher_age = mEdtage.getText().toString().trim();
                final String real_id = mEdtage.getText().toString().trim();
                final String mail = mmail.getText().toString().trim();
                final String nian = nianxian.getText().toString().trim();
                final String ling = lingyu.getText().toString().trim();
                final String shi = shiling.getText().toString().trim();
                final String jianjie = jieshao.getText().toString().trim();
                //final String child_sex = child_sexET.getText().toString().trim();
                //final String parents_name = parents_nameET.getText().toString().trim();
                //final String parents_contact_information = parents_contact_informationET.getText().toString().trim();
                if ((mEdtname.getText().toString()).equals("请输入姓名")) {
                    isTrue = false;
                    Toast.makeText(RegisterActivity.this, "姓名不能为空", Toast.LENGTH_SHORT).show();
                }
                if ((mEdtname.getText().toString()).equals("请输入姓名")) {
                    isTrue = false;
                    Toast.makeText(RegisterActivity.this, "姓名不能为空", Toast.LENGTH_SHORT).show();
                }
                if ((shiling.getText().toString()).equals("请输入教育适合年龄")) {
                    isTrue = false;
                    Toast.makeText(RegisterActivity.this, "教育适合年龄不能为空", Toast.LENGTH_SHORT).show();
                }
                if ((nianxian.getText().toString()).equals("请输入教育年限")) {
                    isTrue = false;
                    Toast.makeText(RegisterActivity.this, "教育年限不能为空", Toast.LENGTH_SHORT).show();
                }
                if ((realid.getText().toString()).equals("请输入身份证号")) {
                    isTrue = false;
                    Toast.makeText(RegisterActivity.this, "身份证号不能为空", Toast.LENGTH_SHORT).show();
                }
                if ((jieshao.getText().toString()).equals("请输入个人简介")) {
                    isTrue = false;
                    Toast.makeText(RegisterActivity.this, "个人简介不能为空", Toast.LENGTH_SHORT).show();
                }
                if ((mEdtid.getText().toString()).length()==0) {
                    isTrue = false;
                    Toast.makeText(RegisterActivity.this, "用户名不能为空", Toast.LENGTH_SHORT).show();
                }
                if ((mEdtpassword.getText().toString()).length()==0) {
                    isTrue = false;
                    Toast.makeText(RegisterActivity.this, "密码不能为空", Toast.LENGTH_SHORT).show();
                }
                if ((mEdtage.getText().toString()).length()==0) {
                    isTrue = false;
                    Toast.makeText(RegisterActivity.this, "年龄不能为空", Toast.LENGTH_SHORT).show();
                }
                if ((mmail.getText().toString()).length()==0) {
                    isTrue = false;
                    Toast.makeText(RegisterActivity.this, "邮箱不能为空", Toast.LENGTH_SHORT).show();
                }
                if ((lingyu.getText().toString()).length()==0) {
                    isTrue = false;
                    Toast.makeText(RegisterActivity.this, "教育领域不能为空", Toast.LENGTH_SHORT).show();
                }
                if (isTrue = true) {
                    BmobQuery<Teacher_Information> query = new BmobQuery<Teacher_Information>();
                    query.addWhereEqualTo("username", mEdtname);
                    query.findObjects(new FindListener<Teacher_Information>() {
                        @Override
                        public void done(List<Teacher_Information> list, BmobException e) {
                            if (e != null) {
                                Toast.makeText(RegisterActivity.this, "数据库查找有异常", Toast.LENGTH_LONG).show();
                            } else {
                                if(!list.isEmpty()){
                                    Toast.makeText(RegisterActivity.this, mEdtname+"兄dei~用户名重复", Toast.LENGTH_LONG).show();
                                }
                                else {//用户名没有重复，则把数据上传数据库
                                    Toast.makeText(RegisterActivity.this, "正在上传"+list.size(), Toast.LENGTH_LONG).show();
                                    Teacher_Information teacher_information = new Teacher_Information();

                                    teacher_information.setIntroducation(jianjie);
                                    teacher_information.setFit_age(shi);
                                    teacher_information.setYears(nian);
                                    teacher_information.setArea(ling);
                                  teacher_information.setName(username);
                                  teacher_information.setId(yonghuming);
                                  teacher_information.setMail(mail);
                                  teacher_information.setReal_id(real_id);
                                    teacher_information.setPassword(password);
                                   teacher_information.setAge(teacher_age);
                                teacher_information.setSex(selectsex);
                                teacher_information.setPhone(mobile_phone_num);
                                    teacher_information.save(new SaveListener<String>() {
                                        @Override
                                        public void done(String s, BmobException e) {
                                            if (e!=null){
                                                Toast.makeText(RegisterActivity.this,e.getMessage(),Toast.LENGTH_LONG).show();
                                            }else {
                                                Toast.makeText(RegisterActivity.this,"success",Toast.LENGTH_LONG).show();
                                            }
                                        }
                                    });
                                }
                            }
                        }
                    });
                }
/*
                if (isTrue = true) {
                    //打开数据库
                    myDBHelper = new MyDatabaseHelper(RegisterActivity.this);
                    SQLiteDatabase db = myDBHelper.getWritableDatabase();
                    String id = mEdtid.getText().toString();
                    Cursor c = db.rawQuery("select name from Person where perid=?", new String[]{mEdtid.getText().toString()});
                    //如果有查询到数据，则说明账号已存在
                    if (c != null && c.getCount() >= 1) {
                        Toast.makeText(RegisterActivity.this, "该学号/教工号已经注册", Toast.LENGTH_LONG).show();
                        c.close();
                    } else {
                        //插入至数据库
                        ContentValues values = new ContentValues();
                        values.put("name", mEdtname.getText().toString());
                        values.put("perid", mEdtid.getText().toString());
                        values.put("password", mEdtpassword.getText().toString());
                        values.put("sex", selectsex);
                        values.put("age", mEdtage.getText().toString());
                        values.put("phone", mEdtphone.getText().toString());
                        db.insert("Person", null, values);
                        //弹出提示框
                        Toast.makeText(RegisterActivity.this, "注册成功", Toast.LENGTH_LONG).show();
                        //返回页面
                        RegisterActivity.this.finish();
                    }
                    db.close();
                }
                */
            }
        }
        );
        //返回键结束当前页面


        mBtnreturn = (Button)findViewById(R.id.btn_return);
        mBtnreturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //RegisterActivity.this.finish();
                Intent intent = new Intent(RegisterActivity.this,TeacherloginActivity.class);
                startActivity(intent);
            }
        });

    }
    private String selectRadioBtn(){
        mRadbtn = (RadioButton)findViewById(mRadsex.getCheckedRadioButtonId());
        return mRadbtn.getText().toString();
    }
}
