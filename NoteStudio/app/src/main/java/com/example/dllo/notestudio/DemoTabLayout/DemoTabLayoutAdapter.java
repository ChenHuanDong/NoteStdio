package com.example.dllo.notestudio.DemoTabLayout;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by dllo on 16/10/29.
 */

public class DemoTabLayoutAdapter extends FragmentPagerAdapter{
    private ArrayList<Fragment> data ;
    private String[] title = {"第一页","第二页","第三页","第四页"};
    public DemoTabLayoutAdapter(FragmentManager fm , ArrayList<Fragment> data) {
        super(fm);
        this.data = data ;
    }

    @Override
    public Fragment getItem(int position) {

        return data.get(position);
    }

    @Override
    public int getCount() {

        return data.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {

        return title[position];
    }
}
