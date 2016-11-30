package com.example.dllo.notestudio.DemoTwoFragmentIntent;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.dllo.notestudio.R;

/**
 * Created by dllo on 16/11/14.
 */

public class SendFragment extends Fragment {
    private Button btn1 ;
    private static  DemoFrInt demoFrInt ;
    private EditText et1;

    public SendFragment() {
    }
    //自定义方法  创建接口
    public static void isetreturn (DemoFrInt demoFrInt11){
        demoFrInt = demoFrInt11 ;
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.demo_sendfr_a , container,false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        btn1 = (Button) view.findViewById(R.id.demo_twofr_btnsend);
        et1 = (EditText) view.findViewById(R.id.demo_twofr_etsend);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s = et1.getText().toString();
                demoFrInt.set(s);
            }
        });

    }
}
