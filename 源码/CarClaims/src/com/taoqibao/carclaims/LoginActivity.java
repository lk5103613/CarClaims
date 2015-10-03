package com.taoqibao.carclaims;

import com.android.volley.Response.Listener;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends BaseActivity {
	
	private EditText mTxtCode;
	private EditText mTxtUsername;
	private EditText mTxtPwd;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		
		mDataFetcher.fetchBrandList(new Listener<String>() {
			@Override
			public void onResponse(String response) {
			}
		}, null);
		initView();
	}
	
	private void initView() {
		this.mTxtCode = (EditText) findViewById(R.id.codeTv);
		this.mTxtUsername = (EditText) findViewById(R.id.mpTv);
		this.mTxtPwd = (EditText) findViewById(R.id.pwdTv);
	}
	
	public void login(View v) {
		String code = mTxtCode.getText().toString();
		String username = mTxtUsername.getText().toString();
		String pwd = mTxtPwd.getText().toString();
		if(TextUtils.isEmpty(code) || TextUtils.isEmpty(username) || TextUtils.isEmpty(pwd)) {
			Toast.makeText(mContext, "填写信息不完整", Toast.LENGTH_SHORT).show();
			return;
		}
		mDataFetcher.fetchLogin(code, username, pwd, new Listener<String>() {
			@Override
			public void onResponse(String response) {
			}
		}, mErrorListener);
	}
	
}
