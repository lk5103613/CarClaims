package com.example.sunkeqiang.workformoney;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by sunkeqiang on 15/8/16.
 */
public class Activity_4 extends Activity implements View.OnClickListener {

    private ImageView activity_4_btn_1;
    private ImageView activity_4_btn_2;
    private ImageView activity_4_btn_3;
    private TextView activity_4_btn_4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_4);

        findview();
        init();


    }

    private void findview(){
        activity_4_btn_1 = (ImageView) findViewById(R.id.activity_4_btn_1);
        activity_4_btn_2 = (ImageView) findViewById(R.id.activity_4_btn_2);
        activity_4_btn_3 = (ImageView) findViewById(R.id.activity_4_btn_3);
        activity_4_btn_4 = (TextView) findViewById(R.id.activity_4_btn_4);
    }

    private void init(){
        activity_4_btn_1.setOnClickListener(this);
        activity_4_btn_2.setOnClickListener(this);
        activity_4_btn_3.setOnClickListener(this);
        activity_4_btn_4.setOnClickListener(this);
    }



    @Override
    public void onClick(View view) {
switch (view.getId()){
    case R.id.activity_4_btn_1:
        showToast("左上－返回");
        break;
    case R.id.activity_4_btn_2:
        showToast("右上－加号（＋）");
        break;
    case R.id.activity_4_btn_3:
        showToast("保险公司（>）");
        break;
    case R.id.activity_4_btn_4:
        showToast("下一步");
        break;
    default:
        break;
}
    }


    public void showToast(String str){

        Toast.makeText(this, str, Toast.LENGTH_SHORT).show();

    }
}
