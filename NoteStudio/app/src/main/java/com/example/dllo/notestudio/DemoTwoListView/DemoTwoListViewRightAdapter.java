package com.example.dllo.notestudio.DemoTwoListView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.dllo.notestudio.R;

import java.util.ArrayList;

import se.emilsjolander.stickylistheaders.StickyListHeadersAdapter;

/**
 * Created by dllo on 16/11/28.
 */

public class DemoTwoListViewRightAdapter extends BaseAdapter implements StickyListHeadersAdapter{
    private ArrayList<String> dataHead , dataBody ;
    private Context context ;

    public void setDataHead(ArrayList<String> dataHead) {
        this.dataHead = dataHead;
        notifyDataSetChanged();
    }

    public void setDataBody(ArrayList<String> dataBody) {
        this.dataBody = dataBody;
        notifyDataSetChanged();
    }

    public DemoTwoListViewRightAdapter(Context context) {
        this.context = context;
    }

    //返回的是头布局集合的
    @Override
    public int getCount() {
        return dataHead.size();
    }

    @Override
    public Object getItem(int i) {
        return dataHead.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    //子的主要内容的数据绑定控件
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        BodyViewHolder holderBody = null;
        if (view == null){
            view = LayoutInflater.from(context).inflate(R.layout.demo_two_listview_reght,viewGroup,false);
            holderBody = new BodyViewHolder(view);
            view.setTag(holderBody);
        }else {
            holderBody = (BodyViewHolder) view.getTag();
        }
        holderBody.tvBady.setText(dataBody.get(i));
        return view;
    }

    @Override
    public View getHeaderView(int position, View convertView, ViewGroup parent) {
        HeadViewHolder holderHead = null;
        if (convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.demo_two_listview_reght_head,parent,false);
            holderHead = new HeadViewHolder(convertView);
            convertView.setTag(holderHead);
        }else {
            holderHead = (HeadViewHolder) convertView.getTag();
        }
        holderHead.tvHead.setText(dataHead.get(position));
        return convertView;
    }

    @Override
    public long getHeaderId(int position) {
        return position;
    }

    class BodyViewHolder {
        private TextView tvBady ;
        public BodyViewHolder(View view) {
            tvBady = (TextView) view.findViewById(R.id.demo_two_listview_right_tv);
        }
    }

    class HeadViewHolder {
        private TextView tvHead ;
        public HeadViewHolder(View view) {
            tvHead = (TextView) view.findViewById(R.id.demo_two_listview_right_head);
        }
    }


}
