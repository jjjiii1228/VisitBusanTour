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

public class Day2RecyclerAdapter extends RecyclerView.Adapter<Day2RecyclerAdapter.ViewHolder>{

    Context mContext;
    ArrayList<DataDTO.LocationDTO> data;

    public class ViewHolder extends RecyclerView.ViewHolder {
        CardView cardView2;
        TextView txt_day2_place, txt_day2_address, txt_day2_score;

        public ViewHolder(View itemView) {
            super(itemView);

            cardView2 = itemView.findViewById(R.id.course2_cardView);
            txt_day2_place = itemView.findViewById(R.id.txt_day2_place);
            txt_day2_address = itemView.findViewById(R.id.txt_day2_address);
            txt_day2_score = itemView.findViewById(R.id.txt_day2_score);

        }
    }

    public Day2RecyclerAdapter(Context context, ArrayList<DataDTO.LocationDTO> locationList) {
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

        View view = LayoutInflater.from(mContext).inflate(R.layout.day2_recycler_layout, parent, false);
        return new Day2RecyclerAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        DataDTO.LocationDTO location = data.get(position);

        final int currentPosition = position;

        holder.txt_day2_place.setText(location.getLocation_name());
        holder.txt_day2_address.setText(location.getLocation_address());
        holder.txt_day2_score.setText(location.getLocation_score());

        if (holder.cardView2 != null) {
            holder.cardView2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (itemClickListener != null) {
                        itemClickListener.onItemClick(location.getLocation_url());
                    }
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
