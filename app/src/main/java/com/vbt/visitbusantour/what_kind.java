package com.vbt.visitbusantour;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.ArrayList;

public class what_kind extends AppCompatActivity {

    private String DISABILITY_STATUS = "NONE"; // NONE/YES/NO
    private RadioButton diligently;
    private RadioButton leisurely;
    private RadioButton activity_trip_btn;
    private RadioButton calm_trip_btn;
    private RadioButton walking_btn;
    private RadioButton famous_btn;
    private RadioButton less_btn;
    private RadioGroup schedule_group;
    private RadioGroup attraction_group;
    private RadioGroup activity_group;
    private Button k_pop;
    private Button family;
    private Button traditional;
    private Button friend;
    private Button insta;
    private Button ocean;
    private String schedule;
    private String activity;
    private String attraction;
    private ArrayList keyword = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_what_kind);
        Button Next_btn = findViewById(R.id.next_btn);
        k_pop = (Button) findViewById(R.id.k_pop);
        family = (Button) findViewById(R.id.family);
        traditional = (Button) findViewById(R.id.traditional);
        friend = (Button) findViewById(R.id.friend);
        insta = (Button) findViewById(R.id.insta);
        ocean = (Button) findViewById(R.id.ocean);
        diligently = (RadioButton) findViewById(R.id.diligently);
        leisurely = (RadioButton) findViewById(R.id.leisurely);
        activity_trip_btn = (RadioButton) findViewById(R.id.activity_trip_btn);
        calm_trip_btn = (RadioButton) findViewById(R.id.calm_trip_btn);
        walking_btn = (RadioButton) findViewById(R.id.famous_btn);
        famous_btn = (RadioButton) findViewById(R.id.famous_btn);
        less_btn = (RadioButton) findViewById(R.id.less_btn);
        schedule_group = (RadioGroup) findViewById(R.id.schedule_group);
        attraction_group = (RadioGroup) findViewById(R.id.attraction_group);
        activity_group = (RadioGroup) findViewById(R.id.activity_group);

        schedule_group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.diligently:
                        schedule = "diligently";
                        break;
                    case R.id.leisurely:
                        schedule = "leisurely";
                        break;

                }
            }
        });
        activity_group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.activity_trip_btn:
                        activity = "Activity";
                        break;
                    case R.id.calm_trip_btn:
                        activity = "Calm";
                        break;
                    case R.id.walking_btn:
                        activity = "Walking";
                        break;
                }
            }
        });
        attraction_group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.famous_btn:
                        attraction = "Famous";
                        break;
                    case R.id.less_btn:
                        attraction = "Less";
                        break;
                }
            }
        });
        k_pop.setOnClickListener(new View.OnClickListener() {
            private int count=0;
            @Override
            public void onClick(View view) {
                count ++;
                if(count%2 == 1){
                    keyword.add("k_pop");
                }else{
                    keyword.remove("k_pop");
                }
            }
        });
        family.setOnClickListener(new View.OnClickListener() {
            private int count=0;
            @Override
            public void onClick(View view) {
                count ++;
                if(count%2 == 1){
                    keyword.add("family");
                }else{
                    keyword.remove("family");
                }
            }
        });
        traditional.setOnClickListener(new View.OnClickListener() {
            private int count=0;
            @Override
            public void onClick(View view) {
                count ++;
                if(count%2 == 1){
                    keyword.add("traditional");
                }else{
                    keyword.remove("traditional");
                }
            }
        });
        friend.setOnClickListener(new View.OnClickListener() {
            private int count=0;
            @Override
            public void onClick(View view) {
                count ++;
                if(count%2 == 1){
                    keyword.add("friend");
                }else{
                    keyword.remove("friend");
                }
            }
        });
        insta.setOnClickListener(new View.OnClickListener() {
            private int count=0;
            @Override
            public void onClick(View view) {
                count ++;
                if(count%2 == 1){
                    keyword.add("insta");
                }else{
                    keyword.remove("insta");
                }
            }
        });
        ocean.setOnClickListener(new View.OnClickListener() {
            private int count=0;
            @Override
            public void onClick(View view) {
                count ++;
                if(count%2 == 1){
                    keyword.add("ocean");
                }else{
                    keyword.remove("ocean");
                }
            }
        });


        Next_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences = getSharedPreferences("info",MODE_PRIVATE);
                SharedPreferences.Editor editor= sharedPreferences.edit(); //sharedPreferences
                editor.putString("schedule", schedule);
                editor.putString("activity", activity);
                editor.putString("attraction", attraction);
                editor.commit();

                Intent intent = new Intent(getApplicationContext(),where.class);
                startActivity(intent);
            }
        });
    }
}