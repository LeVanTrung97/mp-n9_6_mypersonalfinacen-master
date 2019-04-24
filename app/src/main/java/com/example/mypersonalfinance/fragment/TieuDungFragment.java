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

public class TieuDungFragment extends Fragment {
    ArrayList<TheLoai> mlistTheloai = new ArrayList<TheLoai>();
    View view;
    @Nullable
    @Override
    public View onCreateView(@NonNull final LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_tieudung, container, false);
        doCreatefakedata();
        final ListView listTL = view.findViewById(R.id.lv_tieudung);
        TheLoaiAdapter adapter = new TheLoaiAdapter(getActivity(), R.layout.chonnhom_activity, mlistTheloai);
        listTL.setAdapter(adapter);
        listTL.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(), GiaoDichActivity.class);
                intent.putExtra("nameTieuDung", mlistTheloai.get(position).getName());
                intent.putExtra("flagTieuDung",mlistTheloai.get(position).getFlag());
                startActivity(intent);
            }
        });
        return view;
    }
    private void doCreatefakedata() {
        TheLoai t1 = new TheLoai();
        t1.setName("Ăn uống");
        t1.setFlag(R.mipmap.nhau);
        TheLoai t2 = new TheLoai();
        t2.setName("Nhà hàng");
        t2.setFlag(R.mipmap.nha_hang);
        TheLoai t3 = new TheLoai();
        t3.setName("Trà sữa");
        t3.setFlag(R.mipmap.tra_sua);
        TheLoai t4 = new TheLoai();
        t4.setName("Cà phê");
        t4.setFlag(R.mipmap.ca_phe);
        TheLoai t5 = new TheLoai();
        t5.setName("Tiền điện");
        t5.setFlag(R.mipmap.dien);
        TheLoai t6 = new TheLoai();
        t6.setName("Tiền điện thoại");
        t6.setFlag(R.mipmap.dien_thoai);
        TheLoai t7 = new TheLoai();
        t7.setName("Internet");
        t7.setFlag(R.mipmap.mang);
        TheLoai t8 = new TheLoai();
        t8.setName("Gas");
        t8.setFlag(R.mipmap.gas);
        TheLoai t9 = new TheLoai();
        t9.setName("Thuê nhà");
        t9.setFlag(R.mipmap.thue_nha);
        TheLoai t10 = new TheLoai();
        t10.setName("Xem phim");
        t10.setFlag(R.mipmap.xem_phim);
        TheLoai t11 = new TheLoai();
        t11.setName("Gửi xe");
        t11.setFlag(R.mipmap.gui_xe);
        TheLoai t12 = new TheLoai();
        t12.setName("Xăng dầu");
        t12.setFlag(R.mipmap.xang_dau);
        TheLoai t13 = new TheLoai();
        t13.setName("Taxi");
        t13.setFlag(R.mipmap.taxi);
        TheLoai t14 = new TheLoai();
        t14.setName("Mua sắm");
        t14.setFlag(R.mipmap.mua_sam);
        TheLoai t15 = new TheLoai();
        t15.setName("Du lịch");
        t15.setFlag(R.mipmap.du_lich);
        TheLoai t16 = new TheLoai();
        t16.setName("Khám bệnh");
        t16.setFlag(R.mipmap.suc_khoe);
        TheLoai t17 = new TheLoai();
        t17.setName("Mua thuốc");
        t17.setFlag(R.mipmap.thuoc);
        TheLoai t18 = new TheLoai();
        t18.setName("Bảo hiểm");
        t18.setFlag(R.mipmap.bao_hiem);
        TheLoai t19 = new TheLoai();
        t19.setName("Sách báo");
        t19.setFlag(R.mipmap.sach_bao);
        TheLoai t20 = new TheLoai();
        t20.setName("Khoản chi khác");
        t20.setFlag(R.mipmap.khoan_chi_khac);
        mlistTheloai.add(t1);
        mlistTheloai.add(t2);
        mlistTheloai.add(t3);
        mlistTheloai.add(t4);
        mlistTheloai.add(t5);
        mlistTheloai.add(t6);
        mlistTheloai.add(t7);
        mlistTheloai.add(t8);
        mlistTheloai.add(t9);
        mlistTheloai.add(t10);
        mlistTheloai.add(t11);
        mlistTheloai.add(t12);
        mlistTheloai.add(t13);
        mlistTheloai.add(t14);
        mlistTheloai.add(t15);
        mlistTheloai.add(t16);
        mlistTheloai.add(t17);
        mlistTheloai.add(t18);
        mlistTheloai.add(t19);
        mlistTheloai.add(t20);
    }
}
