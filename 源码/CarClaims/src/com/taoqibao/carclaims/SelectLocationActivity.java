package com.taoqibao.carclaims;

import java.util.ArrayList;
import java.util.List;

import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Response.Listener;
import com.taoqibao.entity.AreaInfo;
import com.taoqibao.network.GsonConverter;

public class SelectLocationActivity extends BaseActivity {

	private PopupWindow mProWindow, mCityWindow, mAddressWindow;
	private ImageView mDropTarget1, mDropTarget2, mDropTarget3;
	private TextView mTxtPro, mTxtCity, mTxtArea;
	private EditText mTxtDetailAddress;
	private ArrayAdapter<String> mDropAdapter1, mDropAdapter2, mDropAdapter3;
	private List<AreaInfo> mPros, mCities, mAreas;
	private String mProId, mCityId, mAreaId;
	private AreaInfo mPro, mCity, mArea;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_select_location);
		initView();
	}
	
	private void initView() {
		mDropTarget1 = (ImageView) findViewById(R.id.drop_target1);
		mDropTarget2 = (ImageView) findViewById(R.id.drop_target2);
		mDropTarget3 = (ImageView) findViewById(R.id.drop_target3);
		mTxtPro = (TextView) findViewById(R.id.province);
		mTxtCity = (TextView) findViewById(R.id.city);
		mTxtArea = (TextView) findViewById(R.id.area);
		mTxtDetailAddress = (EditText) findViewById(R.id.txt_detail_address);
	}

	
	private void getBaseArea() {
		mDataFetcher.fetchProvienceList(new Listener<String>() {
			@Override
			public void onResponse(String response) {
				mPros = GsonConverter.toAreaList(response);
				List<String> pros = new ArrayList<String>();
				for(AreaInfo area : mPros) {
					pros.add(area.regionName);
				}
				mDropAdapter1 = new ArrayAdapter<String>(mContext, R.layout.dropdown_option_item, pros);
				showPro();
			}
		}, mErrorListener);
	}
	
	private void showPro() {
		if (mProWindow == null) {
			LayoutInflater mLayoutInflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
			View view = mLayoutInflater.inflate(R.layout.dropdown_dialog, null,
					false);
			ListView list = (ListView) view.findViewById(R.id.option_list);
			list.setAdapter(mDropAdapter1);
			list.setOnItemClickListener(new OnItemClickListener() {
				@Override
				public void onItemClick(AdapterView<?> parent, View view,
						int position, long id) {
					mPro = mPros.get(position); mCity = null; mArea = null;
					String proId = mPros.get(position).regionId;
					if(!TextUtils.equals(proId, mProId)) {
						mProId = proId;
						mDataFetcher.fetchAreaList(proId, new Listener<String>(){
							@Override
							public void onResponse(String response) {
								List<String> cities = new ArrayList<String>();
								mCities = GsonConverter.toAreaList(response);
								for(AreaInfo area : mCities) {
									cities.add(area.regionName);
								}
								mDropAdapter2 = new ArrayAdapter<>(mContext, R.layout.dropdown_option_item, cities);
							}}, mErrorListener);
					}
					String pro = mDropAdapter1.getItem(position);
					mTxtPro.setText(pro);
					if (mProWindow.isShowing())
						mProWindow.dismiss();
				}
			});
			mProWindow = new PopupWindow(view, 300, 500, true);
			mProWindow.setBackgroundDrawable(new BitmapDrawable());
		}
		mProWindow.showAsDropDown(mDropTarget1, -200, 0);
	}
	
	private void showCity() {
		if(mDropAdapter2 == null) {
			Toast.makeText(mContext, "请选择省份", Toast.LENGTH_SHORT).show();
			return;
		}
		if(mCityWindow == null) {
			LayoutInflater mLayoutInflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
			View view = mLayoutInflater.inflate(R.layout.dropdown_dialog, null,
					false);
			ListView list = (ListView) view.findViewById(R.id.option_list);
			list.setAdapter(mDropAdapter2);
			list.setOnItemClickListener(new OnItemClickListener() {
				@Override
				public void onItemClick(AdapterView<?> parent, View view,
						int position, long id) {
					mCity = mCities.get(position); mArea = null;
					String cityId = mCities.get(position).regionId;
					if(!TextUtils.equals(cityId, mCityId)) {
						mCityId = cityId;
						mDataFetcher.fetchAreaList(cityId, new Listener<String>(){
							@Override
							public void onResponse(String response) {
								List<String> areas = new ArrayList<String>();
								mCities = GsonConverter.toAreaList(response);
								for(AreaInfo area : mCities) {
									areas.add(area.regionName);
								}
								mDropAdapter3 = new ArrayAdapter<>(mContext, R.layout.dropdown_option_item, areas);
							}}, mErrorListener);
					}
					String city = mDropAdapter2.getItem(position);
					mTxtCity.setText(city);
					if (mCityWindow.isShowing())
						mCityWindow.dismiss();
				}
			});
			mCityWindow = new PopupWindow(view, 300, 500, true);
			mCityWindow.setBackgroundDrawable(new BitmapDrawable());
		}
		mCityWindow.showAsDropDown(mDropTarget2, -200, 0);
	}
	
	private void showArea() {
		if(mDropAdapter3 == null) {
			Toast.makeText(mContext, "请选择城市", Toast.LENGTH_SHORT).show();
			return;
		}
		if(mAddressWindow == null) {
			LayoutInflater mLayoutInflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
			View view = mLayoutInflater.inflate(R.layout.dropdown_dialog, null,
					false);
			ListView list = (ListView) view.findViewById(R.id.option_list);
			list.setAdapter(mDropAdapter3);
			list.setOnItemClickListener(new OnItemClickListener() {
				@Override
				public void onItemClick(AdapterView<?> parent, View view,
						int position, long id) {
					mArea = mCities.get(position);
					String addressId = mCities.get(position).regionId;
					if(!TextUtils.equals(addressId, mAreaId)) {
						mAreaId = addressId;
					}
					String area = mDropAdapter3.getItem(position);
					mTxtArea.setText(area);
					if (mCityWindow.isShowing())
						mCityWindow.dismiss();
				}
			});
			mCityWindow = new PopupWindow(view, 300, 500, true);
			mCityWindow.setBackgroundDrawable(new BitmapDrawable());
		}
		mCityWindow.showAsDropDown(mDropTarget3, -200, 0);
	}

	public void openPop(View v) {
		switch (v.getId()) {
		case R.id.province_selector:
			getBaseArea();
			break;
		case R.id.city_selector:
			showCity();
			break;
		case R.id.area_selector:
			showArea();
			break;
		default:
			break;
		}
	}
	
	public void selectArea(View v) {
		String detailAddress = mTxtDetailAddress.getText().toString();
		if(mPro == null) {
			Toast.makeText(mContext, "请选择省份", Toast.LENGTH_SHORT).show();
			return;
		}
		if(mCity == null) {
			Toast.makeText(mContext, "请选择城市", Toast.LENGTH_SHORT).show();
			return;
		}
		if(mArea == null) {
			Toast.makeText(mContext, "请选择区域", Toast.LENGTH_SHORT).show();
			return;
		}
		if(TextUtils.isEmpty(detailAddress)) {
			Toast.makeText(mContext, "请输入详细地址", Toast.LENGTH_SHORT).show();
			return;
		}
		Intent intent = new Intent();
	}

}
