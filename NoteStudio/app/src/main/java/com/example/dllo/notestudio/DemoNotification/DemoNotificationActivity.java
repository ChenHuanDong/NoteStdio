package com.example.dllo.notestudio.DemoNotification;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RemoteViews;
import android.widget.Toast;

import com.example.dllo.notestudio.MainActivity;
import com.example.dllo.notestudio.R;

/**
 * Created by dllo on 16/11/16.
 */

public class DemoNotificationActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btn1, btn2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.demo_notification_activity);
        btn1 = (Button) findViewById(R.id.demo_notification_btnmain1);
        btn2 = (Button) findViewById(R.id.demo_notification_btnmain2);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.demo_notification_btnmain1:
                show1();
                break;
            case R.id.demo_notification_btnmain2:
                show2();
                break;
        }


    }
    private void show1() {
        NotificationManager manger = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        Notification.Builder builder = new Notification.Builder(this);
        builder.setContentText("展示文字1"+"展示文字2"+"展示文字3");
        builder.setSmallIcon(R.mipmap.ic_launcher);
        Bitmap bitmap = BitmapFactory.decodeResource(getResources() , R.mipmap.ic_launcher);
        builder.setLargeIcon(bitmap);

        Notification notification = builder.build();
        notification.flags = Notification.FLAG_AUTO_CANCEL;
        manger.notify(1 , notification);

    }
    private void show2() {
        NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        Notification.Builder builder = new Notification.Builder(this);

        //PendingIntent   等待Intent
        Intent intent = new Intent(this , MainActivity.class);
        //四个参数 1context 2请求码 3 intent对象 4pendingintent策略
        PendingIntent pendingIntent = PendingIntent.getActivity(this , 100 , intent , PendingIntent.FLAG_CANCEL_CURRENT);
        //设置PendingInetent
        builder.setContentIntent(pendingIntent);

        //发现自定义布局
        RemoteViews remoteViews = new RemoteViews(getPackageName() , R.layout.demo_notifivation_mystyview);
        //设置自定义布局图片文字
        remoteViews.setImageViewResource(R.id.demo_notification_mysty_iv1 , R.mipmap.ic_launcher);
        remoteViews.setTextViewText(R.id.demo_notification_mysty_tv1 , "点击跳转到主活动(也可以传值)");
        remoteViews.setTextColor(R.id.demo_notification_mysty_tv1 , Color.BLACK);
        //设置按钮点击事件
        remoteViews.setOnClickPendingIntent(R.id.demo_notification_mysty_btn1 , pendingIntent);

        //绑定自定义Notification布局
        builder.setContent(remoteViews);

        builder.setSmallIcon(R.mipmap.ic_launcher);

        Notification notification = builder.build();
        notification.flags = Notification.FLAG_AUTO_CANCEL;

        manager.notify(1 ,notification);


    }
}
