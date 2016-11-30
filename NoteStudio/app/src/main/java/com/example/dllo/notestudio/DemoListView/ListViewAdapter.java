package com.example.dllo.notestudio.DemoListView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dllo.notestudio.R;

import java.util.ArrayList;

/**
 * Created by dllo on 16/10/29.
 */

public class ListViewAdapter extends BaseAdapter {
    private ArrayList<ListViewBean> data ;
    private Context context ;

    public ListViewAdapter(Context context) {
        this.context = context;
    }

    public void setData(ArrayList<ListViewBean> data) {
        this.data = data;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return data!= null &&data.size()>0?data.size():0;
    }

    @Override
    public Object getItem(int i) {
        return data!=null ?data.get(i):null;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolderDemo holder = null ;
        if (view == null){
            view = LayoutInflater.from(context).inflate(R.layout.demo_listview2,viewGroup,false);
            holder = new ViewHolderDemo(view);
            view.setTag(holder);
        }else {
            holder = (ViewHolderDemo) view.getTag();
        }

        holder.tv1.setText(data.get(i).getNamebean());
        holder.iv1.setImageResource(data.get(i).getPicbean());
        return view;
    }

    class  ViewHolderDemo {
        private TextView tv1 ;
        private ImageView iv1 ;

        public ViewHolderDemo(View view) {
            tv1 = (TextView) view.findViewById(R.id.demo_listview_tv1);
            iv1 = (ImageView) view.findViewById(R.id.demo_listview_iv1);
        }
    }













}
