package com.example.jiaoshiduan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class GerenActivity extends AppCompatActivity {
    private Button home1;
    private Button Tiao,xiugai;
    private SharedPreferences pref;
    private SharedPreferences.Editor editor;
    private EditText mEtUsername,mEtPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_geren);
        final Button loginButton=findViewById(R.id.home1);
        final Button Tiao=findViewById(R.id.tiao);
        final Button xiugai=findViewById(R.id.text3);
        mEtUsername = findViewById(R.id.cont2);
        mEtPassword = findViewById(R.id.cont4);
        SharedPreferences pref=getSharedPreferences("cb_auto",MODE_PRIVATE);
        String name=pref.getString("name","");
        String password=pref.getString("password","");
        mEtUsername.setText(name);
        mEtPassword.setText(password);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(GerenActivity.this,homeActivity.class));
            }
        });
        Tiao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences pref=getSharedPreferences("cb_auto",MODE_PRIVATE);
                if(pref!=null){
                    pref.edit().clear().commit();}
                startActivity(new Intent(GerenActivity.this,MActivity.class));
            }
        });
        xiugai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(GerenActivity.this,ModifyPswActivity.class));
            }
        });

    }
}
