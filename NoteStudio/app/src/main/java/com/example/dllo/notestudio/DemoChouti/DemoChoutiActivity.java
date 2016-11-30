package com.example.dllo.notestudio.DemoChouti;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;

import com.example.dllo.notestudio.R;

/**
 * Created by dllo on 16/11/26.
 */

public class DemoChoutiActivity extends AppCompatActivity {
    private Button btn;
    private DrawerLayout drawerLayout;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.demo_chouti);
        drawerLayout = (DrawerLayout) findViewById(R.id.demo_chouti_draw);
        btn = (Button) findViewById(R.id.demo_chouti_btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED);
                drawerLayout.openDrawer(Gravity.LEFT);
            }
        });
    }
}
