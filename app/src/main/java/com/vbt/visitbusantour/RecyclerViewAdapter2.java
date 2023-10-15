package com.vbt.visitbusantour;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

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

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter2.ViewHolder holder, int position) {
        RecyclerViewItem2 item = mList.get(position);

        holder.imgView_item2.setImageResource(R.drawable.ic_launcher_background);
        holder.txt_main2.setText(item.getMainText());
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }
}
