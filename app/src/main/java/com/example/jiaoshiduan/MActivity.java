package com.example.jiaoshiduan;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
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
import java.util.ArrayList;

public class MActivity extends AppCompatActivity implements View.OnClickListener {
    private SqliteOpenHelper mDBOpenHelper;
    private Button mTvRegister;
    private EditText mEtUsername;
    private EditText mEtPassword;
    private Button mBtLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_m);
        initView();
        mDBOpenHelper = new SqliteOpenHelper(this);
    }
    private void initView() {
        // 初始化控件
        mBtLogin = findViewById(R.id.login_button);
        mTvRegister = findViewById(R.id.login_button1);
        mEtUsername = findViewById(R.id.name);
        mEtPassword = findViewById(R.id.password);
        // 设置点击事件监听器
        mBtLogin.setOnClickListener(this);
        mTvRegister.setOnClickListener(this);
    }
    public void onClick(View view) {
        switch (view.getId()) {
            // 跳转到注册界面
            case R.id.login_button1:
                startActivity(new Intent(this, LoginActivity.class));
                finish();
                break;
            case R.id.login_button:
                String name = mEtUsername.getText().toString().trim();
                String password = mEtPassword.getText().toString().trim();
                if (!TextUtils.isEmpty(name) && !TextUtils.isEmpty(password)) {
                    ArrayList<User> data = mDBOpenHelper.getAllData();
                    boolean match = false;
                    for (int i =0; i < data.size(); i++) {
                        User user = data.get(i);
                        if (name.equals(user.getName()) && password.equals(user.getPassword())) {
                            match = true;
                            break;
                        } else {
                            match = false;
                        }
                    }
                    if (match) {
                        Toast.makeText(this, "登录成功", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(this, homeActivity.class);
                        startActivity(intent);
                        finish();//销毁此Activity
                    } else {
                        Toast.makeText(this, "用户名或密码不正确，请重新输入", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(this, "请输入你的用户名或密码", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }
}
