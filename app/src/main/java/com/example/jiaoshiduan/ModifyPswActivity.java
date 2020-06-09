package com.example.jiaoshiduan;

import android.app.Activity;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.content.SharedPreferences;
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

public class ModifyPswActivity extends AppCompatActivity implements View.OnClickListener {
    private String realCode;
    private SqliteOpenHelper mDBOpenHelper;
    private Button mBtRegister;
    private EditText mEtUsername;
    private EditText mEtPassword2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modify_psw);
        initView();
        mDBOpenHelper = new SqliteOpenHelper(this);
        SharedPreferences pref=getSharedPreferences("cb_auto",MODE_PRIVATE);
        String name=pref.getString("name","");
        mEtUsername.setText(name);
    }
    private void initView(){
        mBtRegister = findViewById(R.id.login_button11);
        mEtUsername = findViewById(R.id.name);
        mEtPassword2 = findViewById(R.id.password1);
        mBtRegister.setOnClickListener(this);
    }
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.login_button11:    //注册按钮
                //获取用户输入的用户名、密码、确认密码
                String username = mEtUsername.getText().toString().trim();
                String password1 = mEtPassword2.getText().toString().trim();
                if (!TextUtils.isEmpty(username) && !TextUtils.isEmpty(password1) ) {

                        //将用户名和密码加入到数据库中
                        mDBOpenHelper.add(username, password1);
                        Intent intent2 = new Intent(this, MActivity.class);
                        startActivity(intent2);
                        finish();
                    SharedPreferences pref=getSharedPreferences("cb_auto",MODE_PRIVATE);
                    if(pref!=null){
                        pref.edit().clear().commit();}
                        Toast.makeText(this,  "验证通过，修改成功", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(this, "未完善信息，修改失败", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }
}
