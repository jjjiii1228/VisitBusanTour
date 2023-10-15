package com.vbt.visitbusantour.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.vbt.visitbusantour.R;

public class CourseDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_detail);

        String start_date = getIntent().getStringExtra("start_date");
        String end_date = getIntent().getStringExtra("end_date");
        String departure = getIntent().getStringExtra("departure");
        String destination = getIntent().getStringExtra("destination");
        String total_people_cnt = getIntent().getStringExtra("total_people_cnt");
    }
}