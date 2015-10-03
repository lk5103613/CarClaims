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
							Toast.makeText(mContext, "请求错误", Toast.LENGTH_SHORT).show();
						} else if(statusCode >= 500) {
							Toast.makeText(mContext, "服务器内部错误", Toast.LENGTH_SHORT).show();
						} else {
							Toast.makeText(mContext, "访问出现错误，请检查网络", Toast.LENGTH_SHORT).show();
						}
					}
				} else {
					Toast.makeText(mContext, "请检查网络", Toast.LENGTH_SHORT).show();
				}
			}
		};
	}
	
	public void back(View v) {
		this.finish();
	}

}
