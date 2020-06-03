package com.example.jiaoshiduan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;

public class GerenActivity extends AppCompatActivity {
    private Button home1;
    private Button tiao;
    private Button home3;
    private SharedPreferences pref;
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_geren);
        final Button loginButton=findViewById(R.id.home1);
        final Button Tiao=findViewById(R.id.tiao);
        final Button loginButton1=findViewById(R.id.home3);


        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(GerenActivity.this,homeActivity.class));
            }
        });
        Tiao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = pref.edit();
                editor.clear();
                editor.commit();
                startActivity(new Intent(GerenActivity.this,MActivity.class));
            }
        });
        loginButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(GerenActivity.this,Dashboard.class));
            }
        });
    }
}
