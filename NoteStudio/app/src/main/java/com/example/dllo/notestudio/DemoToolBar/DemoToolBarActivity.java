package com.example.dllo.notestudio.DemoToolBar;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;

import com.example.dllo.notestudio.R;

import java.util.ArrayList;

/**
 * Created by dllo on 16/11/5.
 */

public class DemoToolBarActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private ArrayList<String> data;
    private ToolbarAdapter toolbarAdapter;
    private ListView listView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.demo_toolbar);

        data = new ArrayList<>();
        listView = (ListView) findViewById(R.id.toobar_ls);
        toolbarAdapter = new ToolbarAdapter(this);

        for (int i = 0; i < 50; i++) {
            data.add("" + i);
        }

        toolbarAdapter.setData(data);
        listView.setAdapter(toolbarAdapter);

        toolbar = (Toolbar) findViewById(R.id.demo_toobar_tb);
        toolbar.setLogo(R.mipmap.ic_launcher);
        toolbar.setTitle("我是标题");
        //设置menu   自己设置menu文件
        setSupportActionBar(toolbar);

    }

    //绑定menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }
    //menu选择

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.toobaritem1:
                Toast.makeText(this, "点击menu1", Toast.LENGTH_SHORT).show();
                break;
            case R.id.toobaritem2:
                Toast.makeText(this, "点击menu2", Toast.LENGTH_SHORT).show();
                break;
            case R.id.toobaritem3:
                Toast.makeText(this, "点击menu3", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
