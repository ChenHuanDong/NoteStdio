package com.example.dllo.notestudio.DemoEventBus;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.example.dllo.notestudio.R;

/**
 * Created by dllo on 16/11/17.
 */

public class DemoeventbusActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.demo_event_bus);


        FragmentManager manger = getSupportFragmentManager();
        FragmentTransaction tra = manger.beginTransaction();
        tra.replace(R.id.demo_eventbus_fr1 , new DemoEventBusFr1());
        tra.replace(R.id.demo_eventbus_fr2 , new DemoEventBusFr2());
        tra.commit();

    }
}
