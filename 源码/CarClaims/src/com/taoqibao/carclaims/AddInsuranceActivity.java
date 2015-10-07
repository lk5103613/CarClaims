package com.taoqibao.carclaims;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.like.likeutils.network.GsonUtil;
import com.taoqibao.entity.AreaInfo;
import com.taoqibao.entity.Customer;

public class AddInsuranceActivity extends BaseActivity {
	
	public static final int REQUEST_SELECT_LOCATION = 0;
	public static final int REQUEST_SELECT_USER = 1;
	
	private AreaInfo mPro;
	private AreaInfo mCity;
	private AreaInfo mArea;
	private String mDetailAddress;
	
	private TextView mLblLocation;
	private TextView mLblCustomer;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_add_insurance);
		
		initView();
	}
	
	private void initView() {
		mLblLocation = (TextView) findViewById(R.id.lbl_location);
		mLblCustomer = (TextView) findViewById(R.id.lbl_customer);
	}
	
	public void selectArea(View v) {
		Intent intent = new Intent(mContext, SelectLocationActivity.class);
		startActivityForResult(intent, REQUEST_SELECT_LOCATION);
	}
	
	public void selectCustomer(View view) {
		Intent intent = new Intent(mContext, SelectCustomerActivity.class);
		intent.putExtra(SelectCustomerActivity.TYPE, 1);
		startActivityForResult(intent, REQUEST_SELECT_USER);
	}
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if(resultCode == RESULT_OK) {
			switch (requestCode) {
			case REQUEST_SELECT_LOCATION:
				String proStr = data.getStringExtra(SelectLocationActivity.RESULT_PRO);
				String cityStr = data.getStringExtra(SelectLocationActivity.RESULT_CITY);
				String areaStr = data.getStringExtra(SelectLocationActivity.RESULT_AREA);
				mDetailAddress = data.getStringExtra(SelectLocationActivity.RESULT_DETAIL_ADDRESS);
				mPro = GsonUtil.gson.fromJson(proStr, AreaInfo.class);
				mCity = GsonUtil.gson.fromJson(cityStr, AreaInfo.class);
				mArea = GsonUtil.gson.fromJson(areaStr, AreaInfo.class);
				String showStr = mPro.regionName + " " + mCity.regionName + " " + mArea.regionName + " " + mDetailAddress; 
				mLblLocation.setText(showStr);
				break;
			case REQUEST_SELECT_USER:
				String customerStr = data.getStringExtra(SelectCustomerActivity.RESULT_CUSTOMER);
				Customer customer = GsonUtil.gson.fromJson(customerStr, Customer.class);
				mLblCustomer.setText(customer.name);
				break;
			default:
				break;
			}
		}
	}

}
