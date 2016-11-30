package com.example.dllo.notestudio.DemoListView;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.example.dllo.notestudio.DemoListView.ListViewAdapter;
import com.example.dllo.notestudio.DemoListView.ListViewBean;
import com.example.dllo.notestudio.R;

import java.util.ArrayList;

/**
 * Created by dllo on 16/10/29.
 */

public class ListViewDemo extends AppCompatActivity {
    private ListView listView ;
    private ListViewAdapter listAdapter ;
    private ArrayList<ListViewBean> data ;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.demo_listview1);


        listView = (ListView) findViewById(R.id.demo_listview_ls);
        listAdapter = new ListViewAdapter(this);
        data = new ArrayList<>();

        for (int i = 0; i < 50; i++) {
            ListViewBean bean = new ListViewBean("第"+(i+1)+"条",R.mipmap.ic_launcher);
            data.add(bean);
        }

        listAdapter.setData(data);
        listView.setAdapter(listAdapter);











    }
}
