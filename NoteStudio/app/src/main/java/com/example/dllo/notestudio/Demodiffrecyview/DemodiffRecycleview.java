package com.example.dllo.notestudio.Demodiffrecyview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.dllo.notestudio.R;

import java.util.ArrayList;

/**
 * Created by dllo on 16/11/21.
 */

public class DemodiffRecycleview extends AppCompatActivity{
    private RecyclerView rv ;
    private ArrayList<DemoDiffRevBean> data ;
    private DemoDiffRecAdapter myadapter ;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.demo_diffrecycleview);
        rv = (RecyclerView) findViewById(R.id.demo_diffrec_rv);
        data = new ArrayList<>();
        myadapter = new DemoDiffRecAdapter(this);

        data.add(new DemoDiffRevBean().setType(1).setName("1"));
        data.add(new DemoDiffRevBean().setType(2).setName("2"));
        data.add(new DemoDiffRevBean().setType(1).setName("3"));
        data.add(new DemoDiffRevBean().setType(2).setName("4"));
        data.add(new DemoDiffRevBean().setType(1).setName("5"));
        data.add(new DemoDiffRevBean().setType(2).setName("6"));
        data.add(new DemoDiffRevBean().setType(1).setName("7"));
        data.add(new DemoDiffRevBean().setType(2).setName("8"));
        data.add(new DemoDiffRevBean().setType(1).setName("9"));
        data.add(new DemoDiffRevBean().setType(2).setName("10"));

        myadapter.setData(data);
        rv.setAdapter(myadapter);
        rv.setLayoutManager(new LinearLayoutManager(this));

    }
}
