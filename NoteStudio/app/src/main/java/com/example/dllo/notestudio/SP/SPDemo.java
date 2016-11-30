package com.example.dllo.notestudio.SP;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.dllo.notestudio.R;

/**
 * Created by dllo on 16/11/12.
 */

public class SPDemo extends AppCompatActivity {
    private EditText et1;
    private Button btn1, btn2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.demo_sp1);

        et1 = (EditText) findViewById(R.id.SP_et1);
        btn1 = (Button) findViewById(R.id.SP_btn1);
        btn2 = (Button) findViewById(R.id.SP_btn2);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = getSharedPreferences("menu", MODE_PRIVATE).edit();
                editor.putString("son", et1.getText().toString());
                editor.commit();
                Intent intent = new Intent(SPDemo.this, SPTwoDemo.class);
                startActivity(intent);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = getSharedPreferences("menu", MODE_PRIVATE).edit();
                editor.clear();
                editor.commit();
                Intent intent = new Intent(SPDemo.this, SPTwoDemo.class);
                startActivity(intent);
            }
        });

    }
}
