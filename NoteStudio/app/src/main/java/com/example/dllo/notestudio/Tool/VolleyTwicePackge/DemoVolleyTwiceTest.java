package com.example.dllo.notestudio.Tool.VolleyTwicePackge;

import android.util.Log;
import android.widget.Toast;

import com.android.volley.VolleyError;
import com.example.dllo.notestudio.BaseActivity;
import com.example.dllo.notestudio.DemoFragmentRecycle.BeanFRVTab;
import com.example.dllo.notestudio.R;

/**
 * Created by dllo on 16/11/29.
 */

public class DemoVolleyTwiceTest extends BaseActivity {

    @Override
    public int setMyLayout() {
        return R.layout.demo_volley_twice;
    }

    @Override
    public void initMyView() {
        NetHelper.MyRequest("http://api.liwushuo.com/v2/channels/preset?gender=1&generation=2", BeanFRVTab.class, new NetListener<BeanFRVTab>() {
            @Override
            public void successListener(BeanFRVTab response) {
                Log.d("DemoVolleyTwiceTest"+"---", response.getData().getCandidates().get(0).getName());
            }

            @Override
            public void errorListener(VolleyError error) {
                Toast.makeText(DemoVolleyTwiceTest.this, "没网", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void initMyData() {

    }
}
