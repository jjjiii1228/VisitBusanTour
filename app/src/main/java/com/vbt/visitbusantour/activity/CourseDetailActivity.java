package com.vbt.visitbusantour.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;
import com.vbt.visitbusantour.R;
import com.vbt.visitbusantour.ViewPagerAdapter;

import java.util.ArrayList;

public class CourseDetailActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_detail);

        ViewPager vp = findViewById(R.id.viewpager);
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        vp.setAdapter(adapter);

        // 연동
        TabLayout tab = findViewById(R.id.tabs);
        tab.setupWithViewPager(vp);


        String start_date = getIntent().getStringExtra("start_date");
        String end_date = getIntent().getStringExtra("end_date");
        String departure = getIntent().getStringExtra("departure");
        String destination = getIntent().getStringExtra("destination");
        String total_people_cnt = getIntent().getStringExtra("total_people_cnt");
    }
}