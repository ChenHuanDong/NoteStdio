package com.example.dllo.notestudio.SP;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.dllo.notestudio.R;

/**
 * Created by dllo on 16/11/12.
 */

public class SPTwoDemo extends AppCompatActivity {
    private TextView tv1 ;
    private Button btn1 ;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.demo_sp2);

        tv1 = (TextView) findViewById(R.id.SP_tv1);
        btn1 = (Button) findViewById(R.id.SP_btn3);

        SharedPreferences sp = getSharedPreferences("menu" , MODE_PRIVATE);
        String tete = sp.getString("son" , "没获取到" );
        tv1.setText(tete);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }
}
