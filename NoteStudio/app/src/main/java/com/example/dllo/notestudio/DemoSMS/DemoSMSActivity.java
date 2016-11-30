package com.example.dllo.notestudio.DemoSMS;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;

import com.example.dllo.notestudio.R;

/**
 * Created by dllo on 16/11/14.
 */

public class DemoSMSActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btn1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.demo_sms_activity);

        btn1 = (Button) findViewById(R.id.demo_sms_btn1);
        btn1.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        SmsManager smsManager = SmsManager.getDefault();
        //第一个参数是收信人电话号 ,
        smsManager.sendTextMessage("86958850" , null,"短信内容",null,null);

    }
}
