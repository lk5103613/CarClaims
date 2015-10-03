package com.example.sunkeqiang.workformoney;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by sunkeqiang on 15/8/16.
 */
public class Activity_2 extends Activity implements View.OnClickListener{

    private ImageView activity_2_btn_1;
    private TextView activity_2_btn_2;
    private TextView activity_2_btn_3;
    private TextView activity_2_btn_4;
    private LinearLayout activity_2_btn_5;
    private ImageView activity_2_btn_6;
    private ImageView activity_2_btn_7;
    private TextView activity_2_btn_8;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        findview();
        init();
    }


    private void findview(){
        activity_2_btn_1 = (ImageView) findViewById(R.id.activity_2_btn_1);
        activity_2_btn_2 = (TextView) findViewById(R.id.activity_2_btn_2);
        activity_2_btn_3 = (TextView) findViewById(R.id.activity_2_btn_3);
        activity_2_btn_4 = (TextView) findViewById(R.id.activity_2_btn_4);
        activity_2_btn_5 = (LinearLayout) findViewById(R.id.activity_2_btn_5);
        activity_2_btn_6 = (ImageView) findViewById(R.id.activity_2_btn_6);
        activity_2_btn_7 = (ImageView) findViewById(R.id.activity_2_btn_7);
        activity_2_btn_8 = (TextView) findViewById(R.id.activity_2_btn_8);


    }

    private void init(){
        activity_2_btn_1.setOnClickListener(this);
        activity_2_btn_2.setOnClickListener(this);
        activity_2_btn_3.setOnClickListener(this);
        activity_2_btn_4.setOnClickListener(this);
        activity_2_btn_5.setOnClickListener(this);
        activity_2_btn_6.setOnClickListener(this);
        activity_2_btn_7.setOnClickListener(this);
        activity_2_btn_8.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.activity_2_btn_1:
                showToast("左上－返回");
                break;
            case R.id.activity_2_btn_2:
                showToast("右上－保存");
                break;
            case R.id.activity_2_btn_3:
                showToast("先生");
                break;
            case R.id.activity_2_btn_4:
                showToast("女士");
                break;
            case R.id.activity_2_btn_5:
                showToast("沪－向下");
                break;
            case R.id.activity_2_btn_6:
                showToast("沪－向右");
                break;
            case R.id.activity_2_btn_7:
                showToast("保险公司");
                break;
            case R.id.activity_2_btn_8:
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
