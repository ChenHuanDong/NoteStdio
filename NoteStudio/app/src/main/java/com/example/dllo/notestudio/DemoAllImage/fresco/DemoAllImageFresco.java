package com.example.dllo.notestudio.DemoAllImage.fresco;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.dllo.notestudio.DemoAllImage.ConstantsAllImage;
import com.example.dllo.notestudio.R;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;

/**
 * Created by dllo on 16/11/26.
 */

public class DemoAllImageFresco extends AppCompatActivity {
    private ListView ls ;
    private String[] imageUrl;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //这个要写在绑定布局之前
        Fresco.initialize(this);

        setContentView(R.layout.demo_all_iamge_glide);

        ls = (ListView) findViewById(R.id.demo_all_iamge_glide_ls);
        imageUrl = ConstantsAllImage.images;
        ls.setAdapter(new FrescoAdapter());

    }
    class FrescoAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return imageUrl.length;
        }

        @Override
        public Object getItem(int i) {
            return imageUrl[i];
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            ViewHolder holder = null;
            if (view == null){
                view = getLayoutInflater().inflate(R.layout.demo_all_iamge_fresco_item,viewGroup,false);
                holder = new ViewHolder(view);
                view.setTag(holder);
            }else {
                holder = (ViewHolder) view.getTag();
            }
            Uri uri = Uri.parse(imageUrl[i]);
            initDraweeView(holder.simpleDraweeView , uri);
            return view;
        }

        class ViewHolder  {
            private SimpleDraweeView simpleDraweeView;
            public ViewHolder(View view) {
                simpleDraweeView = (SimpleDraweeView) DemoAllImageFresco.this.findViewById(R.id.demo_all_iamge_fresco_draw);
            }
        }




    }

    private void initDraweeView(SimpleDraweeView simpleDraweeView, Uri uri) {
        DraweeController draweeController = Fresco.newDraweeControllerBuilder()
                .setUri(uri).setAutoPlayAnimations(true)
                .build();

        simpleDraweeView.setController(draweeController);


    }

}
