package com.taoqibao.network;

import java.util.Map;

import android.content.Context;

import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.like.likeutils.network.DataFetcherBase;
import com.like.likeutils.network.NetParamGenerator;

public class DataFetcher extends DataFetcherBase {
	
	private static DataFetcher mDataFetcher;

	private DataFetcher(Context context) {
		super(context);
		setDebug(true);
	}
	
	public static DataFetcher getInstance(Context context) {
		if(mDataFetcher == null)
			mDataFetcher = new DataFetcher(context);
		return mDataFetcher;
	}
	
	public void fetchLogin(String code, String username, String pwd, Listener<String> listener, ErrorListener errorListener) {
		fetchData(APIS.LOGIN, listener, errorListener, code, username, pwd);
	}
	
	public void fetchProvienceList(Listener<String> listener, ErrorListener errorListener) {
		fetchData(APIS.GET_PROVIENCE_LIST, listener, errorListener);
	}
	
	public void fetchCityList(String proId, Listener<String> listener, ErrorListener errorListener) {
		fetchData(APIS.GET_CITY_LIST, listener, errorListener, proId);
	}
	
	public void fetchCarPreFix(Listener<String> listener, ErrorListener errorListener) {
		fetchData(APIS.GET_CAR_PRE_FIX, listener, errorListener);
	}
	
	public void fetchCarBrand(Listener<String> listener, ErrorListener errorListener) {
		fetchData(APIS.GET_CAR_BRAND, listener, errorListener);
	}
	
	public void fetchCarCommonBrand(Listener<String> listener, ErrorListener errorListener) {
		fetchData(APIS.GET_CAR_COMMON_BRAND, listener, errorListener);
	}
	
	public void fetchCarLineById(String brandId, Listener<String> listener, ErrorListener errorListener){
		fetchData(APIS.GET_CAR_FAC_BY_ID, listener, errorListener, brandId);
	}
	
	public void fetchCarEnginById(String lineId, Listener<String> listener, ErrorListener errorListener) {
		fetchData(APIS.GET_CAR_ENGINE_BY_ID, listener, errorListener, lineId);
	}
	
	public void fetchCarMainById(String brandId, String factoryId, String lineId, String engineId, 
			Listener<String> listener, ErrorListener errorListener) {
		fetchData(APIS.GET_CAR_MAIN_BY_ID, listener, errorListener, brandId, factoryId, lineId, engineId);
	}
	
	public void fetchInsuranceList(String ownOrgId, Listener<String> listener, ErrorListener errorListener) {
		fetchData(APIS.GET_INSURANCE_LIST, listener, errorListener, ownOrgId);
	}
	
	public void fetchAddInsurance(String name, String province, String city, String area, String street, String address,
			String detailAddress, String contacts, String contactMobile, String contactTelephone, String fax, String isDel,
			String idOwnOrg, Listener<String> listener, ErrorListener errorListener) {
		Map<String, String> params = NetParamGenerator.getMapParams(APIS.ADD_INSURANCE, name, province, city, area, street, address,
				detailAddress, contacts, contactMobile, contactTelephone, fax, isDel, idOwnOrg);
		fetchData(APIS.ADD_INSURANCE, params, listener, errorListener);
	}
	
	public void fetchGetCustomerByKey(String idOwnOrg, String keyWord, Listener<String> listener, ErrorListener errorListener) {
		Map<String, String> params = NetParamGenerator.getMapParams(APIS.GET_CUSTOMER_BY_KEY, idOwnOrg, keyWord);
		fetchData(APIS.GET_CUSTOMER_BY_KEY, params, listener, errorListener);
	}
	
	public void fetchAddCustomer(String name, String cellPhone, String idOwnOrg, String carNo, String carPrefix, String sex, 
			String vin, String brandId, String factoryId, String lineId, String engineId, String mainId, String mengineNumber,
			String factoryCode, String idInsuranceCompany, String insurancepolicyNo, Listener<String> listener, ErrorListener errorListener) {
		Map<String, String> params = NetParamGenerator.getMapParams(APIS.ADD_CUSTOMER, name, cellPhone, idOwnOrg, carNo, carPrefix, sex, vin, brandId, 
				factoryId, lineId, engineId, mainId, mengineNumber, factoryCode, idInsuranceCompany, insurancepolicyNo);
		fetchData(APIS.ADD_CUSTOMER, params, listener, errorListener);
	}
	
	public void fetchGetBrandList(Listener<String> listener, ErrorListener errorListener) {
		fetchData(APIS.GET_BRAND_LIST, listener, errorListener);
	}

}
