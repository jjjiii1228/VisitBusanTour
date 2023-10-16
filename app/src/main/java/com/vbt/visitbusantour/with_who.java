package com.vbt.visitbusantour;

import androidx.annotation.DrawableRes;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class with_who extends AppCompatActivity {

    private Button Infant;
    private Button Child;
    private Button Teenager;
    private Button Twenties;
    private Button Thirties;
    private Button Forties;
    private Button Fifties;
    private Button Sixties;
    private Button Seven;
    private Button Disable;
    private Button Disable_not;
    private Button Plus;
    private Button Minus;
    private ArrayList TRAVELIGN_COMPANION_STYLE = new ArrayList<String>();
    private String DISABILITY_STATUS = "NONE"; // NONE/YES/NO
    private TextView Member ;
    private int Count=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_with_who);

        Infant = (Button) findViewById(R.id.infant);
        Child = (Button) findViewById(R.id.child);
        Teenager = (Button) findViewById(R.id.teenager);
        Twenties = (Button) findViewById(R.id.twenties);
        Thirties = (Button) findViewById(R.id.thirties);
        Forties = (Button) findViewById(R.id.forties);
        Fifties = (Button) findViewById(R.id.fifties);
        Sixties = (Button) findViewById(R.id.sixties);
        Seven =(Button) findViewById(R.id.seven);
        Disable = (Button) findViewById(R.id.disable);
        Disable_not = (Button) findViewById(R.id.disable_not);
        Plus = (Button) findViewById(R.id.plus);
        Minus = (Button) findViewById(R.id.minus);
        Member = (TextView) findViewById(R.id.member);




        Infant.setOnClickListener(new View.OnClickListener() {
            private int count=0;

            @Override
            public void onClick(View view) {
                count ++;
                if(count%2 == 1){
                    TRAVELIGN_COMPANION_STYLE.add("Infant");
                    Infant.setSelected(true);

                }else{
                    TRAVELIGN_COMPANION_STYLE.remove("Infant");
                }
            }
        });
        Child.setOnClickListener(new View.OnClickListener() {
            private int count=0;
            @Override
            public void onClick(View view) {
                count ++;
                if(count%2 == 1){
                    TRAVELIGN_COMPANION_STYLE.add("Child");
                }else{
                    TRAVELIGN_COMPANION_STYLE.remove("Child");
                }
            }
        });
        Teenager.setOnClickListener(new View.OnClickListener() {
            private int count=0;
            @Override
            public void onClick(View view) {
                count ++;
                if(count%2 == 1){
                    TRAVELIGN_COMPANION_STYLE.add("Teens");
                }else{
                    TRAVELIGN_COMPANION_STYLE.remove("Teens");
                }
            }
        });
        Twenties.setOnClickListener(new View.OnClickListener() {
            private int count=0;
            @Override
            public void onClick(View view) {
                count ++;
                if(count%2 == 1){
                    TRAVELIGN_COMPANION_STYLE.add("20s");
                }else{
                    TRAVELIGN_COMPANION_STYLE.remove("20s");
                }
            }
        });
        Thirties.setOnClickListener(new View.OnClickListener() {
            private int count=0;
            @Override
            public void onClick(View view) {
                count ++;
                if(count%2 == 1){
                    TRAVELIGN_COMPANION_STYLE.add("30s");
                }else{
                    TRAVELIGN_COMPANION_STYLE.remove("30s");
                }
            }
        });

        Forties.setOnClickListener(new View.OnClickListener() {
            private int count=0;
            @Override
            public void onClick(View view) {
                count ++;
                if(count%2 == 1){
                    TRAVELIGN_COMPANION_STYLE.add("40s");
                }else{
                    TRAVELIGN_COMPANION_STYLE.remove("40s");
                }
            }
        });
        Fifties.setOnClickListener(new View.OnClickListener() {
            private int count=0;
            @Override
            public void onClick(View view) {
                count ++;
                if(count%2 == 1){
                    TRAVELIGN_COMPANION_STYLE.add("50s");
                }else{
                    TRAVELIGN_COMPANION_STYLE.remove("50s");
                }
            }
        });
        Sixties.setOnClickListener(new View.OnClickListener() {
            private int count=0;
            @Override
            public void onClick(View view) {
                count ++;
                if(count%2 == 1){
                    TRAVELIGN_COMPANION_STYLE.add("60s");
                }else{
                    TRAVELIGN_COMPANION_STYLE.remove("60s");
                }
            }
        });
        Seven.setOnClickListener(new View.OnClickListener() {
            private int count=0;
            @Override
            public void onClick(View view) {
                count ++;
                if(count%2 == 1){
                    TRAVELIGN_COMPANION_STYLE.add("70sOr");
                }else{
                    TRAVELIGN_COMPANION_STYLE.remove("70sOr");
                }
            }
        });
        Log.d("companion", String.format("%d",TRAVELIGN_COMPANION_STYLE.size()));

        Plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Count ++;
                Member.setText(String.valueOf(Count));

            }
        });
        Minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Count --;
                if (Count < 0){
                    Count = 0; }
                Member.setText(String.valueOf(Count));
            }
        });


        Disable.setOnClickListener(new View.OnClickListener() {
            private int count=0;
            @Override
            public void onClick(View view) {
                count ++;
//                if(count%2 == 1){
//                    TRAVELIGN_COMPANION_STYLE.add("Yes");
//                }else{
//                    TRAVELIGN_COMPANION_STYLE.remove("Yes");
//                }
                setDisableValue(count%2, "Yes");
            }
        });
        Disable_not.setOnClickListener(new View.OnClickListener() {
            private int count=0;
            @Override
            public void onClick(View view) {
                count ++;
//                if(count%2 == 1){
//                    TRAVELIGN_COMPANION_STYLE.add("No");
//                }else{
//                    TRAVELIGN_COMPANION_STYLE.remove("No");
//                }
                setDisableValue(count%2, "No");
            }
        });

        Button Next_btn = findViewById(R.id.next_btn);
        Next_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences sharedPreferences = getSharedPreferences("info",MODE_PRIVATE);
                SharedPreferences.Editor editor= sharedPreferences.edit(); //sharedPreferences
                editor.putString("disability", DISABILITY_STATUS);
                editor.putInt("total_people_cnt", Count);
                editor.commit();


                Intent intent = new Intent(getApplicationContext(),what_kind.class);
                startActivity(intent);

            }
        });
    }

    private void setDisableValue(int clickedCount ,String value) {
        if (DISABILITY_STATUS == "NONE") {
            if (clickedCount == 1) {
                DISABILITY_STATUS = value;

                if (DISABILITY_STATUS == "Yes") {
                    Disable_not.setEnabled(false); }
                else { Disable.setEnabled(false); }
            }
        }else {
            if (DISABILITY_STATUS == value && clickedCount == 0) {
                DISABILITY_STATUS = "NONE";
                Disable.setEnabled(true);
                Disable_not.setEnabled(true);
            }
        }Log.d("Button status: ", DISABILITY_STATUS);
    }
}

