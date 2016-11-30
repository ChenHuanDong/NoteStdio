package com.example.dllo.notestudio.DemoAsyncTask;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.example.dllo.notestudio.R;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by dllo on 16/10/29.
 */

public class BitmapAsyTask extends AppCompatActivity {
    private ImageView mimageView;
    private Bitmap mbitmap;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.demo_bitmap);
        mimageView = (ImageView) findViewById(R.id.bitmap_demo_iv1);
        new MyBitmap().execute("https://ss0.bdstatic.com/94oJfD_bAAcT8t7mm9GUKT-xh_/timg?image&quality=100&size=b4000_4000&sec=1477640798&di=71dd0e5f959e908767c44272578781a4&src=http://img1.gamedog.cn/2011/11/28/14-11112Q10H1.jpg");
    }


    class MyBitmap extends AsyncTask<String, Void, Bitmap> {


        @Override
        protected Bitmap doInBackground(String... strings) {
            try {
                URL url = new URL(strings[0]);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                InputStream is = connection.getInputStream();
                mbitmap = BitmapFactory.decodeStream(is);
                is.close();
                connection.disconnect();

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            return mbitmap;
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            super.onPostExecute(bitmap);
            mimageView.setImageBitmap(bitmap);

        }
    }
}
