package com.example.dllo.notestudio.DemoTabLayout;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.dllo.notestudio.R;

/**
 * Created by dllo on 16/10/29.
 */

public class DemoTabLayoutfragment1 extends Fragment{
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.demo_activity_tablelayout_fragment1,container,false);
        return view ;
    }
}
