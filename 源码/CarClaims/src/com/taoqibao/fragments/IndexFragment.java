package com.taoqibao.fragments;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;

import com.taoqibao.carclaims.R;
import com.taoqibao.carclaims.SelectCustomerActivity;

public class IndexFragment extends BaseFragment implements OnClickListener {
	
	public static final String PHONE_NUMBER = "12345678901";
	
	private ViewGroup mBtnCustomer;
	private ViewGroup mBtnCall;
	private ViewGroup mBtnRepair; 
	private ViewGroup mBtnClaims;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		super.onCreateView(inflater, container, savedInstanceState);
		View view = inflater.inflate(R.layout.fragment_index, container, false);
		initView(view);
		return view;
	}
	
	private void initView(View view) {
		mBtnCustomer = (ViewGroup) view.findViewById(R.id.btn_customer);
		mBtnCustomer.setOnClickListener(this);
		mBtnCall = (ViewGroup) view.findViewById(R.id.btn_call);
		mBtnCall.setOnClickListener(this);
		mBtnRepair = (ViewGroup) view.findViewById(R.id.btn_repair);
		mBtnRepair.setOnClickListener(this);
		mBtnClaims = (ViewGroup) view.findViewById(R.id.btn_claims);
		mBtnClaims.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		Intent intent;
		switch (v.getId()) {
		case R.id.btn_customer:
			intent = new Intent(mContext, SelectCustomerActivity.class);
			intent.putExtra(SelectCustomerActivity.TYPE, 1);
			break;
		case R.id.btn_call:
			intent = new Intent(Intent.ACTION_CALL,Uri.parse("tel:" + PHONE_NUMBER));  
			break;
		case R.id.btn_repair:
			intent = new Intent(mContext, SelectCustomerActivity.class);
			intent.putExtra(SelectCustomerActivity.TYPE, 2);
			break;
		case R.id.btn_claims:
			intent = new Intent(mContext, SelectCustomerActivity.class);
			intent.putExtra(SelectCustomerActivity.TYPE, 3);
			break;
		default:
			return;
		}
		if(intent != null)
			startActivity(intent);
	}
	
	

}
