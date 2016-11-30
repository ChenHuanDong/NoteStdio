package com.example.dllo.notestudio.DemoRecycleview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import com.example.dllo.notestudio.R;

import java.util.ArrayList;

/**
 * Created by dllo on 16/11/3.
 */

public class DemoRecycleviewfirst extends AppCompatActivity {
    private RecyclerView mrecyclerView ;
    private ArrayList<FirstRvBean> data ;
    private DemoFirstRVAdapter demoFirstRVAdapter ;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.demo_first_recycleview);
        mrecyclerView = (RecyclerView) findViewById(R.id.demo_frist_rv_rv1);
        data = new ArrayList<>();
        demoFirstRVAdapter = new DemoFirstRVAdapter(this);

        for (int i = 0; i < 50; i++) {
            FirstRvBean qq = new FirstRvBean();
            qq.setName(i+"").setPic(R.mipmap.ic_launcher);
            data.add(qq);

        }

        demoFirstRVAdapter.setDara(data);
        mrecyclerView.setAdapter(demoFirstRVAdapter);
        mrecyclerView.setLayoutManager(new LinearLayoutManager(this));


//        LinearLayoutManager man1 = new LinearLayoutManager(this,2,false);
//        GridLayoutManager man2 = new GridLayoutManager(this,2);
//        StaggeredGridLayoutManager man3  ;



    }
}
