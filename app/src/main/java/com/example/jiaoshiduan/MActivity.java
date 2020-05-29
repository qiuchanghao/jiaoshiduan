package com.example.jiaoshiduan;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.jiaoshiduan.ui.home.HomeFragment;
import com.example.jiaoshiduan.ui.login.LoginActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MActivity extends AppCompatActivity {
    private EditText name;
    private EditText password;
    private Button login_button;
    private Button login_button1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_m);
        name= findViewById(R.id.name);
        password= findViewById(R.id.password);
        login_button= findViewById(R.id.login_button);
        login_button1= findViewById(R.id.login_button1);
        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strUsername=password.getText().toString();
                String strPassword=password.getText().toString();
                if (strUsername.equals("admin")&&strPassword.equals("admin")){
                    Toast.makeText(MActivity.this,"用户名密码正确",Toast.LENGTH_SHORT).show();
                  startActivity(new Intent(MActivity.this,homeActivity.class));//显示吓一跳页面
                }else {
                    Toast.makeText(MActivity.this,"用户名或密码错误",Toast.LENGTH_SHORT).show();
                }
            }
        });
        login_button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //开启一个新界面 activity的意思就是指界面
                startActivity(new Intent(MActivity.this, LoginActivity.class));
            }
        });
    }
}
