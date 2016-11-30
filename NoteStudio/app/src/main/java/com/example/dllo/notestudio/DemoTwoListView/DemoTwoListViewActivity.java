package com.example.dllo.notestudio.DemoTwoListView;

import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.dllo.notestudio.BaseActivity;
import com.example.dllo.notestudio.R;

import java.util.ArrayList;

import se.emilsjolander.stickylistheaders.StickyListHeadersListView;

/**
 * Created by dllo on 16/11/28.
 */

public class DemoTwoListViewActivity extends BaseActivity {
    private ListView lvLeft ;
    private StickyListHeadersListView lvRight ;
    private ArrayList<String> dataHead , dataRight , dataLeft ;
    private DemoTwoListViewLeftAdapter myLeftAdapter ;
    private DemoTwoListViewRightAdapter myRightAdapter;

    @Override
    public int setMyLayout() {
        return R.layout.demo_two_listview;
    }

    @Override
    public void initMyView() {
        lvLeft = (ListView) findViewById(R.id.demo_two_listview_left_ls);
        lvRight = (StickyListHeadersListView) findViewById(R.id.demo_two_listview_right_ls);
        dataHead = new ArrayList<>();
        dataLeft = new ArrayList<>();
        dataRight = new ArrayList<>();
        myLeftAdapter = new DemoTwoListViewLeftAdapter(this);
        myRightAdapter = new DemoTwoListViewRightAdapter(this);

    }

    @Override
    public void initMyData() {
        for (int i = 0; i < 150; i++) {
            dataRight.add("右边内容"+i);
            dataHead.add("右边头部内容"+i);
            dataLeft.add("左边内容"+i);
        }
        myLeftAdapter.setData(dataLeft);
        myRightAdapter.setDataBody(dataRight);
        myRightAdapter.setDataHead(dataHead);
        lvLeft.setAdapter(myLeftAdapter);
        lvRight.setAdapter(myRightAdapter);

        //左边listview点击跳转到右边指定的条数
        lvLeft.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                lvRight.setSelection(i);
            }
        });
        //右边listview滑动监听
        lvRight.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView absListView, int i) {

            }

            @Override
            public void onScroll(AbsListView absListView, int i, int i1, int i2) {
                //第二个参数是左边距离上面的距离
                lvLeft.smoothScrollToPositionFromTop(i , 0);
            }
        });



    }
}
