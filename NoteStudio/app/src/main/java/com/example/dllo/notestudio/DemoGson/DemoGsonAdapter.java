package com.example.dllo.notestudio.DemoGson;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dllo.notestudio.R;
import com.squareup.picasso.Picasso;

/**
 * Created by dllo on 16/11/5.
 */

public class DemoGsonAdapter extends RecyclerView.Adapter<DemoGsonAdapter.MyViewHolder> {
    private DemoGsonBean demoGsonBean;
    private Context context;

    public DemoGsonAdapter(Context context) {
        this.context = context;
    }

    public DemoGsonAdapter setDemoGsonBean(DemoGsonBean demoGsonBean) {
        this.demoGsonBean = demoGsonBean;
        notifyDataSetChanged();
        return this;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.demo_gson_item,parent,false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.tv1.setText(demoGsonBean.getData().getItems().get(position).getData().getDescription());
        Picasso.with(context).load(demoGsonBean.getData().getItems().get(position).getData().getCover_image_url()).into(holder.iv1);

    }

    @Override
    public int getItemCount() {
        return demoGsonBean != null ? demoGsonBean.getData().getItems().size() : 0;
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView tv1;
        private ImageView iv1;

        public MyViewHolder(View itemView) {
            super(itemView);
            iv1 = (ImageView) itemView.findViewById(R.id.demo_son_iv1);
            tv1 = (TextView) itemView.findViewById(R.id.demo_gson_tv1);
        }
    }

}
