package com.example.dllo.notestudio;

/**
 * Created by dllo on 16/11/28.
 */
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

public abstract class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(setMyLayout());
        initMyView();
        initMyData();
    }
    public abstract int setMyLayout() ;
    public abstract void initMyView();
    public abstract void initMyData();
}
