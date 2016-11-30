package com.example.dllo.notestudio.DemoPopupMenu;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.PopupMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dllo.notestudio.R;

/**
 * Created by dllo on 16/11/5.
 */

public class DemoPopupMenu extends AppCompatActivity {
    private TextView tv1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.demo_popupmenu);

        tv1 = (TextView) findViewById(R.id.tv111);
        tv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PopupMenu popupMenu = new PopupMenu(DemoPopupMenu.this, view );

                popupMenu.getMenuInflater().inflate(R.menu.menu , popupMenu.getMenu());

                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        Toast.makeText(DemoPopupMenu.this, "你选择了"+item.getTitle(), Toast.LENGTH_SHORT).show();

                        return true;
                    }
                });
                    popupMenu.show();
            }
        });

    }
}
