package com.example.dllo.notestudio.DemoGson;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.dllo.notestudio.R;
import com.google.gson.Gson;

/**
 * Created by dllo on 16/11/5.
 */

public class DemoGsonActivity extends AppCompatActivity {
    private Handler handler;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.demo_activity_gson);
        recyclerView = (RecyclerView) findViewById(R.id.demo_gson_rv);
        //
        final DemoGsonAdapter demoGsonAdapter = new DemoGsonAdapter(this);

        recyclerView.setAdapter(demoGsonAdapter);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        handler = new Handler(new Handler.Callback() {
            @Override
            public boolean handleMessage(Message message) {
                if (message.what == 200){
                    String result = (String) message.obj;

                    DemoGsonBean demoGsonBean = new DemoGsonBean();
                    //Gson
                    Gson gson = new Gson() ;
                    demoGsonBean = gson.fromJson(result , DemoGsonBean.class);

                    demoGsonAdapter.setDemoGsonBean(demoGsonBean);


                }


                return false;
            }
        });
        //开启线程
        new DemoGsonThread(handler).start();
    }
}
