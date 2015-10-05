package com.taoqibao.carclaims;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.Response.Listener;
import com.like.likeutils.network.GsonUtil;
import com.taoqibao.adapter.CarBrandListAdapter;
import com.taoqibao.entity.CarBrand;
import com.taoqibao.entity.CarBrandComparator;
import com.taoqibao.network.GsonConverter;
import com.taoqibao.widget.sortlistview.CharacterParser;
import com.taoqibao.widget.sortlistview.SideBar;
import com.taoqibao.widget.sortlistview.SideBar.OnTouchingLetterChangedListener;
import com.taoqibao.widget.sortlistview.SortModel;

public class SelectCarActivity extends BaseActivity {
	
	public static final String SELECTED_CAR = "selected_car";
	
	private List<CarBrand> mBrands;
	private ListView mBrandList;
	private SideBar mSideBar;
	private TextView mTxtDialog;
	private CarBrandListAdapter mAdapter;
	
	private CharacterParser mCharacterParser;
	private CarBrandComparator mCarBrandComparator;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_select_car);
		
		initView();
		
		getCarBrands();
	}
	
	private void initView() {
		mCharacterParser = CharacterParser.getInstance();
		mCarBrandComparator = new CarBrandComparator();
		mBrandList = (ListView) findViewById(R.id.car_list);
		mBrandList.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				String json = GsonUtil.gson.toJson(mAdapter.getItem(position));
				Intent intent = new Intent();
				intent.putExtra(SELECTED_CAR, json);
				setResult(RESULT_OK, intent);
				SelectCarActivity.this.finish();
			}
		});
		mSideBar = (SideBar) findViewById(R.id.sidebar);
		mTxtDialog = (TextView) findViewById(R.id.dialog);
		mSideBar.setTextView(mTxtDialog);
		mSideBar.setOnTouchingLetterChangedListener(new OnTouchingLetterChangedListener() {
			@Override
			public void onTouchingLetterChanged(String s) {
				int position = mAdapter.getPositionForSection(s.charAt(0));
				if(position != -1){
					mBrandList.setSelection(position);
				}
			}
		});
	}
	
	private List<CarBrand> toList(Map<String, List<CarBrand>> brands) {
		List<CarBrand> result = new ArrayList<CarBrand>();
		for(String key : brands.keySet()) {
			result.addAll(brands.get(key));
		}
		return result;
	}
	
	private SortModel filledData(String data) {
		SortModel model = new SortModel();
		model.setName(data);
		String pinyin = mCharacterParser.getSelling(data);
		String sortString = pinyin.substring(0, 1).toUpperCase(Locale.getDefault());
		if(sortString.matches("[A-Z]")){
			model.setSortLetters(sortString.toUpperCase(Locale.getDefault()));
		}else{
			model.setSortLetters("#");
		}
		return model;
	}
	
	private void sortCar() {
		for(CarBrand brand : mBrands) {
			SortModel sortModel = filledData(brand.brandName);
			brand.sortModel = sortModel;
		}
		Collections.sort(mBrands, mCarBrandComparator);
	}
	
	private void getCarBrands() {
		mDataFetcher.fetchCarBrand(new Listener<String>(){
			@Override
			public void onResponse(String response) {
				Map<String, List<CarBrand>> brands = GsonConverter.toBrandMap(response);
				mBrands = toList(brands);
				sortCar();
				if(mAdapter == null) {
					mAdapter = new CarBrandListAdapter(mContext, mBrands);
					mBrandList.setAdapter(mAdapter);
				} else {
					mAdapter.update(mBrands);
				}
			}}, mErrorListener);
	}

}
