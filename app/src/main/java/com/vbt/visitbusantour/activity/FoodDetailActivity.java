package com.vbt.visitbusantour.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.vbt.visitbusantour.R;
import com.vbt.visitbusantour.RecyclerViewItem3;

public class FoodDetailActivity extends AppCompatActivity {

    private TextView txtPlace, txtUsageTime, txtGugun, txtAddr, txtMainTitle, txtCntct, txtRprsntvMenu, txtItemCntnts;
    private ImageView imgMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_detail);

        txtPlace = findViewById(R.id.txt_food_place);
        txtUsageTime = findViewById(R.id.txt_food_usageTime);
        txtGugun = findViewById(R.id.txt_food_gugun);
        txtAddr = findViewById(R.id.txt_food_addr);
        txtMainTitle = findViewById(R.id.txt_food_mainTitle);
        txtCntct = findViewById(R.id.txt_food_cntct);
        txtRprsntvMenu = findViewById(R.id.txt_food_prpsntvMenu);
        txtItemCntnts = findViewById(R.id.txt_food_itemCntnts);
        imgMain = findViewById(R.id.img_food_main);

        Intent intent = getIntent();
        RecyclerViewItem3 item = (RecyclerViewItem3) intent.getSerializableExtra("itemInfo");

        if (item != null) {

            txtPlace.setText(item.getPlace());
            txtUsageTime.setText(item.getUsageTime());
            txtGugun.setText(item.getGugunNM());
            txtAddr.setText(item.getAddr());
            txtMainTitle.setText(item.getMainTitle());
            txtCntct.setText(item.getCntctTel());
            txtRprsntvMenu.setText(item.getRprsntvMenu());
            txtItemCntnts.setText(item.getItemCntnts());

            Glide.with(this)
                    .load(item.getImgName())
                    .into(imgMain);
        }
    }
}