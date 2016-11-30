package com.example.dllo.notestudio.DemoAllImage;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.dllo.notestudio.DemoAllImage.fresco.DemoAllImageFresco;
import com.example.dllo.notestudio.DemoAllImage.glide.DemoAllImageGlide;
import com.example.dllo.notestudio.R;

/**
 * Created by dllo on 16/11/26.
 */

public class DemoAllImageActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btnfresco , btnglide , btnpicasso , btnuil ;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.demo_all_iamge_main);
        btnfresco = (Button) findViewById(R.id.demo_all_iamge_btn_fresco);
        btnglide = (Button) findViewById(R.id.demo_all_iamge_btn_glide);
        btnpicasso = (Button) findViewById(R.id.demo_all_iamge_btn_picasso);
        btnuil = (Button) findViewById(R.id.demo_all_iamge_btn_uil);
        btnfresco.setOnClickListener(this);
        btnglide.setOnClickListener(this);
        btnpicasso.setOnClickListener(this);
        btnuil.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.demo_all_iamge_btn_picasso:
                break;
            case R.id.demo_all_iamge_btn_uil:
                break;
            case R.id.demo_all_iamge_btn_glide:
                Intent intent = new Intent(this , DemoAllImageGlide.class);
                startActivity(intent);
                break;
            case R.id.demo_all_iamge_btn_fresco:
                Intent intent1 = new Intent(this , DemoAllImageFresco.class);
                startActivity(intent1);
                break;
        }


    }
}
