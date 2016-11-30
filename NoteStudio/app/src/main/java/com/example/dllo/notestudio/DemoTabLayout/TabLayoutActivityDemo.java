package com.example.dllo.notestudio.DemoTabLayout;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.example.dllo.notestudio.DemoTabLayout.DemoTabLayoutAdapter;
import com.example.dllo.notestudio.DemoTabLayout.DemoTabLayoutfragment1;
import com.example.dllo.notestudio.DemoTabLayout.DemoTabLayoutfragment2;
import com.example.dllo.notestudio.R;

import java.util.ArrayList;

/**
 * Created by dllo on 16/10/29.
 */

public class TabLayoutActivityDemo extends AppCompatActivity {
    private ViewPager viewPager;
    private ArrayList<Fragment> data;
    private TabLayout tabLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.demo_activity_tablayout);

        viewPager = (ViewPager) findViewById(R.id.tablayout_demo_vp1);
        data = new ArrayList<>();
        tabLayout = (TabLayout) findViewById(R.id.tablayout_demo_tab1);

        data.add(new DemoTabLayoutfragment1());
        data.add(new DemoTabLayoutfragment2());
        data.add(new DemoTabLayoutfragment1());
        data.add(new DemoTabLayoutfragment2());

        DemoTabLayoutAdapter demoTabLayoutAdapter = new DemoTabLayoutAdapter(getSupportFragmentManager(), data);
        viewPager.setAdapter(demoTabLayoutAdapter);

        //绑定tablayout方法,必须在绑定适配器之后
        tabLayout.setupWithViewPager(viewPager);
        //设置文字选择与未选择颜色,最好在绑定tablayout之后
        tabLayout.setTabTextColors(Color.GRAY, Color.BLACK);
        //设置下方指示器颜色,最好在绑定tablayout之后
        tabLayout.setSelectedTabIndicatorColor(Color.RED);


    }
}
