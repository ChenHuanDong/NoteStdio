package com.example.dllo.notestudio.DemoBroTwoFr;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.LocalBroadcastManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.dllo.notestudio.R;

/**
 * Created by dllo on 16/11/15.
 */

public class DemoTwoFragmentAll extends Fragment implements View.OnClickListener {
    private Button btn1 ;
    private EditText et1 ;
    private TextView tv1 ;

    private LocalBroadcastManager broadcastManager ;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.demo_two_bro_items,container,false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        btn1 = (Button) view.findViewById(R.id.demo_two_bro_items_btn1);
        tv1 = (TextView) view.findViewById(R.id.demo_two_bro_items_tv1);
        et1 = (EditText) view.findViewById(R.id.demo_two_bro_items_et1);
        btn1.setOnClickListener(this);

        //自定义接收广播方法
        receivebroadcast();
    }

    private void receivebroadcast() {
        broadcastManager = LocalBroadcastManager.getInstance(getContext());
        IntentFilter intentFlter = new IntentFilter();
        intentFlter.addAction("com.example.dllo.notestudio.DemoBroTwoFr.MYMY");
        broadcastManager.registerReceiver( broadcast , intentFlter);
    }


    //定义的广播接收者对象
    private BroadcastReceiver broadcast = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            //这里写要执行的逻辑
            tv1.setText(intent.getStringExtra("key1"));
        }
    };




    @Override
    public void onClick(View view) {
        //传值
        Intent intent = new Intent("com.example.dllo.notestudio.DemoBroTwoFr.MYMY");
        intent.putExtra("key1" , et1.getText().toString());
        //在fragment里面的广播发送方法不一样
        LocalBroadcastManager.getInstance(getContext()).sendBroadcast(intent);
    }








}
