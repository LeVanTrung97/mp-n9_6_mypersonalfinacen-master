package com.example.mypersonalfinance.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mypersonalfinance.R;
import com.example.mypersonalfinance.model.TheLoai;

import java.util.ArrayList;
import java.util.List;

public class TheLoaiAdapter extends ArrayAdapter<TheLoai> {
    Context mContext;
    ArrayList<TheLoai> mTheLoai=new ArrayList<TheLoai>();
    public TheLoaiAdapter(Context context, int resource, List<TheLoai> objects) {
        super(context, resource, objects);
        this.mContext=context;
        this.mTheLoai=new ArrayList<TheLoai>(objects);
    }


    @Override
    public View getView(int position,  View convertView,  ViewGroup parent) {
        View rowView=convertView;
        ViewHolder viewHolder;

        if(rowView==null){
            LayoutInflater inflater=(LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE
            );
            rowView=inflater.inflate(R.layout.list_hinh_thuc,null);
viewHolder=new ViewHolder();
viewHolder.txtName=(TextView) rowView.findViewById(R.id.txtName);
            viewHolder.flag=(ImageView) rowView.findViewById(R.id.imageView_flag);
            rowView.setTag(viewHolder);
        }else{
            viewHolder=(ViewHolder) convertView.getTag();
        }
        TheLoai theLoai=mTheLoai.get(position);
        viewHolder.txtName.setText(theLoai.getName());
        viewHolder.flag.setImageResource(theLoai.getFlag());
        return rowView;
    }

    static class ViewHolder{
        TextView txtName;
        ImageView flag;

    }
}
