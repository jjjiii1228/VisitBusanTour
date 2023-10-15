package com.vbt.visitbusantour;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.util.Pair;

import com.google.android.material.datepicker.MaterialDatePicker;
import com.google.android.material.datepicker.MaterialPickerOnPositiveButtonClickListener;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class when extends AppCompatActivity {

    TextView datePickerText;
    TextView datePickerText1;
    Calendar calendar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_when);

        datePickerText = findViewById(R.id.date_picker_text);
        datePickerText1 = findViewById(R.id.date_picker_text1);

        calendar = Calendar.getInstance(TimeZone.getTimeZone("UTC"));

        //오늘 날짜
        Long today = MaterialDatePicker.todayInUtcMilliseconds();


        //기간 선택 버튼
        Button dateRangePicker = findViewById(R.id.date_range_picker_btn);
        dateRangePicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MaterialDatePicker.Builder<Pair<Long, Long>> builder = MaterialDatePicker.Builder.dateRangePicker();

                builder.setTitleText("Date Picker");

                //미리 날짜 선택
                builder.setSelection(Pair.create(MaterialDatePicker.thisMonthInUtcMilliseconds(), MaterialDatePicker.todayInUtcMilliseconds()));

                MaterialDatePicker materialDatePicker = builder.build();

                materialDatePicker.show(getSupportFragmentManager(), "DATE_PICKER");

                //확인버튼
                materialDatePicker.addOnPositiveButtonClickListener(new MaterialPickerOnPositiveButtonClickListener<Pair<Long, Long>>() {
                    @Override
                    public void onPositiveButtonClick(Pair<Long, Long> selection) {
                        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM. dd");
                        Date date1 = new Date();
                        Date date2 = new Date();

                        date1.setTime(selection.first);
                        date2.setTime(selection.second);

                        String dateString1 = simpleDateFormat.format(date1);
                        String dateString2 = simpleDateFormat.format(date2);

                        datePickerText.setText(dateString1 );
                        datePickerText1.setText(dateString2);
                    }
                });
            }
        });
        Button Next_btn = findViewById(R.id.next_btn);
        Next_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),where.class);
                startActivity(intent);
            }
        });
    }
}