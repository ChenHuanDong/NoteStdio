package com.example.dllo.notestudio.DemoTwoListView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.dllo.notestudio.R;

import java.util.ArrayList;

/**
 * Created by dllo on 16/11/28.
 */

public class DemoTwoListViewLeftAdapter extends BaseAdapter {
    private ArrayList<String> data ;
    private Context context ;

    public DemoTwoListViewLeftAdapter(Context context) {
        this.context = context;
    }

    public void setData(ArrayList<String> data) {
        this.data = data;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int i) {
        return data.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder = null ;
        if (view == null ){
            view = LayoutInflater.from(context).inflate(R.layout.demo_two_listview_left,viewGroup,false);
            holder = new ViewHolder(view);
            view.setTag(holder);
        }else {
            holder = (ViewHolder) view.getTag();
        }
        holder.tv.setText(data.get(i));
        return view;
    }

    class ViewHolder {
        private TextView tv ;
        public ViewHolder(View view) {
            tv = (TextView) view.findViewById(R.id.demo_two_listview_left_tv);
        }
    }


}
