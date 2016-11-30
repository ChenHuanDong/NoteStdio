package com.example.dllo.notestudio.DemoVolleyq;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.dllo.notestudio.R;
import com.google.gson.Gson;

import java.util.ArrayList;

/**
 * Created by dllo on 16/11/14.
 */

public class DemoVolleyActivity extends AppCompatActivity {
    private TextView tv1;
    private DemoVolleyBean data;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.demo_volley_activity);
        tv1 = (TextView) findViewById(R.id.demo_volley_tv1);

        String url = "http://api.liwushuo.com/v2/ranks_v3/ranks/6?limit=20&offset=0";

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        //三参   第一个网址  第二个new L响应执行的逻辑  第三个new E网络失败的逻辑
        StringRequest stringRequestc = new StringRequest(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                //必须要Gson
                Gson gson = new Gson();
                data = gson.fromJson(response , DemoVolleyBean.class);

                tv1.setText(data.getData().getItems().get(10).getName());


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        //最后加的
        requestQueue.add(stringRequestc);
    }
}
