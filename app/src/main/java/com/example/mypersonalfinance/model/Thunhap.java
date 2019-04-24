package com.example.mypersonalfinance.model;

import java.io.Serializable;

public class Thunhap implements Serializable {
    private String Thunhap_id;
    private String  Thunhap_name;
    private int Thunhap_tien;
    private String Thunhap_ghichu;
    private String Thunhap_ngay;
    private int Thunhap_icon;

    public Thunhap() {
    }
    public Thunhap( String thunhap_name, int thunhap_tien, String thunhap_ghichu, String thunhap_ngay, int thunhap_icon) {
        Thunhap_name = thunhap_name;
        Thunhap_tien = thunhap_tien;
        Thunhap_ghichu = thunhap_ghichu;
        Thunhap_ngay = thunhap_ngay;
        Thunhap_icon = thunhap_icon;
    }
    public Thunhap(String thunhap_id, String thunhap_name, int thunhap_tien, String thunhap_ghichu, String thunhap_ngay, int thunhap_icon) {
        Thunhap_id = thunhap_id;
        Thunhap_name = thunhap_name;
        Thunhap_tien = thunhap_tien;
        Thunhap_ghichu = thunhap_ghichu;
        Thunhap_ngay = thunhap_ngay;
        Thunhap_icon = thunhap_icon;
    }

    public String getThunhap_id() {
        return Thunhap_id;
    }

    public void setThunhap_id(String thunhap_id) {
        Thunhap_id = thunhap_id;
    }

    public String getThunhap_name() {
        return Thunhap_name;
    }

    public void setThunhap_name(String thunhap_name) {
        Thunhap_name = thunhap_name;
    }

    public int getThunhap_tien() {
        return Thunhap_tien;
    }

    public void setThunhap_tien(int thunhap_tien) {
        Thunhap_tien = thunhap_tien;
    }

    public String getThunhap_ghichu() {
        return Thunhap_ghichu;
    }

    public void setThunhap_ghichu(String thunhap_ghichu) {
        Thunhap_ghichu = thunhap_ghichu;
    }

    public String getThunhap_ngay() {
        return Thunhap_ngay;
    }

    public void setThunhap_ngay(String thunhap_ngay) {
        Thunhap_ngay = thunhap_ngay;
    }

    public int getThunhap_icon() {
        return Thunhap_icon;
    }

    public void setThunhap_icon(int thunhap_icon) {
        Thunhap_icon = thunhap_icon;
    }

    @Override
    public String toString() {
        return "Thunhap{" + '\'' + ", Thunhap_name='" + Thunhap_name + '\'' + ", Thunhap_tien=" + Thunhap_tien + ", Thunhap_ghichu='" + Thunhap_ghichu + '\'' + ", Thunhap_ngay='" + Thunhap_ngay + '\'' + ", Thunhap_icon=" + Thunhap_icon + '}';
    }
}
