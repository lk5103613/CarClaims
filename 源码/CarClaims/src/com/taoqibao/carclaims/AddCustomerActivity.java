package com.taoqibao.carclaims;

import com.android.volley.Response.Listener;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class AddCustomerActivity extends BaseActivity {
	
	private EditText mTxtName;
	private TextView mRdoMale;
	private TextView mRdoFemale;
	private EditText mTxtVinNo;
	private EditText mTxtCarNo;
	private TextView mLblCarPrefix;
	private EditText mTxtPhoneNum;
	private EditText mTxtEngineNo;
	private EditText mTxtBrandNo;
	private EditText mTxtInsurance;
	private EditText mTxtInsuranceNo;
	
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
		mTxtVinNo = (EditText) findViewById(R.id.txt_vin_code);
		mTxtPhoneNum = (EditText) findViewById(R.id.txt_phone_num);
		mTxtCarNo = (EditText) findViewById(R.id.txt_car_no);
		mTxtEngineNo = (EditText) findViewById(R.id.txt_engine_no);
		mTxtBrandNo = (EditText) findViewById(R.id.txt_brand_no);
		mTxtInsurance = (EditText) findViewById(R.id.txt_insurance);
		mTxtInsuranceNo = (EditText) findViewById(R.id.txt_insurance_no);
	}
	
	public void save(View v) {
		String name = mTxtName.getText().toString();
		String cellPhone = mTxtPhoneNum.getText().toString();
		String idOwnOrg = mLoginUser.idOwnOrg;
		String carNo = mTxtCarNo.getText().toString();
		String carPrefix = mLblCarPrefix.getText().toString();
		String vin = mTxtVinNo.getText().toString();
		String brandId = mTxtBrandNo.getText().toString();
		String sex = "œ»…˙";
		String factoryId = "";
		String lineId = "";
		String engineId = "";
		String mainId = "";
		String mengineNumber = mTxtEngineNo.getText().toString();
		String factoryCode = "";
		String idInsuranceCompany = "";
		String insurancepolicyNo = "";
		mDataFetcher.fetchAddCustomer(name, cellPhone, idOwnOrg, carNo, carPrefix, sex, vin, brandId, factoryId, lineId, 
				engineId, mainId, mengineNumber, factoryCode, idInsuranceCompany, insurancepolicyNo, new Listener<String>() {
					@Override
					public void onResponse(String response) {
					}
				}, mErrorListener);
	}

}
