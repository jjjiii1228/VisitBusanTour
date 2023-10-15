package com.vbt.visitbusantour;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.vbt.visitbusantour.data.DataDTO;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class MyCourseFragment extends Fragment {

    // Load Course data
    RecyclerView rv_recycle;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView.Adapter adapter;

    DataDTO dto;
    ArrayList<DataDTO> data = new ArrayList<>();

    private View view;
    private Button myCourse_btn;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // 데이터 초기화 및 로드
        if (data.isEmpty()) {
            parser();
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_my_course, container, false);

        myCourse_btn = (Button) view.findViewById(R.id.make_course_btn); //fragment에서 findViewByid는 view.을 이용해서 사용

        myCourse_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), CourseMaking_Splash.class); //fragment라서 activity intent와는 다른 방식
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intent);
            }
        });

        // Load Course Info
        rv_recycle = view.findViewById(R.id.course_recycler);

        layoutManager = new LinearLayoutManager(getActivity());
        rv_recycle.setLayoutManager(layoutManager);

        adapter = new CourseRecyclerAdapter(getActivity(), data);
        rv_recycle.setAdapter(adapter);

        return view;
    }

    private void parser() {
        InputStream inputStream = getResources().openRawResource(R.raw.course_result);
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        StringBuffer stringBuffer = new StringBuffer();
        String line = null;

        try {
            while ((line = bufferedReader.readLine()) != null) {
                stringBuffer.append(line);
            }
            Log.v("TAG", "StringBuffer : " + stringBuffer.toString());

            JSONObject jsonObject = new JSONObject(stringBuffer.toString());
            JSONObject dataObject = jsonObject.getJSONObject("data");

            String start_date = dataObject.getString("start_date");
            String end_date = dataObject.getString("end_date");
            String departure = dataObject.getString("departure");
            String destination = dataObject.getString("destination");
            String total_people_cnt = dataObject.getString("total_people_cnt");

            dto = new DataDTO(start_date, end_date, departure, destination, total_people_cnt);
            data.add(dto);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if(inputStream != null) inputStream.close();
                if (inputStreamReader != null) inputStreamReader.close();
                if (bufferedReader != null) bufferedReader.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}