package com.example.se;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class ExitActivity extends AppCompatActivity {


    private RadioButton radioButton1;
    private RadioButton radioButton2;
    private Button mbtn6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exit);
        mbtn6 = findViewById(R.id.btn_6);
        mbtn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ExitActivity.this,"注册成功！",Toast.LENGTH_LONG).show();
                Intent intent = new Intent(ExitActivity.this,TeacherloginActivity.class);
                startActivity(intent);
            }
        });
        radioButton1 = findViewById(R.id.radioButton_1);
        radioButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ExitActivity.this,"所选为男！",Toast.LENGTH_LONG).show();
            }
        });
        radioButton2 = findViewById(R.id.radioButton_2);
        radioButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ExitActivity.this,"所选为女！",Toast.LENGTH_LONG).show();
            }
        });

    }



}
