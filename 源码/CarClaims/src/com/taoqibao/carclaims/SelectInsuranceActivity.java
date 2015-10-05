package com.taoqibao.carclaims;

import java.util.List;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import com.android.volley.Response.Listener;
import com.like.likeutils.network.GsonUtil;
import com.taoqibao.adapter.InsuranceListAdapter;
import com.taoqibao.entity.Insurance;
import com.taoqibao.network.GsonConverter;

public class SelectInsuranceActivity extends BaseActivity {
	
	public static final String SELECTED_INSURANCE = "selected_insurance";
	
	private ListView mInsuranceList;
	private InsuranceListAdapter mAdapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_select_insurance);
		
		initView();
		getInsurance();
		
	}
	
	private void initView() {
		mInsuranceList = (ListView) findViewById(R.id.insurance_list);
		mInsuranceList.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				Insurance insurance = mAdapter.getItem(position);
				Intent intent = new Intent();
				String json = GsonUtil.gson.toJson(insurance);
				intent.putExtra(SELECTED_INSURANCE, json);
				setResult(RESULT_OK, intent);
				SelectInsuranceActivity.this.finish();
			}
		});
	}
	
	private void getInsurance() {
		mDataFetcher.fetchInsuranceList(mLoginUser.idOwnOrg, new Listener<String>() {
			@Override
			public void onResponse(String response) {
				List<Insurance> insurances = GsonConverter.toInsuranceList(response);
				if(mAdapter == null) {
					mAdapter = new InsuranceListAdapter(mContext, insurances);
					mInsuranceList.setAdapter(mAdapter);
				} else {
					mAdapter.update(insurances);
				}
			}
		}, mErrorListener);
	}
	
	public void addInsurance(View v) {
		Intent intent = new Intent(mContext, AddInsuranceActivity.class);
		startActivity(intent);
	}

}
