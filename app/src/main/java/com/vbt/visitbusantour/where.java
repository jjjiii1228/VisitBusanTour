package com.vbt.visitbusantour;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.ArrayList;

public class where extends AppCompatActivity {

    ImageView imageView;
    private Button Gijiang;
    private Button Dongnae;
    private Button Seonmyeon;
    private Button Gwangan;
    private Button Haeundae;
    private Button Yeongdo;
    private Button Sasang;
    private Button next_btn;
    private ArrayList place = new ArrayList<String>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_where);

        Gijiang = (Button) findViewById(R.id.Gijiang);
        Dongnae = (Button) findViewById(R.id.Dongnae);
        Seonmyeon = (Button) findViewById(R.id.Seonmyeon);
        Gwangan = (Button) findViewById(R.id.Gwangan);
        Haeundae = (Button) findViewById(R.id.Haeundae);
        Yeongdo = (Button) findViewById(R.id.Yeongdo);
        Sasang = (Button) findViewById(R.id.Sasang);
        next_btn = (Button) findViewById(R.id.next_btn);



        SharedPreferences sharedPreferences = getSharedPreferences("info", MODE_PRIVATE);
        String disability = sharedPreferences.getString("disability", "999");
        int total_people_cnt = sharedPreferences.getInt("total_people_cnt", 999);
        String schedule = sharedPreferences.getString("schedule", "999");
        String activity = sharedPreferences.getString("activity", "999");
        String attraction = sharedPreferences.getString("attraction", "999");

        Log.d("check course info", disability);

        Gijiang.setOnClickListener(new View.OnClickListener() {
            private int count=0;
            @Override
            public void onClick(View view) {
                count ++;
                if(count%2 == 1){
                    place.add("Gijiang");
                }else{
                    place.remove("Gijiang");
                }
            }
        });

        Dongnae.setOnClickListener(new View.OnClickListener() {
            private int count=0;

            @Override
            public void onClick(View view) {
                count ++;
                if(count%2 == 1){
                    place.add("Dongnae");
                }else{
                    place.remove("Dongnae");
                }
            }
        });
        Seonmyeon.setOnClickListener(new View.OnClickListener() {
            private int count=0;

            @Override
            public void onClick(View view) {
                count ++;
                if(count%2 == 1){
                    place.add("Infant");
                }else{
                    place.remove("Infant");
                }
            }
        });

        Gwangan.setOnClickListener(new View.OnClickListener() {
            private int count=0;

            @Override
            public void onClick(View view) {
                count ++;
                if(count%2 == 1){
                    place.add("Gwangan");
                }else{
                    place.remove("Gwangan");
                }
            }
        });
        Haeundae.setOnClickListener(new View.OnClickListener() {
            private int count=0;
            @Override
            public void onClick(View view) {
                count ++;
                if(count%2 == 1){
                    place.add("Haeundae");
                }else{
                    place.remove("Haeundae");
                }
            }
        });

        Yeongdo.setOnClickListener(new View.OnClickListener() {
            private int count=0;
            @Override
            public void onClick(View view) {
                count ++;
                if(count%2 == 1){
                    place.add("Yeongdo");
                }else{
                    place.remove("Yeongdo");
                }
            }
        });

        Sasang.setOnClickListener(new View.OnClickListener() {
            private int count=0;

            @Override
            public void onClick(View view) {
                count ++;
                if(count%2 == 1){
                    place.add("Sasang");
                }else{
                    place.remove("Sasang");
                }
            }
        });

        imageView = findViewById(R.id.iv_busan);
        next_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Course_loading.class);
                startActivity(intent);
            }
        });


    }
}