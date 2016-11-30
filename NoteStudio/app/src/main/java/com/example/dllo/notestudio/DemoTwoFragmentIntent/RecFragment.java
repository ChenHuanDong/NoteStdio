package com.example.dllo.notestudio.DemoTwoFragmentIntent;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.dllo.notestudio.R;

/**
 * Created by dllo on 16/11/14.
 */

public class RecFragment extends Fragment {
    private TextView tv1 ;

    public RecFragment() {
    }
    //自定义添加方法   接收接口数据
    public  void  setMyCount (String s){
        tv1.setText(s);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.demo_twofr_recfr_b,container,false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tv1 = (TextView) view.findViewById(R.id.demo_twofr_rec_tv);

    }




}
