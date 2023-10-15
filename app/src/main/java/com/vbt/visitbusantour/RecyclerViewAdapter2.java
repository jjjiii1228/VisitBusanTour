package com.vbt.visitbusantour;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class RecyclerViewAdapter2 extends RecyclerView.Adapter<RecyclerViewAdapter2.ViewHolder>{

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgView_item2;
        TextView txt_main2;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imgView_item2 = (ImageView) itemView.findViewById(R.id.imgView_item2);
            txt_main2 = (TextView) itemView.findViewById(R.id.txt_main2);
        }
    }
    private ArrayList<RecyclerViewItem2> mList = null;

    public RecyclerViewAdapter2(ArrayList<RecyclerViewItem2> mList) {
        this.mList = mList;
    }

    @NonNull
    @Override
    public RecyclerViewAdapter2.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = inflater.inflate(R.layout.activity_recycler_item2, parent, false);
        RecyclerViewAdapter2.ViewHolder vh = new RecyclerViewAdapter2.ViewHolder(view);
        return vh;
    }

    private OnItemClickListener mListener;

    public void setOnItemClickListener(OnItemClickListener listener) { mListener = listener;}

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter2.ViewHolder holder, int position) {
        RecyclerViewItem2 item = mList.get(position);
        final int currentPosition = position;

        Glide.with(holder.itemView.getContext())
                .load(item.getImgName())
                .into(holder.imgView_item2);

        holder.txt_main2.setText(item.getPlace());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mListener != null) {
                    mListener.onItemClick(currentPosition);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public interface OnItemClickListener {
        void onItemClick(int position);
    }
}

