package com.example.dllo.notestudio.DemoCropButtonShape;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;

import com.example.dllo.notestudio.R;

/**
 * Created by dllo on 16/11/14.
 */

public class DemoRoundImageViewClass extends ImageView {
    //
    private Boolean isRound = false ;

    public DemoRoundImageViewClass(Context context) {
        super(context);
    }

    public DemoRoundImageViewClass(Context context, AttributeSet attrs) {
        super(context, attrs);
        //代表获取自定义组件里面的信息   R.styleable是自己工程的包下
        TypedArray typedArray = context.obtainStyledAttributes(attrs , R.styleable.DemoRoundImageViewClass);
        //
        isRound = typedArray.getBoolean(R.styleable.DemoRoundImageViewClass_isRound , false);

    }

    @Override
    protected void onDraw(Canvas canvas) {

        if (!isRound){
            Drawable drawable =getDrawable();
            if (drawable != null){
                Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();
                Bitmap bitmapnew = getCircleBitmao(bitmap);
                Paint paint  = new Paint();
                Rect rect = new Rect(0,0,bitmap.getWidth(),bitmap.getHeight());
                canvas.drawBitmap(bitmapnew,rect,rect,paint);

            }
        }else {
            super.onDraw(canvas);
        }


    }

    //自定义的方法
    public Bitmap getCircleBitmao (Bitmap bitmap){
        //第三个参数是  图片质量
        Bitmap outbitmap = Bitmap.createBitmap(bitmap.getWidth(),
                bitmap.getHeight(),Bitmap.Config.ARGB_8888);

        Canvas canvas = new Canvas(outbitmap);
        Paint paint = new Paint();
        paint.setAntiAlias(true);

        int radius = bitmap.getWidth() > bitmap.getHeight()? bitmap.getHeight() :bitmap.getWidth() ;
        canvas.drawCircle(outbitmap.getWidth() / 2, outbitmap.getHeight() / 2, radius / 2, paint);

        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));

        Rect rect = new Rect(0,0,bitmap.getWidth(),bitmap.getHeight());
        canvas.drawBitmap(bitmap , rect ,rect , paint);


        return  outbitmap ;
    }


}
