package com.example.mypersonalfinance.fragment;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.mypersonalfinance.R;
import com.example.mypersonalfinance.activity.ChonNhomActivity;
import com.example.mypersonalfinance.activity.GiaoDichActivity;


public class GiaoDichFragment extends Fragment {
    View view;
    private ImageView icon_the_loai, flag_nhom;
    private EditText edtTien,gc;
    private LinearLayout ghichu, chonngay, map, nguoi_gd, chonnhom;
    private TextView ngay, ai, hoantat, nhom, txt_theloai, cancel, the_loai;
    private TextView textView;

public static String tien;
    public static String hinhthuc;
    public static String theloai;
    public static String ghi_chu;
    public static String date;
    public static String icon;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_giao_dich,container,false);
         edtTien=view.findViewById(R.id.tien);
         chonnhom=view.findViewById(R.id.txt_chonnhom);
         the_loai=view.findViewById(R.id.the_loai);
         ngay=view.findViewById(R.id.ngay);
         gc=view.findViewById(R.id.gchu);
         hoantat=view.findViewById(R.id.save_data);
        chonnhom.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
           tien=edtTien.getText().toString();

            }
        });
        return view;

    }
}
