package com.example.dllo.notestudio.DemoLeftRightImageChange;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.util.DisplayMetrics;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.dllo.notestudio.BaseActivity;
import com.example.dllo.notestudio.R;

/**
 * Created by dllo on 16/11/28.
 */

public class DemoLeftRightImageChagneActivity extends BaseActivity implements GestureDetector.OnGestureListener {
    //动作监听器
    private GestureDetector detector;
    private ImageView iv;
    private Matrix matrix;
    private Bitmap bitmap;
    float currentScale = 1;
    private int width;
    private int height;
    private float widthParent;
    private float heightParent;


    @Override
    public int setMyLayout() {
        return R.layout.demo_left_right_image_change;
    }

    @Override
    public void initMyView() {
        //获取屏幕宽高
        WindowManager manager = this.getWindowManager();
        DisplayMetrics outMetrics = new DisplayMetrics();
        manager.getDefaultDisplay().getMetrics(outMetrics);
        widthParent = outMetrics.widthPixels;
        heightParent = outMetrics.heightPixels;

        //初始化动作监听器   自己手打接口
        detector = new GestureDetector(this, this);
        iv = (ImageView) findViewById(R.id.demo_left_right_iv);
        matrix = new Matrix();
        bitmap = BitmapFactory.decodeResource(this.getResources(), R.mipmap.ic_launcher);
        //获取图片宽高
        width = bitmap.getWidth();
        height = bitmap.getHeight();
        //设置初始图片
        iv.setImageBitmap(bitmap);
    }

    @Override
    public void initMyData() {
    }


    //手机点击触屏执行方法
    //参数event  是手机屏幕触摸事件封装类的对象
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        //将Activity 的触摸事件交给GestureDetector
        return detector.onTouchEvent(event);
    }


    @Override //用户轻触屏幕 开始
    public boolean onDown(MotionEvent motionEvent) {
        return false;
    }

    @Override //用户轻触屏幕  未松开或在拖动
    public void onShowPress(MotionEvent motionEvent) {

    }

    @Override //用户松开屏幕之后
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        return false;
    }

    @Override // 用户按下屏幕并且拖动
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
        return false;
    }

    @Override // 用户长按屏幕
    public void onLongPress(MotionEvent motionEvent) {

    }

    //四个参数  1 手势起点的移动时间  2 当前手势的移动事件  3 每秒X轴方向移动的像素  4 Y方向像素
    @Override
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
        //左滑 缩小
        if (motionEvent.getX() - motionEvent1.getX() > 40 && Math.abs(v) > 0) {
            Toast.makeText(this, "左滑缩小", Toast.LENGTH_SHORT).show();
            currentScale = currentScale - 0.1f;
            //缩小 重新开始
            currentScale = currentScale > 0.01f ? currentScale : 1f;

        }
        //右滑 放大
        if (motionEvent1.getX() - motionEvent.getX() > 40 && Math.abs(v) > 0) {
            Toast.makeText(this, "右滑放大", Toast.LENGTH_SHORT).show();
            currentScale = currentScale + 0.1f;
            //放大到5倍 则变回原形
            currentScale = currentScale < 5f ? currentScale : 1f;
        }
        //上滑缩小
        if (motionEvent.getY() - motionEvent1.getY() > 40 && Math.abs(v1) > 0) {
            Toast.makeText(this, "上滑缩小", Toast.LENGTH_SHORT).show();
            currentScale = currentScale - 0.5f;
            currentScale = currentScale > 0.01f ? currentScale : 1f;
        }
        //下拉放大
        if (motionEvent1.getY() - motionEvent.getY() > 40 && Math.abs(v1) > 0){
            Toast.makeText(this, "下拉放大", Toast.LENGTH_SHORT).show();
            currentScale = currentScale + 0.5f ;
            currentScale = currentScale < 5f ? currentScale : 1f ;
        }


        //重置
        matrix.reset();
        //设置缩放
        matrix.setScale(currentScale, currentScale);

        Bitmap bitmapnew = Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
        float a = bitmapnew.getWidth();
        float b = bitmapnew.getHeight();
        //如果超出屏幕则变回原型
        if (widthParent <= a || heightParent <= b) {
            currentScale = 1;
        }
        //显示新的图片
        iv.setImageBitmap(bitmapnew);

        return true;
    }
}
