package com.vbt.visitbusantour;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class isPass extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_is_pass);

        // Visit Busan Pass 글자 색 변경
        TextView VisitBusan_txt = findViewById(R.id.visitBusan_txt);
        String text = "Visit Busan Pass";
        int startColor = ContextCompat.getColor(this, R.color.start);
        int endColor = ContextCompat.getColor(this, R.color.end);

        SpannableStringBuilder spnnable = new SpannableStringBuilder(text);
        spnnable.setSpan(new ToGradient(text, text, startColor, endColor), 0, text.length(), 0);
        VisitBusan_txt.setText(spnnable);

        Button Yes_pass_btn = findViewById(R.id.yes_pass_btn);
        Yes_pass_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),with_who.class);
                startActivity(intent);
            }
        });

        Button No_pass_btn = findViewById(R.id.no_pass_btn);
        No_pass_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("https://www.visitbusanpass.com/pass/"));
                startActivity(intent);
            }
        });

    }
}