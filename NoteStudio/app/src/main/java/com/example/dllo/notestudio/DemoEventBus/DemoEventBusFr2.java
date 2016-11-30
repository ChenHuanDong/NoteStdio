package com.example.dllo.notestudio.DemoEventBus;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.dllo.notestudio.R;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

/**
 * Created by dllo on 16/11/17.
 */

public class DemoEventBusFr2 extends Fragment {
    private TextView tv1 ;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //接收EventBus   必须在onCreatView生命周期
        //注册
        EventBus.getDefault().register(this);

        View view = inflater.inflate(R.layout.demo_event_bus_fr2,container,false);
        return view;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        //取消注册
        EventBus.getDefault().unregister(this);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tv1 = (TextView) view.findViewById(R.id.demo_eve_tv1);
    }

    @Subscribe  //获取EventBus传过来的值必须要写@Subs  相当于接头暗号!!!!!
    public void getEventBus (DemoEventBean bean){
        String str = bean.getStr();
        tv1.setText(str);

    }


}
