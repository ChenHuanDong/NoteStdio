package com.example.dllo.notestudio.DemoEventBus;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.dllo.notestudio.R;

import org.greenrobot.eventbus.EventBus;

/**
 * Created by dllo on 16/11/17.
 */

public class DemoEventBusFr1 extends Fragment {
    private EditText et1 ;
    private Button btn1 ;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.demo_event_bus_fr1,container,false);
        return view ;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        et1 = (EditText) view.findViewById(R.id.demo_eve_et1);
        btn1 = (Button) view.findViewById(R.id.demo_eve_btn1);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str = et1.getText().toString();
                //使用EventBus
                EventBus.getDefault().post(new DemoEventBean(str));

            }
        });


    }
}
