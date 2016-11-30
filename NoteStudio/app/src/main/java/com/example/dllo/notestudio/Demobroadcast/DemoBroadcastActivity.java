package com.example.dllo.notestudio.Demobroadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.dllo.notestudio.R;

/**
 * Created by dllo on 16/11/15.
 */

public class DemoBroadcastActivity extends AppCompatActivity {
    private Button btn1 ;
    private TextView tv1 ;
    private EditText et1 ;
    private MyBR myBR ;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.demo_broadcast_activity);
        btn1 = (Button) findViewById(R.id.demo_bro_btn1);
        tv1 = (TextView) findViewById(R.id.demo_bro_tv1);
        et1 = (EditText) findViewById(R.id.demo_bro_et1);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //发送广播(带值)
                Intent intent = new Intent(getPackageName()+".MY");
                intent.putExtra("demo_bro_qwe" , et1.getText().toString() );
                sendBroadcast(intent);
            }
        });

        //接收广播动态注册   //在ondestroy生命周期取消注册
        myBR = new MyBR();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(getPackageName()+".MY");
        registerReceiver(myBR , intentFilter);
    }
    //


    @Override
    protected void onDestroy() {
        super.onDestroy();
        //取消注册
        unregisterReceiver(myBR);
    }

    //内部类
    class MyBR extends BroadcastReceiver{
        @Override
        public void onReceive(Context context, Intent intent) {
            //这里面写接收广播的逻辑
            tv1.setText(intent.getStringExtra("demo_bro_qwe"));
        }
    }

}
