package com.vbt.visitbusantour;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    private RecyclerView mRecyclerView1;
    private RecyclerView mRecyclerView2;

    private ArrayList<RecyclerViewItem> mList1;
    private ArrayList<RecyclerViewItem2> mList2;

    private RecyclerViewAdapter mRecyclerViewAdapter;
    private RecyclerViewAdapter2 mRecyclerViewAdapter2;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        mRecyclerView1 = (RecyclerView) view.findViewById(R.id.recyclerView1);
        mRecyclerView2 = (RecyclerView) view.findViewById(R.id.recyclerView2);

        mList1 = new ArrayList<>();
        mList2 = new ArrayList<>();

        for(int i=0;i<5;i++) {
            addItem("iconName", "Taek" + i);
        }

        mRecyclerViewAdapter = new RecyclerViewAdapter(mList1);
        mRecyclerViewAdapter2 = new RecyclerViewAdapter2(mList2);

        mRecyclerView1.setAdapter(mRecyclerViewAdapter);
        mRecyclerView1.setLayoutManager(new LinearLayoutManager(getActivity(), RecyclerView.HORIZONTAL, false));

        mRecyclerView2.setAdapter(mRecyclerViewAdapter2);
        mRecyclerView2.setLayoutManager(new LinearLayoutManager(getActivity(), RecyclerView.HORIZONTAL, false));

        return view;
    }

    public void addItem(String imgName, String mainText) {
        RecyclerViewItem item = new RecyclerViewItem();
        RecyclerViewItem2 item2 = new RecyclerViewItem2();

        item.setImgName(imgName);
        item.setMainText(mainText);

        item2.setImgName(imgName);
        item2.setMainText(mainText);

        mList1.add(item);
        mList2.add(item2);
    }
}