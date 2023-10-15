package com.vbt.visitbusantour;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.vbt.visitbusantour.data.DataDTO;

import java.util.ArrayList;
import java.util.List;

public class Day1RecyclerAdapter extends RecyclerView.Adapter<Day1RecyclerAdapter.ViewHolder>{

    Context mContext;
    ArrayList<DataDTO.LocationDTO> data;

    public class ViewHolder extends RecyclerView.ViewHolder {
        CardView cardView;
        TextView txt_day1_place, txt_day1_address, txt_day1_score;

        public ViewHolder(View itemView) {
            super(itemView);

            cardView = itemView.findViewById(R.id.course_cardView);
            txt_day1_place = itemView.findViewById(R.id.txt_day1_place);
            txt_day1_address = itemView.findViewById(R.id.txt_day1_address);
            txt_day1_score = itemView.findViewById(R.id.txt_day1_score);

        }
    }

    public Day1RecyclerAdapter(Context context, ArrayList<DataDTO.LocationDTO> locationList) {
        this.mContext = context;
        this.data = locationList;
    }

    public interface OnItemClickListener {
        void onItemClick(String locationUrl);
    }

    private OnItemClickListener itemClickListener;

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.itemClickListener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(mContext).inflate(R.layout.day1_recycler_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        DataDTO.LocationDTO location = data.get(position);

        final int currentPosition = position;

        holder.txt_day1_place.setText(location.getLocation_name());
        holder.txt_day1_address.setText(location.getLocation_address());
        holder.txt_day1_score.setText(location.getLocation_score());

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (itemClickListener != null) {
                    itemClickListener.onItemClick(location.getLocation_url());
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return data.size();
    }


}
