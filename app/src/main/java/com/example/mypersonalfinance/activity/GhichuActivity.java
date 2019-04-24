package com.example.mypersonalfinance.activity;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mypersonalfinance.R;

public class GhichuActivity extends AppCompatActivity {
TextView savegc;
EditText ghichu;

public static final String GHI_CHU ="ghichu";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ghichu);
        ghichu=findViewById(R.id.ghichu_activity);
        savegc=findViewById(R.id.save_gc);
        savegc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = getIntent();
                String GhiChu = ghichu.getText().toString();

                intent.putExtra("ghichu",GhiChu);
                setResult(Activity.RESULT_OK,intent);
                finish();
            }
        });
    }
}
