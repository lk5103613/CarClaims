package com.example.sunkeqiang.workformoney;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

/**
 * Created by sunkeqiang on 15/8/16.
 */
public class Activity_6 extends Activity implements View.OnClickListener {
    private ImageView activity_6_btn_1;
    private TextView activity_6_btn_2;
    private LinearLayout activity_6_btn_3;
    private LinearLayout activity_6_btn_4;
    private LinearLayout activity_6_btn_5;
    private LinearLayout activity_6_btn_6;
    private TextView activity_6_btn_7;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_6);
    findview();
        init();

    }

    private void findview(){
        activity_6_btn_1 = (ImageView) findViewById(R.id.activity_6_btn_1);
        activity_6_btn_2 = (TextView) findViewById(R.id.activity_6_btn_2);
        activity_6_btn_3 = (LinearLayout) findViewById(R.id.activity_6_btn_3);
        activity_6_btn_4 = (LinearLayout) findViewById(R.id.activity_6_btn_4);
        activity_6_btn_5 = (LinearLayout) findViewById(R.id.activity_6_btn_5);
        activity_6_btn_6 = (LinearLayout) findViewById(R.id.activity_6_btn_6);
        activity_6_btn_7 = (TextView) findViewById(R.id.activity_6_btn_7);



    }

    private void init(){
        activity_6_btn_1.setOnClickListener(this);
        activity_6_btn_2.setOnClickListener(this);
        activity_6_btn_3.setOnClickListener(this);
        activity_6_btn_4.setOnClickListener(this);
        activity_6_btn_5.setOnClickListener(this);
        activity_6_btn_6.setOnClickListener(this);
        activity_6_btn_7.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
    switch (view.getId()){
        case R.id.activity_6_btn_1:
            showToast("左上－返回");
            break;
        case R.id.activity_6_btn_2:
            showToast("右上－完成");
            break;
        case R.id.activity_6_btn_3:
            showToast("支付宝");
            break;
        case R.id.activity_6_btn_4:
            showToast("微信");
            break;
        case R.id.activity_6_btn_5:
            showToast("银行卡");
            break;
        case R.id.activity_6_btn_6:
            showToast("现金");
            break;
        case R.id.activity_6_btn_7:
            showToast("确认");
            break;
        default:

            break;



    }
    }

    public void showToast(String str){

        Toast.makeText(this, str, Toast.LENGTH_SHORT).show();

    }
}
