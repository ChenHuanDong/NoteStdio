package com.example.dllo.notestudio.DemoBaseBanner;

/**
 * Created by dllo on 16/11/28.
 */

import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.LinearLayout;

import com.example.dllo.notestudio.BaseActivity;
import com.example.dllo.notestudio.R;

import java.util.ArrayList;

public class DemoBaseBannerActivity extends BaseActivity {
    private ArrayList<String> data;
    private DemoBaseBannerAdapter myAdapter;
    private ViewPager vp;
    private Handler handler;
    private LinearLayout linearLayout;
    private ArrayList<MyPoint> points;
    private boolean flag = true;

    @Override
    public int setMyLayout() {
        return R.layout.demo_base_banner;
    }

    @Override
    public void initMyView() {
        vp = (ViewPager) findViewById(R.id.demo_base_banner_vp);
        linearLayout = (LinearLayout) findViewById(R.id.demo_base_banner_ll);
        data = new ArrayList<>();
        points = new ArrayList<>();
        myAdapter = new DemoBaseBannerAdapter(this);
    }

    @Override
    public void initMyData() {
        data.add("http://img4.duitang.com/uploads/item/201511/15/20151115212107_JkX3R.jpeg");
        data.add("http://img4.duitang.com/uploads/item/201511/15/20151115212107_JkX3R.jpeg");
        data.add("http://img4.duitang.com/uploads/item/201511/15/20151115212107_JkX3R.jpeg");
        data.add("http://img4.duitang.com/uploads/item/201511/15/20151115212107_JkX3R.jpeg");
        data.add("http://img4.duitang.com/uploads/item/201511/15/20151115212107_JkX3R.jpeg");
        myAdapter.setData(data);
        vp.setAdapter(myAdapter);

        handler = new Handler(new Handler.Callback() {
            @Override
            public boolean handleMessage(Message message) {
                //选中当前页数
                vp.setCurrentItem(vp.getCurrentItem() + 1 );
                return false;
            }
        });


        if (flag){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    //
                    while (true){
                        try {
                            Thread.sleep(2000);
                            handler.sendEmptyMessage(1);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                    }


                }
            }).start();
            flag = false;
        }

        for (int i = 0; i < data.size(); i++) {
            MyPoint point = new MyPoint(this);
            if (i == 0){
                point.setSelected(true);
            }
            points.add(point);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(50,50);
            params.leftMargin = 20;
            params.rightMargin = 20 ;
            linearLayout.addView(point , params);
        }
        myAdapter.setPoints(points);
        myAdapter.setVp(vp);


    }
}
