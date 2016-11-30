package com.example.dllo.notestudio.Demodiffrecyview;

import android.content.Context;
import android.support.v4.content.ContextCompat;
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

public class DemoDiffRecAdapter extends RecyclerView.Adapter {
    private ArrayList<DemoDiffRevBean> data ;
    private Context context ;
    public static final int TYPEONE = 1 ;
    public static final int TYPETWO = 2 ;

    public DemoDiffRecAdapter(Context context) {
        this.context = context;
    }

    public DemoDiffRecAdapter setData(ArrayList<DemoDiffRevBean> data) {
        this.data = data;
        notifyDataSetChanged();
        return this;
    }

    @Override
    public int getItemViewType(int position) {

        return data.get(position).getType();
    }




    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder holder = null ;
        switch (viewType){
            case TYPEONE:
                View view1 = LayoutInflater.from(context).inflate(R.layout.demo_diffrev_father,parent,false);
                holder = new FatherViewHolder(view1);
                break;
            case TYPETWO:
                View view2 = LayoutInflater.from(context).inflate(R.layout.demo_diffrev_son,parent,false);
                holder = new SonViewHolder(view2);
                break;

        }


        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        //上面有判断条件,下面要自己写
        int typee = getItemViewType(position);

        switch (typee){
            case TYPEONE:
                //强转
                FatherViewHolder fatherViewHolder = (FatherViewHolder) holder;
                fatherViewHolder.tv1.setText(data.get(position).getName());

                break;
            case TYPETWO:
                SonViewHolder sonViewHolder = (SonViewHolder) holder;
                sonViewHolder.tv2.setText(data.get(position).getName());
                break;
        }


    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class  FatherViewHolder extends RecyclerView.ViewHolder{
        private TextView tv1 ;

        public FatherViewHolder(View itemView) {
            super(itemView);

            tv1 = (TextView) itemView.findViewById(R.id.demo_diffrec_father_tv1);
        }
    }

    class SonViewHolder extends RecyclerView.ViewHolder{
        private TextView tv2 ;
        public SonViewHolder(View itemView) {
            super(itemView);
            tv2 = (TextView) itemView.findViewById(R.id.demo_diffrec_son_tv1);
        }
    }


}
