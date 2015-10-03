package com.example.sunkeqiang.workformoney;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity implements View.OnClickListener{
    private TextView activiy_1;
    private TextView activiy_2;
    private TextView activiy_3;
    private TextView activiy_4;
    private TextView activiy_5;
    private TextView activiy_6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findview();
        init();



    }
    private void findview(){
        activiy_1 = (TextView) findViewById(R.id.activiy_1);
        activiy_2 = (TextView) findViewById(R.id.activiy_2);
        activiy_3 = (TextView) findViewById(R.id.activiy_3);
        activiy_4 = (TextView) findViewById(R.id.activiy_4);
        activiy_5 = (TextView) findViewById(R.id.activiy_5);
        activiy_6 = (TextView) findViewById(R.id.activiy_6);

    }

    private void init(){
        activiy_1.setOnClickListener(this);
        activiy_2.setOnClickListener(this);
        activiy_3.setOnClickListener(this);
        activiy_4.setOnClickListener(this);
        activiy_5.setOnClickListener(this);
        activiy_6.setOnClickListener(this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.activiy_1:
                Intent i1 = new Intent(this,Activity_1.class);
                startActivity(i1);
                break;
            case R.id.activiy_2:
                Intent i2= new Intent(this,Activity_2.class);
                startActivity(i2);

                break;
            case R.id.activiy_3:
                Intent i3= new Intent(this,Activity_3.class);
                startActivity(i3);

                break;
            case R.id.activiy_4:
                Intent i4= new Intent(this,Activity_4.class);
                startActivity(i4);
                break;
            case R.id.activiy_5:
                Intent i5= new Intent(this,Activity_5.class);
                startActivity(i5);
                break;
            case R.id.activiy_6:
                Intent i6= new Intent(this,Activity_6.class);
                startActivity(i6);
                break;
            default:

                break;
        }
    }
}
