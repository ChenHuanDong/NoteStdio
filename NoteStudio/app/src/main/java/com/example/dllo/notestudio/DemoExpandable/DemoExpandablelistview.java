package com.example.dllo.notestudio.DemoExpandable;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.Toast;

import com.example.dllo.notestudio.R;

import java.util.ArrayList;

/**
 * Created by dllo on 16/11/1.
 */

public class DemoExpandablelistview extends AppCompatActivity {
    private ExpandableListView expandableListView;
    private DemoExAdapter demoExAdapter;
    private ArrayList<String> father;
    private ArrayList<ArrayList<String>> son;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.demo_expandable_listview);

        father = new ArrayList<>();
        son = new ArrayList<>();

        expandableListView = (ExpandableListView) findViewById(R.id.demo_expandable_ls);
        demoExAdapter = new DemoExAdapter(this);

        for (int i = 0; i < 10; i++) {
            father.add("我是父列表" + (i + 1));
            ArrayList<String> mid = new ArrayList<>();
            for (int p = 0; p < 5; p++) {
                mid.add("我是子类表" + (p + 1));
                son.add(mid);
            }
        }

        demoExAdapter.setFather(father);
        demoExAdapter.setSon(son);

        expandableListView.setAdapter(demoExAdapter);


        expandableListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView expandableListView, View view, int i, long l) {
                Toast.makeText(DemoExpandablelistview.this, "父列表:" + (i+1) , Toast.LENGTH_SHORT).show();
                return false;
            }
        });

expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
    @Override
    public boolean onChildClick(ExpandableListView expandableListView, View view, int i, int i1, long l) {
        Toast.makeText(DemoExpandablelistview.this, "父列表:"+(i+1)+"子列表:"+(i1+1) , Toast.LENGTH_SHORT).show();


        return false;
    }
});

    }
}
