package com.example.dllo.notestudio.DemoBaseBanner;

import android.content.Context;
import android.media.Image;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.dllo.notestudio.R;
import com.squareup.picasso.Cache;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by dllo on 16/11/28.
 */

public class DemoBaseBannerAdapter extends PagerAdapter implements ViewPager.OnPageChangeListener {
    private ArrayList<String> data;
    private Context context;
    private ViewPager vp;
    private ArrayList<MyPoint> points;

    public DemoBaseBannerAdapter(Context context) {
        this.context = context;
    }

    public void setVp(ViewPager vp) {
        this.vp = vp;
    }

    public void setData(ArrayList<String> data) {
        this.data = data;
    }

    public void setPoints(ArrayList<MyPoint> points) {
        this.points = points;
    }

    @Override
    public int getCount() {
        return data != null ? Integer.MAX_VALUE : 0;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view = LayoutInflater.from(context).inflate(R.layout.demo_base_banner_vp_item, container, false);
        ImageView imageView = (ImageView) view.findViewById(R.id.demo_base_banner_iv);
        Picasso.with(context).load(data.get(position % data.size())).into(imageView);
        container.addView(view);
        //为ViewPager设置改变监听
        vp.addOnPageChangeListener(this);

        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        //删除方法
        if (container.getChildAt(position) == object) {
            container.removeViewAt(position);
        }
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
    }

    @Override
    public void onPageSelected(int position) {
        int a = position % data.size();

        for (MyPoint point : points){
            point.setSelected(false);
        }

        if (a == position % points.size()){
            points.get(a).setSelected(true);
        }

    }

    @Override
    public void onPageScrollStateChanged(int state) {
    }
}
