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
import android.text.TextUtils;
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
import com.example.jiaoshiduan.SqliteOpenHelper;
import com.example.jiaoshiduan.ui.login.LoginViewModel;
import com.example.jiaoshiduan.ui.login.LoginViewModelFactory;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    private String realCode;
    private SqliteOpenHelper mDBOpenHelper;
    private Button mBtRegister;
    private EditText mEtUsername;
    private EditText mEtPassword1;
    private EditText mEtPassword2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
        mDBOpenHelper = new SqliteOpenHelper(this);
    }
    private void initView(){
        mBtRegister = findViewById(R.id.login_button11);
        mEtUsername = findViewById(R.id.name);
        mEtPassword1 = findViewById(R.id.password);
        mEtPassword2 = findViewById(R.id.password1);
        mBtRegister.setOnClickListener(this);
    }
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.login_button11:    //注册按钮
                //获取用户输入的用户名、密码、验证码
                String username = mEtUsername.getText().toString().trim();
                String password = mEtPassword1.getText().toString().trim();
                if (!TextUtils.isEmpty(username) && !TextUtils.isEmpty(password) ) {
                    //将用户名和密码加入到数据库中
                    mDBOpenHelper.add(username, password);
                    Intent intent2 = new Intent(this, MActivity.class);
                    startActivity(intent2);
                    finish();
                    Toast.makeText(this,  "验证通过，注册成功", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(LoginActivity.this, MActivity.class));
                }
                else {
                    Toast.makeText(this, "未完善信息，注册失败", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }
}
