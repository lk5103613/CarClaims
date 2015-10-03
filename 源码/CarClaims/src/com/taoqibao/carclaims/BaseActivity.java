package com.taoqibao.carclaims;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.android.volley.Response.ErrorListener;
import com.android.volley.VolleyError;
import com.taoqibao.network.DataFetcher;

public class BaseActivity extends Activity {
	
	protected Context mContext;
	protected DataFetcher mDataFetcher;
	protected ErrorListener mErrorListener;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.mContext = this;
		mDataFetcher = DataFetcher.getInstance(mContext);
		mErrorListener = new ErrorListener() {
			@Override
			public void onErrorResponse(VolleyError err) {
				if(err != null) {
					if(err.networkResponse != null){
						int statusCode = err.networkResponse.statusCode;
						if(statusCode >= 400 && statusCode < 500) {
							Toast.makeText(mContext, "�������", Toast.LENGTH_SHORT).show();
						} else if(statusCode >= 500) {
							Toast.makeText(mContext, "�������ڲ�����", Toast.LENGTH_SHORT).show();
						} else {
							Toast.makeText(mContext, "���ʳ��ִ�����������", Toast.LENGTH_SHORT).show();
						}
					}
				} else {
					Toast.makeText(mContext, "��������", Toast.LENGTH_SHORT).show();
				}
			}
		};
	}
	
	public void back(View v) {
		this.finish();
	}

}
