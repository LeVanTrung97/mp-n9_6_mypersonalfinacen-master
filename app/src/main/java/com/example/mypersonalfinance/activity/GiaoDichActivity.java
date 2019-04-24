package com.example.mypersonalfinance.activity;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mypersonalfinance.R;
import com.example.mypersonalfinance.data.MyDatabaseHelper;
import com.example.mypersonalfinance.model.Thunhap;

import java.io.ByteArrayOutputStream;
import java.sql.SQLOutput;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class GiaoDichActivity extends AppCompatActivity {
    private static final int MODE_CREATE = 1;
    private static final int MODE_EDIT = 2;
    private ImageView icon_the_loai, flag_nhom;
    private EditText edtTien;
    private LinearLayout ghichu, chonngay, map, nguoi_gd, chonnhom;
    private TextView ngay, ai, save, nhom, txt_theloai, gc, cancel, the_loai;
    private TextView textView;
    RelativeLayout relativeLayout;
    public static final int CODE = 1;

    private String Thunhap_id;
    private String Thunhap_name;
    private int Thunhap_tien;
    private String Thunhap_ghichu;
    private String Thunhap_ngay;
    private int Thunhap_icon;

    public static int tien;
    public static String theloai;
    public static String hinhthuc;
    public static String ghi_chu;
    public static String date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_giao_dich);
        icon_the_loai = findViewById(R.id.icon_the_loai);
        edtTien = findViewById(R.id.tien);
        nhom = findViewById(R.id.the_loai);
        txt_theloai = findViewById(R.id.txt_chonnhom);
        flag_nhom = findViewById(R.id.icon_the_loai);
        ghichu = findViewById(R.id.ghichu);
        gc = findViewById(R.id.gchu);
        ghichu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GiaoDichActivity.this, GhichuActivity.class);
                startActivityForResult(intent, 1);
            }
        });
        chonnhom = (LinearLayout) findViewById(R.id.chonnhom);
        chonnhom.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GiaoDichActivity.this, ChonNhomActivity.class);
                startActivity(intent);
            }
        });
        chonngay = (LinearLayout) findViewById(R.id.chonngay);
        chonngay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chonngay();
            }
        });
        map = findViewById(R.id.map);
        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri addressURri = Uri.parse("geo:0,0?q=");
                Intent intent = new Intent(Intent.ACTION_VIEW, addressURri);
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }
            }
        });
        ai = findViewById(R.id.ai);
        nguoi_gd = findViewById(R.id.who);
        nguoi_gd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GiaoDichActivity.this, NguoiGdActivity.class);
                startActivityForResult(intent, 1);
            }
        });
        cancel = findViewById(R.id.cancel);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GiaoDichActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
        save = findViewById(R.id.save_data);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyDatabaseHelper db = new MyDatabaseHelper(GiaoDichActivity.this);
                Thunhap a = new Thunhap("name", 15000, "ghi chu", "12343", 123);

                System.out.println(a);
                boolean result = db.addThunhap(a);
                if (result) {
                    Toast.makeText(GiaoDichActivity.this, "Ghi thanh cong", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(GiaoDichActivity.this, "Ghi that bai", Toast.LENGTH_LONG).show();
                }
                ArrayList<Thunhap> thunhaps = db.getAllThunhap();
                for (Thunhap e : thunhaps) {
                    System.out.println(e);
                }
//               Intent intent = new Intent(GiaoDichActivity.this, MainActivity.class);
//                startActivity(intent);
            }
        });

        the_loai = findViewById(R.id.the_loai);
        getDataTieuDung();
        getDataNoChoVay();
        getDataThuNhap();
    }

    public Thunhap createThuNhap() {

        String name = txt_theloai.getText().toString();
//        String theloai=the_loai.getText().toString();
        String tien = edtTien.getText().toString();
        String ghichu = gc.getText().toString();
        String ngaay = ngay.getText().toString();
        int icon = icon_the_loai.getImageAlpha();
        return new Thunhap(name, Integer.parseInt(tien), ghichu, ngaay, icon);
    }

    public byte[] ConverttoArrayByte(ImageView img) {
        BitmapDrawable bitmapDrawable = (BitmapDrawable) img.getDrawable();
        Bitmap bitmap = bitmapDrawable.getBitmap();

        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
        return stream.toByteArray();
    }

    private void chonngay() {
        final Calendar calendar = Calendar.getInstance();
        int ngay = calendar.get(Calendar.DATE);
        int thang = calendar.get(Calendar.MONTH);
        int nam = calendar.get(Calendar.YEAR);
        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                calendar.set(year, monthOfYear, dayOfMonth);
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
                TextView ngay = (TextView) findViewById(R.id.ngay);
                ngay.setText(simpleDateFormat.format(calendar.getTime()));
            }
        }, nam, thang, ngay);
        datePickerDialog.show();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1) {
            if (resultCode == Activity.RESULT_OK) {
                String result = data.getStringExtra("ghichu");
                gc.setText(result);
            }
            if (resultCode == Activity.RESULT_CANCELED) {
                //Write your code if there's no result
            }
        }
    }

    public void getDataTieuDung() {
        Intent intent = getIntent();
        if (intent != null) {
            String name = intent.getStringExtra("nameTieuDung");
            int flag = intent.getIntExtra("flagTieuDung", 0);
            if (name != null && flag != 0) {
                txt_theloai.setText(name);
                flag_nhom.setImageResource(flag);
            }
        }
    }

    public void getDataNoChoVay() {
        Intent intent = getIntent();
        if (intent != null) {
            String name = intent.getStringExtra("nameNoChoVay");
            int flag = intent.getIntExtra("flagNoChoVay", 0);
            if (name != null && flag != 0) {
                txt_theloai.setText(name);
                flag_nhom.setImageResource(flag);
            }
            if (name != null) {
                the_loai.setText(intent.getStringExtra("tagNoChoVay"));

            }
        }
    }

    public void getDataThuNhap() {
        Intent intent = getIntent();
        String name = intent.getStringExtra("nameThuNhap");
        int flag = intent.getIntExtra("flagThuNhap", 0);
        if (name != null && flag != 0) {
            txt_theloai.setText(name);
            flag_nhom.setImageResource(flag);
        }
        if (name != null) {
            the_loai.setText(intent.getStringExtra("tagThuNhap"));
        }
    }

}
