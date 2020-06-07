package com.example.jiaoshiduan;

import android.content.Context;

public class Book {
    private String name;
    private String type;
    private String rank;

    public Book(String name, String type, String rank) {
        super();
        this.name = name;
        this.type = type;
        this.rank = rank;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    @Override
    public String toString() {
        return name + ", " + type+ ", " + rank ;
    }
}

