package com.taoqibao.carclaims;

import java.util.List;

import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.android.volley.Response.Listener;
import com.like.likeutils.network.GsonUtil;
import com.taoqibao.entity.CarBrand;
import com.taoqibao.entity.Insurance;
import com.taoqibao.network.GsonConverter;

public class AddCustomerActivity extends BaseActivity implements
		OnClickListener {

	public static final int REQUEST_CAR_BRAND = 0;
	public static final int REQUEST_INSURANCE = 1;

	private EditText mTxtName;
	private TextView mRdoMale;
	private TextView mRdoFemale;
	private EditText mTxtVinNo;
	private EditText mTxtCarNo;
	private TextView mLblCarPrefix;
	private EditText mTxtPhoneNum;
	private EditText mTxtEngineNo;
	private TextView mLblBrandNo;
	private TextView mLblInsurance;
	private EditText mTxtInsuranceNo;
	private ImageView mDropTarget;
	private PopupWindow mDropWindow;
	private List<String> mPrefixes;
	private ArrayAdapter<String> mDropAdapter;
	private CarBrand mBrand;
	private Insurance mInsurance;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_add_customer);
		initView();
	}

	private void initView() {
		mTxtName = (EditText) findViewById(R.id.txt_name);
		mRdoMale = (TextView) findViewById(R.id.rdo_male);
		mRdoFemale = (TextView) findViewById(R.id.rdo_female);
		mRdoMale.setSelected(true);
		mRdoMale.setOnClickListener(this);
		mRdoFemale.setOnClickListener(this);
		mTxtVinNo = (EditText) findViewById(R.id.txt_vin_code);
		mTxtPhoneNum = (EditText) findViewById(R.id.txt_phone_num);
		mTxtCarNo = (EditText) findViewById(R.id.txt_car_no);
		mTxtEngineNo = (EditText) findViewById(R.id.txt_engine_no);
		mLblBrandNo = (TextView) findViewById(R.id.lbl_brand_no);
		mLblInsurance = (TextView) findViewById(R.id.lbl_insurance);
		mTxtInsuranceNo = (EditText) findViewById(R.id.txt_insurance_no);
		mDropTarget = (ImageView) findViewById(R.id.drop_target);
		mLblCarPrefix = (TextView) findViewById(R.id.lbl_car_prefix);
	}

	public void save(View v) {
		String name = mTxtName.getText().toString();
		String cellPhone = mTxtPhoneNum.getText().toString();
		String idOwnOrg = mLoginUser.idOwnOrg;
		String carNo = mTxtCarNo.getText().toString();
		String carPrefix = mLblCarPrefix.getText().toString();
		String vin = mTxtVinNo.getText().toString();
		String brandId = mLblBrandNo.getText().toString();
		String sex = "先生";
		if (mRdoFemale.isSelected())
			sex = "女士";
		String factoryId = "";
		String lineId = "";
		String engineId = "";
		String mainId = "";
		String mengineNumber = mTxtEngineNo.getText().toString();
		String factoryCode = "";
		String idInsuranceCompany = "";
		String insurancepolicyNo = "";
		mDataFetcher.fetchAddCustomer(name, cellPhone, idOwnOrg, carNo,
				carPrefix, sex, vin, brandId, factoryId, lineId, engineId,
				mainId, mengineNumber, factoryCode, idInsuranceCompany,
				insurancepolicyNo, new Listener<String>() {
					@Override
					public void onResponse(String response) {
					}
				}, mErrorListener);
	}

	public void selectPrefix(View v) {
		if (mPrefixes == null) {
			mDataFetcher.fetchCarPreFix(new Listener<String>() {
				@Override
				public void onResponse(String response) {
					mPrefixes = GsonConverter.toCarPreFix(response);
					mDropAdapter = new ArrayAdapter<>(mContext,
							R.layout.dropdown_option_item, mPrefixes);
					showPopup();
				}
			}, mErrorListener);
		} else
			showPopup();
	}

	public void selectCarBrand(View v) {
		Intent intent = new Intent(mContext, SelectCarActivity.class);
		startActivityForResult(intent, REQUEST_CAR_BRAND);
	}
	
	public void selectInsurance(View v) {
		Intent intent = new Intent(mContext, SelectInsuranceActivity.class);
		startActivityForResult(intent, REQUEST_INSURANCE);
	}

	private void showPopup() {
		if (mDropWindow == null) {
			LayoutInflater mLayoutInflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
			View view = mLayoutInflater.inflate(R.layout.dropdown_dialog, null,
					false);
			ListView list = (ListView) view.findViewById(R.id.option_list);
			list.setAdapter(mDropAdapter);
			list.setOnItemClickListener(new OnItemClickListener() {
				@Override
				public void onItemClick(AdapterView<?> parent, View view,
						int position, long id) {
					String prefix = mDropAdapter.getItem(position);
					mLblCarPrefix.setText(prefix);
					if (mDropWindow.isShowing())
						mDropWindow.dismiss();
				}
			});
			mDropWindow = new PopupWindow(view, 300, 500, true);
			mDropWindow.setBackgroundDrawable(new BitmapDrawable());
		}
		mDropWindow.showAsDropDown(mDropTarget, -200, 0);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.rdo_male:
			mRdoMale.setSelected(true);
			mRdoFemale.setSelected(false);
			break;
		case R.id.rdo_female:
			mRdoMale.setSelected(false);
			mRdoFemale.setSelected(true);
			break;
		default:
			break;
		}
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (resultCode == RESULT_OK) {
			switch (requestCode) {
			case REQUEST_CAR_BRAND:
				String carJson = data.getStringExtra(SelectCarActivity.SELECTED_CAR);
				mBrand = GsonUtil.gson.fromJson(carJson, CarBrand.class);
				mLblBrandNo.setText(mBrand.brandName);
				break;
			case REQUEST_INSURANCE:
				String insuranceJson = data.getStringExtra(SelectInsuranceActivity.SELECTED_INSURANCE);
				mInsurance = GsonUtil.gson.fromJson(insuranceJson, Insurance.class);
				mLblInsurance.setText(mInsurance.name);
				break;
			}
		}
	}

}
