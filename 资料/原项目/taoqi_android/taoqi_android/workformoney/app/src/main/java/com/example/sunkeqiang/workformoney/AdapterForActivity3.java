package com.example.sunkeqiang.workformoney;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

/**
 * Created by sunkeqiang on 15/8/16.
 */
public class AdapterForActivity3 extends BaseAdapter {
    private Context context;

    public AdapterForActivity3(Context context){
        this.context = context;
    }

    @Override
    public int getCount() {
        return 20;
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        view = LayoutInflater.from(context).inflate(R.layout.item_activity_3,viewGroup,false);
        return view;
    }
}
