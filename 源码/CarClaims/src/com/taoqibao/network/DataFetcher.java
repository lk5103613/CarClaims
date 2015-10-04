package com.taoqibao.network;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;

import android.content.Context;

import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.like.likeutils.network.DataFetcherBase;
import com.like.likeutils.network.GsonUtil;
import com.like.likeutils.network.NetParamGenerator;
import com.taoqibao.entity.Stuff;
import com.taoqibao.entity.StuffForAdd;

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
	
	public void fetchCustomerByKey(String idOwnOrg, String keyWord, Listener<String> listener, ErrorListener errorListener) {
		try {
			keyWord = URLEncoder.encode(keyWord, "utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		fetchData(APIS.GET_CUSTOMER_BY_KEY, listener, errorListener, idOwnOrg, keyWord);
	}
	
	public void fetchAddCustomer(String name, String cellPhone, String idOwnOrg, String carNo, String carPrefix, String sex, 
			String vin, String brandId, String factoryId, String lineId, String engineId, String mainId, String mengineNumber,
			String factoryCode, String idInsuranceCompany, String insurancepolicyNo, Listener<String> listener, ErrorListener errorListener) {
		Map<String, String> params = NetParamGenerator.getMapParams(APIS.ADD_CUSTOMER, name, cellPhone, idOwnOrg, carNo, carPrefix, sex, vin, brandId, 
				factoryId, lineId, engineId, mainId, mengineNumber, factoryCode, idInsuranceCompany, insurancepolicyNo);
		fetchData(APIS.ADD_CUSTOMER, params, listener, errorListener);
	}
	
	public void fetchBrandList(Listener<String> listener, ErrorListener errorListener) {
		fetchData(APIS.GET_BRAND_LIST, listener, errorListener);
	}
	
	public void fetchBrandByKey(String keyWord, Listener<String> listener, ErrorListener errorListener) {
		Map<String, String> params = NetParamGenerator.getMapParams(APIS.GET_BRAND_BY_KEY, keyWord);
		fetchData(APIS.GET_BRAND_BY_KEY, params, listener, errorListener);
	}
	
	public void fetchStuffCategories(Listener<String> listener, ErrorListener errorListener) {
		fetchData(APIS.GET_STUFF_CAT, listener, errorListener);
	}
	
	public void fetchStuff(String idOwnOrg, String param, Listener<String> listener, ErrorListener errorListener) {
		Map<String, String> params = NetParamGenerator.getMapParams(APIS.QUERY_STUFF, idOwnOrg, param);
		fetchData(APIS.QUERY_STUFF, params, listener, errorListener);
	}
	
	public void fetchAddStuff(String orgId, StuffForAdd stuff, Listener<String> listener, ErrorListener errorListener) {
		fetchData(APIS.ADD_STUFF, stuff, listener, errorListener);
	}
	
	public void fetchOweAccountCustomerList(String idOwnOrg, Listener<String> listener, ErrorListener errorListener) {
		fetchData(APIS.GET_OWE_AMOUNT_CUSTOMER_LIST, listener, errorListener, idOwnOrg);
	}
	
	public void fetchGatherInfo(String idOwnOrg, String idSourceBill, String businessType, Listener<String> listener, ErrorListener errorListener) {
		Map<String, String> params = NetParamGenerator.getMapParams(APIS.GET_GATHER_INFO, idOwnOrg, idSourceBill, businessType);
		fetchData(APIS.GET_GATHER_INFO, params, listener, errorListener);
	}
	
	public void fetchGathering(String idOwnOrg, String businessType, Listener<String> listener, ErrorListener errorListener) {
		fetchData(APIS.GATHERING, listener, errorListener, idOwnOrg, businessType);
	}
	
	public void fetchCustomerGathering(String idOwnOrg, String idCustomer, Listener<String> listener, ErrorListener errorListener) {
		fetchData(APIS.CUSTOMER_GATHERING, listener, errorListener, idOwnOrg, idCustomer);
	}
	
	public void fetchCheckCategory(Listener<String> listener, ErrorListener errorListener) {
		fetchData(APIS.GET_CHECK_CATEGORY, listener, errorListener);
	}

}
