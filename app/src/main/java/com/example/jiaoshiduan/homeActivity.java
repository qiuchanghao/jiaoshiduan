package com.example.jiaoshiduan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class homeActivity extends AppCompatActivity implements View.OnClickListener {
    private MySQL penHelper;
    private Button tijia;
    private EditText c1;
    private EditText c2;
    private EditText c3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        initView();
        penHelper = new MySQL(this);
        final Button loginButton = findViewById(R.id.home2);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(homeActivity.this, GerenActivity.class));
            }
        });
        final Button loginButton1=findViewById(R.id.chaxun);
        loginButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(homeActivity.this,Dashboard.class));
            }
        });
    }
    private void initView(){
        tijia = findViewById(R.id.tijiao);
        c1 = findViewById(R.id.name);
        c2 = findViewById(R.id.type);
        c3 = findViewById(R.id.rank);
        tijia.setOnClickListener(this);
    }
    public void onClick (View view){
        switch (view.getId()) {
            case R.id.tijiao:
                String name = c1.getText().toString().trim();
                String type = c2.getText().toString().trim();
                String rank = c3.getText().toString().trim();
                if (!TextUtils.isEmpty(name) && !TextUtils.isEmpty(type) && !TextUtils.isEmpty(rank)) {
                    penHelper.add(name,type,rank);
                    startActivity(new Intent(homeActivity.this,Dashboard.class));
                    Toast.makeText(this, "验证通过，提交成功", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "信息未完善，提交失败", Toast.LENGTH_SHORT).show();
                }
        }
    }

}

