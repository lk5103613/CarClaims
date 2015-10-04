package com.taoqibao.carclaims;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Response.Listener;
import com.like.likeutils.network.GsonUtil;
import com.like.likeutils.storage.SPUtils;
import com.taoqibao.entity.CommonResult;
import com.taoqibao.entity.LoginResult;
import com.taoqibao.network.GsonConverter;

public class LoginActivity extends BaseActivity {
	
	private EditText mTxtCode;
	private EditText mTxtUsername;
	private EditText mTxtPwd;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		if(mLoginUser != null) {
			toMain();
			this.finish();
		}
		initView();
	}
	
	private void initView() {
		this.mTxtCode = (EditText) findViewById(R.id.codeTv);
		this.mTxtUsername = (EditText) findViewById(R.id.mpTv);
		this.mTxtPwd = (EditText) findViewById(R.id.pwdTv);
	}
	
	private void toMain() {
		Intent intent = new Intent(mContext, MainActivity.class);
		startActivity(intent);
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
				CommonResult<LoginResult> result = GsonConverter.toLoginResult(response);
				if(TextUtils.equals(result.status, STATUS_SUCCESS)) {
					Toast.makeText(mContext, result.str, Toast.LENGTH_SHORT).show();
					String loginResultStr = GsonUtil.gson.toJson(result.result);
					SPUtils.put(mContext, SP_LOGIN_USER, loginResultStr);
					toMain();
					LoginActivity.this.finish();
				} else {
					Toast.makeText(mContext, result.str, Toast.LENGTH_SHORT).show();
				}
			}
		}, mErrorListener);
	}
	
}
