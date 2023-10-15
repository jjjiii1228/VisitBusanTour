package com.vbt.visitbusantour;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.SpannableStringBuilder;
import android.widget.TextView;

public class Course_loading extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_loading);



        // Visit Busan Pass 글자 색 변경
        TextView VisitBusan_txt = findViewById(R.id.visitBusan_txt);
        String text = "Custom courses are \n being created...";

        TextView VisitBusan_txt1 = findViewById(R.id.visitBusan_txt1);
        String text1 = "This will take about a minute.\n Please wait a moment!";

        int startColor = ContextCompat.getColor(this, R.color.start);
        int endColor = ContextCompat.getColor(this, R.color.end);

        SpannableStringBuilder spnnable = new SpannableStringBuilder(text);
        spnnable.setSpan(new ToGradient(text, text, startColor, endColor), 0, text.length(), 0);
        VisitBusan_txt.setText(spnnable);

        SpannableStringBuilder spnnable1 = new SpannableStringBuilder(text1);
        spnnable.setSpan(new ToGradient(text1, text1, startColor, endColor), 0, text.length(), 0);
        VisitBusan_txt1.setText(spnnable1);






        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(Course_loading.this, isPass.class);
                startActivity(intent);
                finish();
            }
        }, 2000);


    }
}