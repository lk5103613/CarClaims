package com.taoqibao.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;

import com.taoqibao.carclaims.R;
import com.taoqibao.carclaims.SelectCustomerActivity;

public class IndexFragment extends BaseFragment implements OnClickListener {
	
	private ViewGroup mBtnCustomer;
	
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
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btn_customer:
			Intent intent = new Intent(mContext, SelectCustomerActivity.class);
			startActivity(intent);
			break;

		default:
			break;
		}
	}
	
	

}
