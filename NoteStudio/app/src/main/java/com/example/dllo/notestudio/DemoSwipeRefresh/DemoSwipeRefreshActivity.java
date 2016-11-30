package com.example.dllo.notestudio.DemoSwipeRefresh;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.dllo.notestudio.R;

import java.util.ArrayList;

/**
 * Created by dllo on 16/11/21.
 */

public class DemoSwipeRefreshActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.demo_swipefresh);

        final SwipeRefreshLayout rvRefresh = (SwipeRefreshLayout) findViewById(R.id.demo_swip_refresh);
        RecyclerView rv = (RecyclerView) findViewById(R.id.demo_swip_rv);
        final ArrayList<String> data = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            data.add("我是第"+(i+1) +"条数据");
        }

        final DemoSwipeAdapter myadapter = new DemoSwipeAdapter(this);
        myadapter.setData(data);
        rv.setAdapter(myadapter);

        LinearLayoutManager manger = new LinearLayoutManager(this);
        rv.setLayoutManager(manger);

        //上面都一样没变
        //下拉监听------加载   里面用匿名内部类方法
        // 匿名内部类就是我们写的那个类 里面构造方法参数是连接别忘了
        rv.addOnScrollListener(new DemoSwipEndLessOnScrollLinstence(manger) {
            @Override
            protected void onLoadMore(int currentPage) {
                //放加载数据
                data.add("加载出来的数据" + currentPage);
                //刷新适配器
                myadapter.notifyDataSetChanged();
            }
        });


        //上拉刷新
        rvRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                //第一个参数是位置
                data.add(0 , "我是刷新出来的数据");
                myadapter.notifyDataSetChanged();

                rvRefresh.setRefreshing(false);

            }
        });




    }
}
