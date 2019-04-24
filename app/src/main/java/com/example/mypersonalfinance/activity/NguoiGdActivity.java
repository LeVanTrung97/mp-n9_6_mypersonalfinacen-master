package com.example.mypersonalfinance.activity;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.mypersonalfinance.R;

public class NguoiGdActivity extends AppCompatActivity {
TextView save_ngd;
EditText name;
    public static final String NGUOI_GD ="name";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nguoi_gd);
        name=findViewById(R.id.edt_nguoi_gd);
        save_ngd=findViewById(R.id.save_ngd);
        save_ngd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                String GhiChu = name.getText().toString();

                intent.putExtra("name",GhiChu);
                setResult(Activity.RESULT_OK,intent);
                finish();
            }
        });
    }
}
