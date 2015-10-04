package com.taoqibao.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.android.volley.Response.ErrorListener;
import com.android.volley.VolleyError;
import com.like.likeutils.network.GsonUtil;
import com.like.likeutils.storage.SPUtils;
import com.taoqibao.carclaims.BaseActivity;
import com.taoqibao.entity.LoginResult;
import com.taoqibao.network.DataFetcher;

public class BaseFragment extends Fragment {
	
	protected Context mContext;
	protected DataFetcher mDataFetcher;
	protected ErrorListener mErrorListener;
	protected LoginResult mLoginUser;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		mContext = getActivity();
		mDataFetcher = DataFetcher.getInstance(mContext);
		String loginUserStr = (String) SPUtils.get(mContext, BaseActivity.SP_LOGIN_USER, "");
		if(!TextUtils.isEmpty(loginUserStr)) {
			mLoginUser = GsonUtil.gson.fromJson(loginUserStr, LoginResult.class);
		}
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
		return super.onCreateView(inflater, container, savedInstanceState);
	}

}
