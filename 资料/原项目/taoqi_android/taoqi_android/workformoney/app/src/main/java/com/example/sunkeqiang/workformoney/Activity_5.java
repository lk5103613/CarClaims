package com.example.sunkeqiang.workformoney;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

/**
 * Created by sunkeqiang on 15/8/16.
 */
public class Activity_5 extends Activity implements View.OnClickListener {
    private ImageView activity_5_btn_1;
    private TextView  activity_5_btn_2;
    private ImageView activity_5_btn_3;
    private ImageView activity_5_btn_4;
    private TextView activity_5_btn_5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_5);

        findview();
        init();



    }

    private void findview(){
        activity_5_btn_1 = (ImageView) findViewById(R.id.activity_5_btn_1);
        activity_5_btn_2 = (TextView) findViewById(R.id.activity_5_btn_2);
        activity_5_btn_3 = (ImageView) findViewById(R.id.activity_5_btn_3);
        activity_5_btn_4 = (ImageView) findViewById(R.id.activity_5_btn_4);
        activity_5_btn_5 = (TextView) findViewById(R.id.activity_5_btn_5);
    }

    private void init(){
        activity_5_btn_1.setOnClickListener(this);
        activity_5_btn_2.setOnClickListener(this);
        activity_5_btn_3.setOnClickListener(this);
        activity_5_btn_4.setOnClickListener(this);
        activity_5_btn_5.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
    switch (view.getId()){
        case R.id.activity_5_btn_1:
showToast("左上－返回");
            break;
        case R.id.activity_5_btn_2:
            showToast("右上－保存");
            break;
        case R.id.activity_5_btn_3:
            showToast("所在位置（>）");
            break;
        case R.id.activity_5_btn_4:
            showToast("联系人（>）");
            break;
        case R.id.activity_5_btn_5:
            showToast("底部－保存");
            break;
        default:

            break;
    }
    }

    public void showToast(String str){

        Toast.makeText(this, str, Toast.LENGTH_SHORT).show();

    }
}
