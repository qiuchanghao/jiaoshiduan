package com.example.jiaoshiduan;

import android.content.Context;

public class Book {
    private String name;            //申报名称
    private String type;            //类型
    private String rank;            //级别
    public Book(String name, String type,String rank) {
        this.name = name;
        this.type = type;
        this.rank = rank;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) { this.name = name; }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public String getRank() {
        return rank;
    }
    public void setRank(String rank) { this.rank = rank; }
    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", rank='" + rank + '\'' +
                '}';
    }
}

