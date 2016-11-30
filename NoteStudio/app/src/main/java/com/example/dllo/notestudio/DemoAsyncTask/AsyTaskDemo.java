package com.example.dllo.notestudio.DemoAsyncTask;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.example.dllo.notestudio.R;

/**
 * Created by dllo on 16/10/29.
 */

public class AsyTaskDemo extends AppCompatActivity {
    private ProgressDialog mprogressDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.demo_asytask);
        mprogressDialog = new ProgressDialog(this);
        new MyAsyTask().execute(100);

    }


    class MyAsyTask extends AsyncTask<Integer, Integer, Boolean> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            mprogressDialog.show();
            //设置点击外部不取消dialog
            mprogressDialog.setCanceledOnTouchOutside(false);
        }

        @Override
        protected Boolean doInBackground(Integer... integers) {
            int loading = 0;
            while (loading < integers[0]) {
                publishProgress(loading);
                loading++;
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }

            return true;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            mprogressDialog.setMessage(values[0] + "%");
        }

        @Override
        protected void onPostExecute(Boolean aBoolean) {
            super.onPostExecute(aBoolean);
            if (aBoolean) {
                mprogressDialog.dismiss();
                Toast.makeText(AsyTaskDemo.this, "下载完成", Toast.LENGTH_SHORT).show();
            }
        }
    }


}
