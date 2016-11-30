package com.example.dllo.notestudio.DemoFragmentRecycle;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.dllo.notestudio.BaseFragment;
import com.example.dllo.notestudio.R;
import com.google.gson.Gson;

/**
 * Created by dllo on 16/11/29.
 */

public class DemoFRVCommendFragment extends BaseFragment {
    //!!!!!!
    private Context mContext;
    private String newUrl;
    private BeanFRVComm bean ;
    private ListView ls ;
    private DemoFRVCommAdapter myAdapter ;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;
    }

    @Override
    public int setMyLayout() {
        return R.layout.demo_frv_comm;
    }

    @Override
    protected void initMyView(View view) {
        ls = (ListView) view.findViewById(R.id.demo_frv_comm_ls);
        myAdapter = new DemoFRVCommAdapter(mContext);
        ls.setAdapter(myAdapter);
    }

    @Override
    protected void initMyData() {
        Bundle bundle = getArguments();
        if (bundle!=null){
            String data = bundle.getString("data");
            newUrl = "http://api.liwushuo.com/v2/channels/"+data+
                    "/items_v2?ad=2&gender=1&generation=2&limit=20&offset=0";
        }
        RequestQueue rq = Volley.newRequestQueue(mContext);
        StringRequest sr = new StringRequest(newUrl, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Gson gson = new Gson();
                bean = gson.fromJson(response , BeanFRVComm.class);

                myAdapter.setBean(bean);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        rq.add(sr);

    }

    public static DemoFRVCommendFragment newInstance(int position) {

        Bundle args = new Bundle();
        String data = DemoFRVAdapterMain.getData(position)+"";
        args.putString("data" , data);
        DemoFRVCommendFragment fragment = new DemoFRVCommendFragment();
        fragment.setArguments(args);
        return fragment;
    }


}
