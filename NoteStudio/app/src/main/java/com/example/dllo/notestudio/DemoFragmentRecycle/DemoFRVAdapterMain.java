package com.example.dllo.notestudio.DemoFragmentRecycle;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by dllo on 16/11/29.
 */

public class DemoFRVAdapterMain extends FragmentPagerAdapter{
    private ArrayList<Fragment> arrayList ;
    private static BeanFRVTab bean ;

    //把static去掉
    public void setBean(BeanFRVTab bean) {
        DemoFRVAdapterMain.bean = bean;
        notifyDataSetChanged();
    }

    public DemoFRVAdapterMain(FragmentManager fm) {
        super(fm);
    }



    @Override  //不同返回的布局在这里面判断
    public Fragment getItem(int position) {
        if (position == 0){
            return new DemoFRVHomeFragment();
        }else {
            return DemoFRVCommendFragment.newInstance(position);
        }
    }

    @Override
    public int getCount() {
        return bean == null ? 0 :bean.getData().getCandidates().size();
    }

    //自己写的方法
    public static int getData(int position){
        return  bean.getData().getCandidates().get(position).getId();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return bean.getData().getCandidates().get(position).getName();
    }
}
