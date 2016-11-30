package com.example.dllo.notestudio.Tool.VolleyTwicePackge;

import android.app.Application;
import android.content.Context;

/**
 * Created by leisure on 2016/11/28.
 */
//切记如何使用!!!!!
    //清单文件中加入自己的App
public class MyApp extends Application {
    private static Context mContext;
    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;

    }
    //对外提供一个获取Context对象的方法
    public static Context getmContext() {
        return mContext;
    }
}
