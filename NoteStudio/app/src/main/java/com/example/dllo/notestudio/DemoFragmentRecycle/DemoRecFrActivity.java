package com.example.dllo.notestudio.DemoFragmentRecycle;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.dllo.notestudio.BaseActivity;
import com.example.dllo.notestudio.R;
import com.google.gson.Gson;

/**
 * Created by dllo on 16/11/28.
 */

public class DemoRecFrActivity extends BaseActivity {
    private TabLayout tab ;
    private ViewPager viewPager ;
    private String url = "http://api.liwushuo.com/v2/channels/preset?gender=1&generation=2";
    private BeanFRVTab bean ;
    private DemoFRVAdapterMain myAdapter ;

    @Override
    public int setMyLayout() {
        return R.layout.demo_rec_fr;
    }

    @Override
    public void initMyView() {
        tab = (TabLayout) findViewById(R.id.frv__main_tab);
        viewPager = (ViewPager) findViewById(R.id.frv_main_vp);
        myAdapter = new DemoFRVAdapterMain(getSupportFragmentManager());
    }

    @Override
    public void initMyData() {
        viewPager.setAdapter(myAdapter);
        tab.setupWithViewPager(viewPager);
        //设置如果超出则对应滚动
        tab.setTabMode(TabLayout.MODE_SCROLLABLE);

        RequestQueue rq = Volley.newRequestQueue(this);
        StringRequest sr = new StringRequest(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Gson gson = new Gson();
                bean = gson.fromJson(response , BeanFRVTab.class);

                myAdapter.setBean(bean);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        rq.add(sr);


    }
}
