package com.example.jiaoshiduan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class GerenActivity extends AppCompatActivity {
    private Button home1;
    private Button tiao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_geren);
        final Button loginButton=findViewById(R.id.home1);
        final Button Tiao=findViewById(R.id.tiao);


        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(GerenActivity.this,homeActivity.class));
            }
        });
        Tiao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(GerenActivity.this,MActivity.class));
            }
        });
    }
}
