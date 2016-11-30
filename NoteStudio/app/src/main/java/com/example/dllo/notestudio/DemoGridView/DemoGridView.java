package com.example.dllo.notestudio.DemoGridView;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.GridView;

import com.example.dllo.notestudio.R;

import java.util.ArrayList;

/**
 * Created by dllo on 16/11/5.
 */

public class DemoGridView extends AppCompatActivity {
    private GridView gridView;
    private ArrayList<String> data;
    private DemoGridViewAdapter mdemoGridViewAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.demo_banner);
        gridView = (GridView) findViewById(R.id.gv);
        data = new ArrayList<>();
        mdemoGridViewAdapter = new DemoGridViewAdapter(this);

        for (int i = 0; i < 50; i++) {
            data.add("" + i);
        }

        mdemoGridViewAdapter.setData(data);



        gridView.setAdapter(mdemoGridViewAdapter);

    }
}
