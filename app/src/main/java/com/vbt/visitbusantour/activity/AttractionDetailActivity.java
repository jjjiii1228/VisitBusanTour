package com.vbt.visitbusantour.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.vbt.visitbusantour.R;
import com.vbt.visitbusantour.RecyclerViewItem;

public class AttractionDetailActivity extends AppCompatActivity {

    private TextView txtPlace, txtHldy, txtGugun, txtAddr, txtUsageTime, txtCntct, txtTrfcInfo;
    private ImageView imgMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attraction_detail);

        txtPlace = findViewById(R.id.txt_place);
        txtHldy = findViewById(R.id.txt_hldy);
        txtGugun = findViewById(R.id.txt_gugun);
        txtAddr = findViewById(R.id.txt_addr);
        txtUsageTime = findViewById(R.id.txt_usageTime);
        txtCntct = findViewById(R.id.txt_cntct);
        txtTrfcInfo = findViewById(R.id.txt_trfcInfo);
        imgMain = findViewById(R.id.img_main);

        Intent intent = getIntent();
        RecyclerViewItem item = (RecyclerViewItem) intent.getSerializableExtra("itemInfo");

        if (item != null) {
            txtPlace.setText(item.getMainText());
            txtHldy.setText(item.getHldyInfo());
            txtGugun.setText(item.getmGugunNM());
            txtAddr.setText(item.getmAddr());
            txtUsageTime.setText(item.getmUsageTime());
            txtCntct.setText(item.getmCntctTel());
            txtTrfcInfo.setText(item.getmTrfcInfo());

            Glide.with(this)
                    .load(item.getImgName())
                    .into(imgMain);
        }
    }
}