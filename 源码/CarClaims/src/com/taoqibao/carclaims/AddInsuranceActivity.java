package com.taoqibao.carclaims;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.like.likeutils.network.GsonUtil;
import com.taoqibao.entity.AreaInfo;

public class AddInsuranceActivity extends BaseActivity {
	
	public static final int REQUEST_SELECT_LOCATION = 0;
	public static final int REQUEST_SELECT_USER = 1;
	
	private AreaInfo mPro;
	private AreaInfo mCity;
	private AreaInfo mArea;
	private String mDetailAddress;
	
	private TextView mLblLocation;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_add_insurance);
		
		initView();
	}
	
	private void initView() {
		mLblLocation = (TextView) findViewById(R.id.lbl_location);
	}
	
	public void selectArea(View v) {
		Intent intent = new Intent(mContext, SelectLocationActivity.class);
		startActivityForResult(intent, REQUEST_SELECT_LOCATION);
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
			default:
				break;
			}
		}
	}

}
