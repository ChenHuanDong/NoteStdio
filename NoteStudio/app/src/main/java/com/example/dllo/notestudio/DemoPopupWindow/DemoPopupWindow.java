package com.example.dllo.notestudio.DemoPopupWindow;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.Toast;

import com.example.dllo.notestudio.R;

/**
 * Created by dllo on 16/11/12.
 */

public class DemoPopupWindow extends AppCompatActivity implements View.OnClickListener {
    private Button btn1 ;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.demo_popupwindow);

        btn1 = (Button) findViewById(R.id.pop_btn1);
        btn1.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        PopupWindow popupWindow = new PopupWindow(this);
        popupWindow.setWidth(ViewGroup.LayoutParams.WRAP_CONTENT);
        popupWindow.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
        View view1 = getLayoutInflater().inflate(R.layout.demo_popupwindowitems,null);
        popupWindow.setContentView(view1);

        Button button = (Button) view1.findViewById(R.id.demo_pop_btnshow);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(DemoPopupWindow.this, "点击", Toast.LENGTH_SHORT).show();
            }
        });

        popupWindow.setOutsideTouchable(true);
        //这句必须写在点击事件里面!!!不然会崩
        popupWindow.showAsDropDown(btn1);

    }
}
