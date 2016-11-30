package com.example.dllo.notestudio.DemoBannerL;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.dllo.notestudio.R;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by dllo on 16/11/26.
 */

public class DemoBannerActivity extends AppCompatActivity {
    private ArrayList<String> data = new ArrayList<>();
    String url1 = "http://data.corp.36kr.com/api/ws?project=default";
    String url2 = "http://pic29.nipic.com/20130506/3822951_102005116000_2.jpg";
    String url3 =  "http://pic36.nipic.com/20131125/8821914_090743677000_2.jpg";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.demo_demo_banner);

        data = new ArrayList<>();
        data.add(url1);
        data.add(url2);
        data.add(url3);

        Banner banner = (Banner) findViewById(R.id.demo_demo_banner);
        //设置样式
        banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE);
        //设置图片加载器
        banner.setImageLoader(new DemoBannerLMyBanner());
        //设置图片集合
        banner.setImages(data);
        //设置banner动画效果
        banner.setBannerAnimation(Transformer.DepthPage);
        //设置标题集合
        banner.setBannerTitles(Arrays.asList("Title1","Title2","Title3"));
        //设置自动轮播
        banner.isAutoPlay(true);
        //轮播时间间隔
        banner.setDelayTime(2000);
        //小点位置
        banner.setIndicatorGravity(BannerConfig.CENTER);
        //开启banner
        banner.start();



    }
}
