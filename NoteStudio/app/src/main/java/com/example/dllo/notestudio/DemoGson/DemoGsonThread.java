package com.example.dllo.notestudio.DemoGson;

import android.os.Handler;
import android.os.Message;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by dllo on 16/11/5.
 */

public class DemoGsonThread extends Thread {

    private Handler mHandler;

    public DemoGsonThread(Handler mHandler) {
        this.mHandler = mHandler;
    }

    @Override
    public void run() {
        super.run();
        String uu = "http://api.liwushuo.com/v2/items?gender=1&generation=4&limit=50&oddset=0";
        try {
            URL url = new URL(uu);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                InputStream is = connection.getInputStream();
                BufferedReader bf = new BufferedReader(new InputStreamReader(is));
                String line = "";
                String result = "";
                while ((line = bf.readLine()) != null) {
                    result += line;
                }
                bf.close();
                is.close();
                connection.disconnect();

                Message message = new Message();
                message.what = 200 ;
                message.obj = result ;
                mHandler.sendMessage(message);

            }


        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
