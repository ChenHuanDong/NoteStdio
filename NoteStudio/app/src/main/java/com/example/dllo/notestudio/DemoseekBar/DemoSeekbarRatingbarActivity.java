package com.example.dllo.notestudio.DemoseekBar;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dllo.notestudio.R;

/**
 * Created by dllo on 16/11/4.
 */

public class DemoSeekbarRatingbarActivity extends AppCompatActivity {
    private TextView tv1  , tv2;
    private SeekBar mseekBar ;
    private ImageView iv1 ;
    private RatingBar ratingBar ;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.demo_seekbarratingbar);
        iv1 = (ImageView) findViewById(R.id.demo_seekiv1);
        mseekBar = (SeekBar) findViewById(R.id.demo_seek);
        tv1 = (TextView) findViewById(R.id.demo_seektv_start);
        tv2 = (TextView) findViewById(R.id.demo_seektv_end);

        mseekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override //过程中的操作
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                tv1.setText("开始位置:"+i);
                //设置透明度
                iv1.setImageAlpha(i);
            }

            @Override // 开始的设置
            public void onStartTrackingTouch(SeekBar seekBar) {
                Toast.makeText(DemoSeekbarRatingbarActivity.this, "开始滑动", Toast.LENGTH_SHORT).show();
            }

            @Override // 结尾的设置
            public void onStopTrackingTouch(SeekBar seekBar) {
                tv2.setText("结尾位置:"+mseekBar.getProgress() );

            }
        });


        ratingBar = (RatingBar) findViewById(R.id.demo_seekrat);
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                tv2.setText(v+"");
            }
        });

    }
}
