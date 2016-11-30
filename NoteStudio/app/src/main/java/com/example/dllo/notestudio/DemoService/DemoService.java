package com.example.dllo.notestudio.DemoService;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;

/**
 * Created by dllo on 16/11/21.
 */

public class DemoService extends Service {
    private MyBind myBind = new MyBind();
    private int i;


    @Override
    public void onCreate() {
        super.onCreate();
        new Thread(new Runnable() {

            @Override
            public void run() {
                for (i = 0; i < 10; i++) {
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();


    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return myBind;
    }

    @Override
    public boolean onUnbind(Intent intent) {
        return super.onUnbind(intent);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    class MyBind extends Binder {

        public int qwe(){
            return i ;
        }


    }


}
