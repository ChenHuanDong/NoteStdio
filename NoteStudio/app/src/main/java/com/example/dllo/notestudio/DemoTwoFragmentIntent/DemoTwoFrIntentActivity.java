package com.example.dllo.notestudio.DemoTwoFragmentIntent;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;

import com.example.dllo.notestudio.R;

/**
 * Created by dllo on 16/11/14.
 */

public class DemoTwoFrIntentActivity extends AppCompatActivity implements DemoFrInt {
    private FragmentManager fragmentManager ;
    private RecFragment recFragment;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.demo_twofrintent_activity);
        fragmentManager = getSupportFragmentManager();

        FragmentTransaction tra = fragmentManager.beginTransaction();

        SendFragment sendFragment = new SendFragment();
        //和点击事件的接口回调的this一样
        sendFragment.isetreturn(this);
        tra.add(R.id.demo_twofr_fr1 , sendFragment , "SendFragment" );

        recFragment = new RecFragment();
        tra.add(R.id.demo_twofr_fr2 , recFragment, "RecFragment");

        tra.commit();

    }

    @Override
    public void set(String s) {
        recFragment.setMyCount(s);

    }
}
