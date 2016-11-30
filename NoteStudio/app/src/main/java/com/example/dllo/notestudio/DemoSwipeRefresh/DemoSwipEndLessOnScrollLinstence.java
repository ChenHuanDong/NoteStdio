package com.example.dllo.notestudio.DemoSwipeRefresh;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

/**
 * Created by dllo on 16/11/21.
 */

public abstract class DemoSwipEndLessOnScrollLinstence extends RecyclerView.OnScrollListener {
    private LinearLayoutManager manager ;

    //定义当前页初始为0
    private int currentPage = 0 ;

    //已经加载的item数量
    private int totalCount ;
    //主要用来储存上一个totalcount
    private int previousTotal = 0 ;

    //定义屏幕可见item数量
    private int visiblecount ;

    //屏幕上可见item的第一个
    private int firstVisible ;

    //判断是否上拉数据
    private boolean loading = true ;



    //构造方法
    public DemoSwipEndLessOnScrollLinstence(LinearLayoutManager manager) {
        this.manager = manager;
    }

    //滑动监听事件(手打)
    @Override
    public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
        super.onScrolled(recyclerView, dx, dy);
        //显示的条目数
        visiblecount = recyclerView.getChildCount();

        //显示数据总数
        totalCount = manager.getItemCount();
        //设置可见第一个item
        firstVisible = manager.findFirstVisibleItemPosition();

        //判断是否有数据
        if (loading){
            if (totalCount > previousTotal){
                //加载结束
                loading = false ;
                previousTotal = totalCount ;
            }
        }

        if (!loading && totalCount - visiblecount <= firstVisible){
            currentPage++;
            //自定义方法
            onLoadMore(currentPage);
            loading = true;

        }




    }

    //写抽象方法  在Activity中监听到这个类 并实现这个方法
    protected  abstract  void onLoadMore (int currentPage);

}
