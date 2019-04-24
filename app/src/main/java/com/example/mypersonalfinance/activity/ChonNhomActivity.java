package com.example.mypersonalfinance.activity;

import android.content.Intent;
import android.support.annotation.ColorInt;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.mypersonalfinance.R;
import com.example.mypersonalfinance.fragment.NoChoVayFragment;
import com.example.mypersonalfinance.fragment.ThuNhapFragment;
import com.example.mypersonalfinance.fragment.TieuDungFragment;
import com.example.mypersonalfinance.model.TheLoai;

import java.util.ArrayList;

public class ChonNhomActivity extends AppCompatActivity {
    private TextView chovay, tieudung, thunhap, cancel,the_loai;
    ArrayList<TheLoai> mlistTheloai = new ArrayList<TheLoai>();
    TieuDungFragment tieuDungFragment = new TieuDungFragment();
    NoChoVayFragment noChoVayFragment = new NoChoVayFragment();
    ThuNhapFragment thuNhapFragment = new ThuNhapFragment();
    public String tag;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.conten_view);
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.conten_view, tieuDungFragment);
        transaction.addToBackStack(null);
        transaction.commit();
        the_loai=findViewById(R.id.the_loai);
        tieudung =  findViewById(R.id.nhom_tieudung);
        final TieuDungFragment tieuDungFragment = new TieuDungFragment();
        tieudung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction().replace(R.id.conten_view, tieuDungFragment).commit();
            }
        });
        chovay =  findViewById(R.id.nhom_chovay);
        chovay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction().replace(R.id.conten_view, noChoVayFragment).commit();
            }
        });
        thunhap = findViewById(R.id.nhom_thunhap);
        thunhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction().replace(R.id.conten_view, thuNhapFragment).commit();
            }
        });
        cancel = findViewById(R.id.cn_cancel);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChonNhomActivity.this, GiaoDichActivity.class);
                startActivity(intent);
            }
        });
        noChoVayFragment.getStringNo(chovay.getText().toString());
        thuNhapFragment.getStringThuNhap(thunhap.getText().toString());
    }
}
