package com.vbt.visitbusantour.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.vbt.visitbusantour.R;
import com.vbt.visitbusantour.RecyclerViewItem2;

public class FestivalDetailActivity extends AppCompatActivity {

    private TextView txtPlace, txtUsageTime, txtGugun, txtAddr, txtAmount, txtCntct, txtMiddleSizeRM, txtTrfcInfo;
    private ImageView imgMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_festival_detail);

        txtPlace = findViewById(R.id.txt_fe_place);
        txtUsageTime = findViewById(R.id.txt_fe_usageTime);
        txtGugun = findViewById(R.id.txt_fe_gugun);
        txtAddr = findViewById(R.id.txt_fe_addr);
        txtAmount = findViewById(R.id.txt_fe_amount);
        txtCntct = findViewById(R.id.txt_fe_cntct);
        txtMiddleSizeRM = findViewById(R.id.txt_fe_middleSizeRM);
        txtTrfcInfo = findViewById(R.id.txt_fe_trfcInfo);
        imgMain = findViewById(R.id.img_fe_main);

        Intent intent = getIntent();
        RecyclerViewItem2 item = (RecyclerViewItem2) intent.getSerializableExtra("itemInfo");

        if (item != null) {

            txtPlace.setText(item.getPlace());
            txtUsageTime.setText(item.getUsageTime());
            txtGugun.setText(item.getGugunNM());
            txtAddr.setText(item.getAddr());
            txtAmount.setText(item.getAmount());
            txtCntct.setText(item.getCntctTel());
            txtMiddleSizeRM.setText(item.getMiddleSizeRM());
            txtTrfcInfo.setText(item.getTrfcInfo());

            Glide.with(this)
                    .load(item.getImgName())
                    .into(imgMain);
        }
    }
}