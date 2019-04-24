package com.example.mypersonalfinance.model;

public class TheLoai {
    String name;
    int flag;

    public TheLoai(String name, int flag) {
        this.name = name;
        this.flag = flag;
    }

    public TheLoai() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }
}
