package com.example.dllo.notestudio.DemoFragmentRecycle;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dllo.notestudio.BaseFragment;
import com.example.dllo.notestudio.R;
import com.squareup.picasso.Picasso;

/**
 * Created by dllo on 16/11/29.
 */

public class DemoFRVCommAdapter extends BaseAdapter {
    private BeanFRVComm bean ;
    private Context context ;

    public DemoFRVCommAdapter(Context context) {
        this.context = context;
    }



    public  void setBean(BeanFRVComm bean) {
        this.bean = bean;
        notifyDataSetChanged();
    }

    @Override  //这里必须写成标准形式
    public int getCount() {
        return bean != null ?  bean.getData().getItems().size() : 0;
    }

    @Override
    public Object getItem(int i) {
        return bean.getData().getItems().get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder = null;

        if (view == null){
            view = LayoutInflater.from(context).inflate(R.layout.demo_frv_comm_lsitem,viewGroup,false);
            holder = new ViewHolder(view);
            view.setTag(holder);
        }else {
            holder = (ViewHolder) view.getTag();
        }
        holder.tv.setText(bean.getData().getItems().get(i).getTitle());
        Picasso.with(context).load(bean.getData().getItems().get(i).getCover_image_url()).into(holder.iv);
        return view;
    }

    class ViewHolder{
        private ImageView iv ;
        private TextView tv ;
        public ViewHolder(View view) {
            iv = (ImageView) view.findViewById(R.id.demo_frv_comm_iv);
            tv = (TextView) view.findViewById(R.id.demo_frv_comm_tv);
        }
    }


}
