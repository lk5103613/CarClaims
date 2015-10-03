package com.taoqibao.network;

import android.content.Context;

import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.like.likeutils.network.DataFetcherBase;

public class DataFetcher extends DataFetcherBase {
	
	private static DataFetcher mDataFetcher;

	private DataFetcher(Context context) {
		super(context);
		setDebug(true);
	}
	
	public static DataFetcher getInstance(Context context) {
		if(mDataFetcher == null)
			mDataFetcher = new DataFetcher(context);
		return mDataFetcher;
	}
	
	public void fetchLogin(String code, String username, String pwd, Listener<String> listener, ErrorListener errorListener) {
		fetchData(APIS.LOGIN, listener, errorListener, code, username, pwd);
	}

}
