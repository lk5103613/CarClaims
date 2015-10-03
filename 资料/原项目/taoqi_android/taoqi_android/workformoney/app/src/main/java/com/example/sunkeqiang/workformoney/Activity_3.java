package com.example.sunkeqiang.workformoney;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by sunkeqiang on 15/8/16.
 */
public class Activity_3 extends Activity implements View.OnClickListener {
    private ImageView activity_3_btn_1;
    private ImageView activity_3_btn_2;
    private ListView lv_activity_3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);

        findview();
        init();


    }

    private void findview(){
        activity_3_btn_1 = (ImageView) findViewById(R.id.activity_3_btn_1);
        activity_3_btn_2 = (ImageView) findViewById(R.id.activity_3_btn_2);
        lv_activity_3 = (ListView) findViewById(R.id.lv_activity3);
    }

    private void init(){
        activity_3_btn_1.setOnClickListener(this);
        activity_3_btn_2.setOnClickListener(this);


        lv_activity_3.setAdapter(new AdapterForActivity3(this));
        lv_activity_3.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                showToast("你点击了第"+i+"个");
            }
        });
    }

    @Override
    public void onClick(View view) {
    switch (view.getId()){
        case R.id.activity_3_btn_1:
showToast("左上－返回");
            break;
        case R.id.activity_3_btn_2:
showToast("右上－加号（＋）");
            break;

        default:
            break;


    }
    }


    public void showToast(String str){

        Toast.makeText(this, str, Toast.LENGTH_SHORT).show();

    }
}
