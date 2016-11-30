package com.example.dllo.notestudio.DemoSwipeRefresh;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.dllo.notestudio.R;

import java.util.ArrayList;

/**
 * Created by dllo on 16/11/21.
 */

public class DemoSwipeAdapter extends RecyclerView.Adapter<DemoSwipeAdapter.MyViewHolder> {
    private ArrayList<String> data ;
    private Context context ;

    public DemoSwipeAdapter(Context context) {
        this.context = context;
    }

    public DemoSwipeAdapter setData(ArrayList<String> data) {
        this.data = data;
        notifyDataSetChanged();
        return this;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.demo_swipe_item , parent,false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.tv1.setText(data.get(position));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView tv1 ;
        public MyViewHolder(View itemView) {
            super(itemView);
            tv1 = (TextView) itemView.findViewById(R.id.demo_swip_item_tv1);
        }
    }
}
