package com.example.sunkeqiang.workformoney;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

/**
 * Created by sunkeqiang on 15/8/16.
 */
public class Activity_1 extends Activity implements View.OnClickListener{

    private LinearLayout activity_btn_1;

    private LinearLayout activity_btn_2;

    private LinearLayout activity_btn_3;

    private LinearLayout activity_btn_4;
    private LinearLayout activity_btn_5;

    private LinearLayout activity_btn_6;

    private RelativeLayout activity_btn_7;
    private LinearLayout activity_btn_8;
    private LinearLayout activity_btn_9;
    private LinearLayout activity_btn_10;
    private LinearLayout activity_btn_11;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_1);

        findview();

        init();
    }

    private void findview(){
        activity_btn_1 = (LinearLayout) findViewById(R.id.activity_btn_1);
        activity_btn_2 = (LinearLayout) findViewById(R.id.activity_btn_2);
        activity_btn_3 = (LinearLayout) findViewById(R.id.activity_btn_3);
        activity_btn_4 = (LinearLayout) findViewById(R.id.activity_btn_4);
        activity_btn_5 = (LinearLayout) findViewById(R.id.activity_btn_5);
        activity_btn_6 = (LinearLayout) findViewById(R.id.activity_btn_6);
        activity_btn_7 = (RelativeLayout) findViewById(R.id.activity_btn_7);
        activity_btn_8 = (LinearLayout) findViewById(R.id.activity_btn_8);
        activity_btn_9 = (LinearLayout) findViewById(R.id.activity_btn_9);
        activity_btn_10 = (LinearLayout) findViewById(R.id.activity_btn_10);
        activity_btn_11 = (LinearLayout) findViewById(R.id.activity_btn_11);

    }

    private void init(){
        activity_btn_1.setOnClickListener(this);
        activity_btn_2.setOnClickListener(this);
        activity_btn_3.setOnClickListener(this);
        activity_btn_4.setOnClickListener(this);
        activity_btn_5.setOnClickListener(this);
        activity_btn_6.setOnClickListener(this);
        activity_btn_7.setOnClickListener(this);
       activity_btn_8.setOnClickListener(this);
        activity_btn_9.setOnClickListener(this);
        activity_btn_10.setOnClickListener(this);
        activity_btn_11.setOnClickListener(this);

            }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.activity_btn_1:
                showToast("客户");
                break;
            case R.id.activity_btn_2:
                showToast("维修");
                break;
            case R.id.activity_btn_3:
                showToast("洗车");
                break;
            case R.id.activity_btn_4:
                showToast("理赔");
                break;
            case R.id.activity_btn_5:
                showToast("保养");
                break;
            case R.id.activity_btn_6:
                showToast("收款");
                break;
            case R.id.activity_btn_7:
                showToast("呼叫淘气包");
                break;
            case R.id.activity_btn_8:
                showToast("首页");
                break;
            case R.id.activity_btn_9:
                showToast("移动接车");
                break;
            case R.id.activity_btn_10:
                showToast("工作看板");
                break;
            case R.id.activity_btn_11:
                showToast("报表");
                break;

        }
    }

    public void showToast(String str){

        Toast.makeText(this,str,Toast.LENGTH_SHORT).show();

    }

}




