package com.example.dllo.notestudio.DemoDialog;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.dllo.notestudio.R;

/**
 * Created by dllo on 16/11/14.
 */

public class DemoDialogActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btn1 ,btn2;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.demo_dialog_activity);

        btn1 = (Button) findViewById(R.id.demo_dialog_btn1);
        btn1.setOnClickListener(this);
        btn2 = (Button) findViewById(R.id.demo_dialog_btn2);
        btn2.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.demo_dialog_btn1:
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("标题");
                builder.setMessage("setMessage方法设置信息");
                builder.setPositiveButton("积极(可点)", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(DemoDialogActivity.this, "setPo方法设置积极响应的按钮", Toast.LENGTH_SHORT).show();
                    }
                });
                builder.setNeutralButton("忽略(可点)", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(DemoDialogActivity.this, "setNEu方法设置中立响应按钮", Toast.LENGTH_SHORT).show();
                    }
                });
                builder.setNegativeButton("取消(可点)", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(DemoDialogActivity.this, "setNEu方法设置消极响应按钮", Toast.LENGTH_SHORT).show();
                    }
                });
                //设置是否能点击dialog外面取消
                builder.setCancelable(false);
                builder.show();
                break;

            case R.id.demo_dialog_btn2:
                AlertDialog.Builder  builder1 = new AlertDialog.Builder(this);
                View view1 = getLayoutInflater().inflate(R.layout.demo_popupwindowitems,null);

                Button button = (Button) view1.findViewById(R.id.demo_pop_btnshow);
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(DemoDialogActivity.this, "123", Toast.LENGTH_SHORT).show();
                    }
                });


                //dialog绑定自己的
                builder1.setView(view1);
                builder1.show();
                break;



        }
    }
}
