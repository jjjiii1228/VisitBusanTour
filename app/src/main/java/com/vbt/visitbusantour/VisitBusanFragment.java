package com.vbt.visitbusantour;


import androidx.core.content.ContextCompat;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.text.SpannableStringBuilder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class VisitBusanFragment extends Fragment {

    private View view;
    private Button X_the_sky;
    private Button Lotte_world;
    private Button Children_museum;
    private Button Yacht;
    private Button Avani;
    private Button Mulbitsaek;
    private Button More_info;
    private Context ct;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_visit_busan, container, false);

        ct = getContext();

        // Visit Busan Pass 글자 색 변경
        TextView VisitBusan_txt = view.findViewById(R.id.visitBusan_txt);
        String text = "Visit Busan Pass Benefits";
        int startColor = ContextCompat.getColor(ct, R.color.start);
        int endColor = ContextCompat.getColor(ct, R.color.end);

        SpannableStringBuilder spnnable = new SpannableStringBuilder(text);
        spnnable.setSpan(new ToGradient(text, text, startColor,endColor), 0, text.length(), 0);
        VisitBusan_txt.setText(spnnable);

        X_the_sky = (Button) view.findViewById(R.id.x_the_sky); //fragment에서 findViewByid는 view.을 이용해서 사용
        Lotte_world = (Button) view.findViewById(R.id.lotte_world);
        Children_museum = (Button) view.findViewById(R.id.children_museum);
        Yacht = (Button) view.findViewById(R.id.yacht);
        Avani = (Button) view.findViewById(R.id.avani);
        Mulbitsaek = (Button) view.findViewById(R.id.mulbitsaek);
        More_info = (Button) view.findViewById(R.id.more_info);

        X_the_sky.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 외부 링크로 이동하는 Intent를 생성합니다.
                Uri x_the_sky_url = Uri.parse("https://www.visitbusanpass.com/attractions/_detail?id=GO0000000269"); // 이동하고자 하는 외부 링크 주소를 설정합니다.
                Intent intent = new Intent(Intent.ACTION_VIEW,x_the_sky_url);
                startActivity(intent);
            }
        });
        Lotte_world.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 외부 링크로 이동하는 Intent를 생성합니다.
                Uri lotte_world_url = Uri.parse("https://www.visitbusanpass.com/attractions/_detail?id=GO0000000270"); // 이동하고자 하는 외부 링크 주소를 설정합니다.
                Intent intent = new Intent(Intent.ACTION_VIEW,lotte_world_url);
                startActivity(intent);
            }
        });
        Children_museum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 외부 링크로 이동하는 Intent를 생성합니다.
                Uri children_museum_url = Uri.parse("https://www.visitbusanpass.com/attractions/_detail?id=GO0000000266"); // 이동하고자 하는 외부 링크 주소를 설정합니다.
                Intent intent = new Intent(Intent.ACTION_VIEW,children_museum_url);
                startActivity(intent);
            }
        });
        Yacht.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 외부 링크로 이동하는 Intent를 생성합니다.
                Uri yacht_url = Uri.parse("https://www.visitbusanpass.com/attractions/_detail?id=GO0000000076"); // 이동하고자 하는 외부 링크 주소를 설정합니다.
                Intent intent = new Intent(Intent.ACTION_VIEW,yacht_url);
                startActivity(intent);
            }
        });
        Avani.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 외부 링크로 이동하는 Intent를 생성합니다.
                Uri avani_url = Uri.parse("https://www.visitbusanpass.com/attractions/_detail?id=GO0000000084"); // 이동하고자 하는 외부 링크 주소를 설정합니다.
                Intent intent = new Intent(Intent.ACTION_VIEW,avani_url);
                startActivity(intent);
            }
        });
        Mulbitsaek.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 외부 링크로 이동하는 Intent를 생성합니다.
                Uri mulbitsaek_url = Uri.parse("https://www.visitbusanpass.com/attractions/_detail?id=GO0000001086"); // 이동하고자 하는 외부 링크 주소를 설정합니다.
                Intent intent = new Intent(Intent.ACTION_VIEW,mulbitsaek_url);
                startActivity(intent);
            }
        });
        More_info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 외부 링크로 이동하는 Intent를 생성합니다.
                Uri more_info_url = Uri.parse("https://www.visitbusanpass.com/"); // 이동하고자 하는 외부 링크 주소를 설정합니다.
                Intent intent = new Intent(Intent.ACTION_VIEW,more_info_url);
                startActivity(intent);
            }
        });
        return view;
    }
}