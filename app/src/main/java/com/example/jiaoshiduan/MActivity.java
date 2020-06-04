package com.example.jiaoshiduan;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
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
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MActivity extends AppCompatActivity implements View.OnClickListener {
    private SqliteOpenHelper mDBOpenHelper;
    private Button mTvRegister;
    private EditText mEtUsername;
    private EditText mEtPassword;
    private Button mBtLogin;
    private SharedPreferences pref;
    private CheckBox rememberPass;
    private SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_m);
        pref= PreferenceManager.getDefaultSharedPreferences(this);
        mDBOpenHelper = new SqliteOpenHelper(this);
        mBtLogin = findViewById(R.id.login_button);
        mTvRegister = findViewById(R.id.login_button1);
        mEtUsername = findViewById(R.id.name);
        mEtPassword = findViewById(R.id.password);
        rememberPass=(CheckBox)findViewById(R.id.cb_auto);
        pref=getSharedPreferences("cb_auto",Context.MODE_PRIVATE);
        boolean isRemember=pref.getBoolean("cb_auto",false);
        // 设置点击事件监听器
        mBtLogin.setOnClickListener(this);
        mTvRegister.setOnClickListener(this);
        if (isRemember){
            String name=pref.getString("name","");
            String password=pref.getString("password","");
            mEtUsername.setText(name);
            mEtPassword.setText(password);
            rememberPass.setChecked(true);
            Intent intent = new Intent(this, homeActivity.class);
            startActivity(intent);
        }
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
                    for (int i = 0; i < data.size(); i++) {
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
                        editor=pref.edit();
                        if(rememberPass.isChecked()){
                            SharedPreferences pref=getSharedPreferences("cb_auto",Context.MODE_PRIVATE);
                            editor.putBoolean("cb_auto",true);
                            editor.putString("name",name);
                            editor.putString("password",password);
                        }else {
                            editor.clear();
                        }
                        editor.apply();
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

