package com.example.dllo.notestudio.DemoAllImage.glide;

import android.animation.ObjectAnimator;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.animation.ViewPropertyAnimation;
import com.example.dllo.notestudio.DemoAllImage.ConstantsAllImage;
import com.example.dllo.notestudio.R;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

/**
 * Created by dllo on 16/11/26.
 */

public class DemoAllImageGlide extends AppCompatActivity {
    private String[] data;
    private ListView ls;
    private DemoAllImageGlideAdapter myAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.demo_all_iamge_glide);
        ls = (ListView) findViewById(R.id.demo_all_iamge_glide_ls);
        data = ConstantsAllImage.imagesGif;
        myAdapter = new DemoAllImageGlideAdapter(this);
        myAdapter.setData(data);
        ls.setAdapter(myAdapter);

    }
}
