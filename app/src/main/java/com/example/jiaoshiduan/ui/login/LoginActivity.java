package com.example.jiaoshiduan.ui.login;

import android.app.Activity;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.appcompat.app.AppCompatActivity;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jiaoshiduan.MActivity;
import com.example.jiaoshiduan.MainActivity;
import com.example.jiaoshiduan.R;
import com.example.jiaoshiduan.ui.login.LoginViewModel;
import com.example.jiaoshiduan.ui.login.LoginViewModelFactory;

public class LoginActivity extends AppCompatActivity {
    private Button  login_button11;
    private LoginViewModel loginViewModel;
    private EditText name;
    private EditText password;
    private EditText password1;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        loginViewModel = ViewModelProviders.of(this, new LoginViewModelFactory())
                .get(LoginViewModel.class);

        name= findViewById(R.id.name);
        password= findViewById(R.id.password);
        password1= findViewById(R.id.password1);
        login_button11= findViewById(R.id.login_button11);
        if (password.getText().toString().equals(password1.getText().toString())){
        login_button11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //开启一个新界面 activity的意思就是指界面
                startActivity(new Intent(LoginActivity.this, MActivity.class));
            }
        });}else{
            Toast.makeText(LoginActivity.this,"两次输入密码错误",Toast.LENGTH_SHORT).show();
        }


    }
}
