package com.example.dllo.notestudio.DemoAllImage.glide;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.graphics.Color;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.request.animation.ViewPropertyAnimation;
import com.example.dllo.notestudio.R;

import jp.wasabeef.glide.transformations.*;
import jp.wasabeef.glide.transformations.CropCircleTransformation;

/**
 * Created by dllo on 16/11/26.
 */

public class DemoAllImageGlideAdapter extends BaseAdapter {
    private String[] data;
    private Context context;

    public DemoAllImageGlideAdapter(Context context) {
        this.context = context;
    }

    public void setData(String[] data) {
        this.data = data;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return data.length;
    }

    @Override
    public Object getItem(int i) {
        return data[i];
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder = null;
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.demo_all_iamge_glide_ls_item, viewGroup, false);
            holder = new ViewHolder(view);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        //自定义获取网络图片方法
        initGlide(holder, i);
        return view;
    }
    //自定义获取网络图片方法方法
    private void initGlide(ViewHolder holder, int i) {
        ViewPropertyAnimation.Animator animationObject = new ViewPropertyAnimation.Animator() {
            @Override
            public void animate(View view) {
                //                                                          设置旋转
                //ObjectAnimator fadeAnim = ObjectAnimator.ofFloat(view , "rotation" ,0,180,0 ,180,0,180,0);
                //                                                          设置透明度
                //ObjectAnimator fadeAnim = ObjectAnimator.ofFloat(view , "alpha" ,0,1,0 ,1,0,1,0,1);
                //                                                          设置翻转
                //ObjectAnimator fadeAnim = ObjectAnimator.ofFloat(view , "rotationX" ,0,270,0 ,270,0,270,0);
                //ObjectAnimator fadeAnim = ObjectAnimator.ofFloat(view , "rotation" ,0,270,0 ,270,0,270,0);
                //                                                          设置平移
                ObjectAnimator fadeAnim = ObjectAnimator.ofFloat(view, "translationX", 0, 270, 0, 270, 0, 270, 0);
                //                                                          设置拉伸
                //ObjectAnimator fadeAnim = ObjectAnimator.ofFloat(view , "scaleX" ,0,3,1 ,0,3,2,1);
                fadeAnim.setDuration(3000);
                fadeAnim.start();
            }
        };

        Glide.with(context).load(data[i])
                //设置未加载出来时的图片
                .placeholder(R.mipmap.ic_launcher)
                //设置报错是出现的图片
                .error(R.mipmap.ic_launcher)
                //设置动画
                .animate(animationObject)
                //设置优先级
                .priority(Priority.HIGH)
                //缩略图???
                .thumbnail(0.5f)
                //画圆形图片的方法 只有Glide能用  要用到依赖
                .bitmapTransform(new CropCircleTransformation(context))
                .into(holder.iv);

    }


    class ViewHolder {
        private ImageView iv;

        public ViewHolder(View view) {
            iv = (ImageView) view.findViewById(R.id.demo_all_iamge_iv_glide);
        }
    }

}
