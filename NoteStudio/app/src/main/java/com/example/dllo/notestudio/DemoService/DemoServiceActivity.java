package com.example.dllo.notestudio.DemoService;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.dllo.notestudio.MainActivity;
import com.example.dllo.notestudio.R;

/**
 * Created by dllo on 16/11/21.
 */

public class DemoServiceActivity extends AppCompatActivity {
    private ServiceConnection connection ;
    private DemoService.MyBind myBind ;
    private Button btn1 ;
    private Intent intent;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.demo_service_activity);

        connection = new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                myBind = (DemoService.MyBind) iBinder;
            }

            @Override
            public void onServiceDisconnected(ComponentName componentName) {

            }
        };

        intent = new Intent(this , DemoService.class);

        btn1 = (Button) findViewById(R.id.demo_serv_btn1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                bindService(intent, connection , BIND_AUTO_CREATE);
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                            while (true){
                                if (myBind!=null){
                                    if (myBind.qwe() == 9){
                                        Intent intent1 = new Intent(DemoServiceActivity.this , MainActivity.class);
                                        startActivity(intent1);
                                    }
                                }
                            }
                    }
                }).start();
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbindService(connection);
    }
}
