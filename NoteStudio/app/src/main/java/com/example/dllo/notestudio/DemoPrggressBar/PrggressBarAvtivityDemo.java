package com.example.dllo.notestudio.DemoPrggressBar;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dllo.notestudio.R;

/**
 * Created by dllo on 16/10/29.
 */

public class PrggressBarAvtivityDemo extends AppCompatActivity {
    private ProgressBar mprogressBar;
    private TextView tv1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.demo_progressbar1);
        mprogressBar = (ProgressBar) findViewById(R.id.progressbarbar);
        tv1 = (TextView) findViewById(R.id.probartv1);
new Myprogressbar().execute(100);
    }

    class Myprogressbar extends AsyncTask<Integer, Integer, Boolean> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            mprogressBar.setProgress(0);
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
            mprogressBar.setProgress(values[0]);
            tv1.setText("已下载" + values[0] + "%");

        }

        @Override
        protected void onPostExecute(Boolean aBoolean) {
            super.onPostExecute(aBoolean);
            mprogressBar.setVisibility(View.GONE);
            tv1.setVisibility(View.GONE);
            Toast.makeText(PrggressBarAvtivityDemo.this, "下载完成", Toast.LENGTH_SHORT).show();
        }
    }

}
