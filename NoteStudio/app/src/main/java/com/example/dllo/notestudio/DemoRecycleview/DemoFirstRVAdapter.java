package com.example.dllo.notestudio.DemoRecycleview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dllo.notestudio.R;

import java.util.ArrayList;

/**
 * Created by dllo on 16/11/3.
 */

public class DemoFirstRVAdapter extends RecyclerView.Adapter<DemoFirstRVAdapter.MyViewHolder> {
    private ArrayList<FirstRvBean> data ;
    private Context context ;

    public DemoFirstRVAdapter(Context context) {
        this.context = context;
    }

    public DemoFirstRVAdapter setDara(ArrayList<FirstRvBean> data) {
        this.data = data;
        notifyDataSetChanged();
        return this;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.demo_fierst_recycle_item,parent,false);
        MyViewHolder holder = new MyViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
holder.tv1.setText(data.get(position).getName());
        holder.iv1.setImageResource(data.get(position).getPic());
    }

    @Override
    public int getItemCount() {
        return data!=null&&data.size()>0?data.size():0;
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
private TextView tv1 ;
        private ImageView iv1 ;
        public MyViewHolder(View itemView) {
            super(itemView);
            tv1 = (TextView) itemView.findViewById(R.id.demo_first_recycle_tv1);
            iv1 = (ImageView) itemView.findViewById(R.id.demo_first_recycle_iv1);
        }
    }


}
