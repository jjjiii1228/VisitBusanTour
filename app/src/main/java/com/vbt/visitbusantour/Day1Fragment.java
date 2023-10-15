package com.vbt.visitbusantour;

import android.content.Intent;
import android.location.Location;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.vbt.visitbusantour.data.DataDTO;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Day1Fragment extends Fragment {

    View view;

    LinearLayoutManager layoutManager;

    private RecyclerView mRecyclerView;
    private Day1RecyclerAdapter adapter;
    private ArrayList<DataDTO.LocationDTO> locationList = new ArrayList<>();;

    DataDTO.LocationDTO locationDTO;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_day1, container, false);

        mRecyclerView = view.findViewById(R.id.day1_recycler);

        layoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(layoutManager);

        adapter = new Day1RecyclerAdapter(getActivity(), locationList);
        mRecyclerView.setAdapter(adapter);

        parser();

        adapter.setOnItemClickListener(new Day1RecyclerAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(String locationUrl) {
                try {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(locationUrl));
                    startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

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
            JSONArray courseDetailArray = jsonObject.getJSONObject("data").getJSONArray("course_detail");

           if (courseDetailArray.length() > 0) {
                JSONObject dataObject = courseDetailArray.getJSONObject(0);
                String date = dataObject.getString("date");
                JSONArray locationArray = dataObject.getJSONArray("location");

                Log.d("DataParsing", "Date : " + date);
                for (int j = 0; j < locationArray.length(); j++) {
                    JSONObject locationObject = locationArray.getJSONObject(j);

                    String location_name = locationObject.getString("location_name");
                    String location_address = locationObject.getString("location_address");
                    String location_score = locationObject.getString("location_score");
                    String location_url = locationObject.getString("location_url");

                    locationDTO = new DataDTO.LocationDTO(location_name, location_address, location_score, location_url);
                    locationList.add(locationDTO);

                    Log.d("DataParsing", "Name: " + location_name);
                    Log.d("DataParsing", "Address: " + location_address);
                    Log.d("DataParsing", "Score: " + location_score);

                }
            }
            adapter.notifyDataSetChanged();

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