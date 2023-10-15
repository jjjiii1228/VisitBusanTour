package com.vbt.visitbusantour;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.vbt.visitbusantour.data.DataDTO;

import java.util.ArrayList;

public class CourseRecyclerAdapter extends RecyclerView.Adapter<CourseRecyclerAdapter.ViewHolder> {

    Context mContext;
    ArrayList<DataDTO> data;

    public CourseRecyclerAdapter(Context mContext, ArrayList<DataDTO> data) {
        this.mContext = mContext;
        this.data = data;
    }

    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.course_recycler_layout, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tv_start_date.setText(data.get(position).getStart_date());
        holder.tv_end_date.setText(data.get(position).getEnd_date());
        holder.tv_departure.setText(data.get(position).getDeparture());
        holder.tv_destination.setText(data.get(position).getDestination());
        holder.tv_total_people.setText(data.get(position).getTotal_people_cnt());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tv_start_date, tv_end_date, tv_departure, tv_destination, tv_total_people;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tv_start_date = itemView.findViewById(R.id.tv_start_date);
            tv_end_date = itemView.findViewById(R.id.tv_end_date);
            tv_departure = itemView.findViewById(R.id.tv_departure);
            tv_destination = itemView.findViewById(R.id.tv_destination);
            tv_total_people = itemView.findViewById(R.id.tv_total_people);

        }
    }


}
