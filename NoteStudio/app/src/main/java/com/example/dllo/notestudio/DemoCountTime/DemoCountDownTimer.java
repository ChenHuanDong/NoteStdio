package com.example.dllo.notestudio.DemoCountTime;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.dllo.notestudio.R;

/**
 * Created by dllo on 16/10/29.
 */

public class DemoCountDownTimer extends AppCompatActivity {
    private Button btn1;
private TimeCount mtimeCount ;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.demo_timercountdown);
        btn1 = (Button) findViewById(R.id.demo_countdown_btn1);


        mtimeCount = new TimeCount(10000,1000);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //开始计时
                mtimeCount.start();
            }
        });



    }
//内部类
    class TimeCount extends CountDownTimer {
//构造方法   两个参数范别是总时长和计时时间间隔
        public TimeCount(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }
//l  剩余时间   倒计时时的操作
        @Override
        public void onTick(long l) {
            btn1.setClickable(false);
            btn1.setText(l / 1000 + "秒");
        }
//结束时的操作
        @Override
        public void onFinish() {
            btn1.setText("再来一遍");
            btn1.setClickable(true);
        }
    }

}
