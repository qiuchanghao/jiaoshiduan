package com.example.jiaoshiduan;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class Dashboard extends AppCompatActivity {
    List<Book> bookList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dashboard);
        bookList=new ArrayList<Book>();

        final Button loginButton = findViewById(R.id.text3);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Dashboard.this, homeActivity.class));
            }
        });

        //从数据库里面把数据取出来
        MySQL oh = new MySQL(this);
        SQLiteDatabase sql = oh.getWritableDatabase();

        Cursor cursor = sql.query("book", null, null, null, null, null, null);
        while (cursor.moveToNext()) {
            String name = cursor.getString(cursor.getColumnIndex("name"));
            String type = cursor.getString(cursor.getColumnIndex("type"));
            String rank = cursor.getString(cursor.getColumnIndex("rank"));
            Book p=new Book(name, type, rank);

            bookList.add(p);
        }
        LinearLayout ll=(LinearLayout) findViewById(R.id.ll);
        //把数据显示到屏幕
        for(Book p:bookList)
        {
            //1.集合中每有一条数据，就new一个TextView
            TextView tv=new TextView(this);
            //2.把人物的信息设置为文本的内容
            tv.setText(p.toString());
            tv.setTextSize(18);
            //3.把TextView设置成线性布局的子节点
            ll.addView(tv);
        }
    }
}