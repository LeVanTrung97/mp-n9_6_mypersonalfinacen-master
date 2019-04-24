package com.example.mypersonalfinance.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mypersonalfinance.R;
import com.example.mypersonalfinance.model.Thunhap;

import java.util.ArrayList;

public class GiaoDichAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private ArrayList<Thunhap> thunhapArrayList;
public GiaoDichAdapter(Context context,int layout,ArrayList<Thunhap> thunhapArrayList){
this.context=context;
this.layout=layout;
this.thunhapArrayList=thunhapArrayList;
}
    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }
class ViewHolder{
        ImageView imageView;
        TextView textView;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(layout, null);

            viewHolder.imageView = convertView.findViewById(R.id.icon_the_loai);

            viewHolder.textView = convertView.findViewById(R.id.txt_chonnhom);


            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();

        }
Thunhap thunhap=thunhapArrayList.get(position);
viewHolder.textView.setText(thunhap.getThunhap_name());
viewHolder.imageView.setImageResource(thunhap.getThunhap_icon());
return  convertView;
    }
}
