package com.example.mypersonalfinance.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.mypersonalfinance.R;
import com.example.mypersonalfinance.activity.GiaoDichActivity;
import com.example.mypersonalfinance.adapter.TheLoaiAdapter;
import com.example.mypersonalfinance.model.TheLoai;

import java.util.ArrayList;

public class NoChoVayFragment extends Fragment {
    ArrayList<TheLoai> mlistTheloai = new ArrayList<TheLoai>();
    View view;
    public String no;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_no_cho_vay,container,false);
        onCreatFakeData();
        ListView listTL =view.findViewById(R.id.lv_nochovay);
        TheLoaiAdapter adapter = new TheLoaiAdapter(getActivity(), R.layout.chonnhom_activity, mlistTheloai);
        listTL.setAdapter(adapter);
        listTL.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(), GiaoDichActivity.class);
                intent.putExtra("nameNoChoVay", mlistTheloai.get(position).getName());
                intent.putExtra("flagNoChoVay",mlistTheloai.get(position).getFlag());
                intent.putExtra("tagNoChoVay",no);
                startActivity(intent);
            }
        });
        return view;
    }
    private void onCreatFakeData(){
        TheLoai t1 = new TheLoai();
        t1.setName("Cho vay");
        t1.setFlag(R.mipmap.cho_vay);
        TheLoai t2 = new TheLoai();
        t2.setName("Đi vay");
        t2.setFlag(R.mipmap.vay_tien);
        mlistTheloai.add(t1);
        mlistTheloai.add(t2);
    }

    public  void getStringNo(String a){
        no = a;
    }

}
