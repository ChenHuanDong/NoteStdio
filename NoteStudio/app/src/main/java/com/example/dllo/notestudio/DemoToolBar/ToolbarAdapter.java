package com.example.dllo.notestudio.DemoToolBar;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.dllo.notestudio.R;

import java.util.ArrayList;

/**
 * Created by dllo on 16/11/5.
 */

public class ToolbarAdapter extends BaseAdapter {
    private ArrayList<String> data;
    private Context context;

    public ToolbarAdapter(Context context) {
        this.context = context;
    }

    public ToolbarAdapter setData(ArrayList<String> data) {
        this.data = data;
        notifyDataSetChanged();
        return this;
    }

    @Override
    public int getCount() {
        return data != null && data.size() > 0 ? data.size() : 0;
    }

    @Override
    public Object getItem(int i) {
        return data != null ? data.get(i) : null;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder = null;
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.demo_toolbar_item, viewGroup, false);
            holder = new ViewHolder(view);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();

        }
        holder.tv1.setText(data.get(i));
        return view;
    }

    class ViewHolder {
        private TextView tv1;

        public ViewHolder(View view) {
            tv1 = (TextView) view.findViewById(R.id.toolbar_tv1);
        }
    }


}
