package com.taoqibao.network;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

import com.google.gson.reflect.TypeToken;
import com.like.likeutils.network.GsonUtil;
import com.taoqibao.entity.AreaInfo;
import com.taoqibao.entity.Brand;
import com.taoqibao.entity.CarBrand;
import com.taoqibao.entity.CarEngine;
import com.taoqibao.entity.CarLine;
import com.taoqibao.entity.CarMain;
import com.taoqibao.entity.CommonResult;
import com.taoqibao.entity.Customer;
import com.taoqibao.entity.Insurance;
import com.taoqibao.entity.LoginResult;
import com.taoqibao.entity.Stuff;
import com.taoqibao.entity.StuffCategories;

public class GsonConverter {
	
	public static CommonResult<LoginResult> toLoginResult(String response) {
		Type type = new TypeToken<CommonResult<LoginResult>>(){}.getType();
		return GsonUtil.gson.fromJson(response, type);
	}
	
	public static List<AreaInfo> toAreaList(String response) {
		Type type = new TypeToken<List<AreaInfo>>(){}.getType();
		List<AreaInfo> proviences = GsonUtil.gson.fromJson(response, type);
		return proviences;
	}
	
	public static List<String> toCarPreFix(String response) {
		Type type = new TypeToken<List<String>>(){}.getType();
		return GsonUtil.gson.fromJson(response, type);
	}
	
	public static Map<String, List<CarBrand>> toBrandMap(String response) {
		Type type = new TypeToken<Map<String, List<CarBrand>>>(){}.getType();
		return GsonUtil.gson.fromJson(response, type);
	}
	
	public static Map<String, CarLine> toCarLineMap(String response) {
		Type type = new TypeToken<Map<String, CarLine>>(){}.getType();
		return GsonUtil.gson.fromJson(response, type);
	}
	
	public static List<CarEngine> toCarEngineList(String response) {
		Type type = new TypeToken<List<CarEngine>>(){}.getType();
		return GsonUtil.gson.fromJson(response, type);
	}
	
	public static List<CarMain> toCarMainList(String response) {
		Type type = new TypeToken<List<CarMain>>(){}.getType();
		return GsonUtil.gson.fromJson(response, type);
	}
	
	public static Map<String, Brand> toBrandList(String response) {
		Type type = new TypeToken<Map<String, Brand>>(){}.getType();
		return GsonUtil.gson.fromJson(response, type);
	}
	
	public static List<Insurance> toInsuranceList(String response) {
		Type type = new TypeToken<List<Insurance>>(){}.getType();
		return GsonUtil.gson.fromJson(response, type);
	}
	
	public static StuffCategories toStuffCategories(String response) {
		return GsonUtil.gson.fromJson(response, StuffCategories.class);
	}
	
	public static List<Stuff> toStuffList(String response) {
		Type type = new TypeToken<List<Stuff>>(){}.getType();
		return GsonUtil.gson.fromJson(response, type);
	}
	
	public static List<Customer> toCustomerList(String response) {
		Type type = new TypeToken<List<Customer>>(){}.getType();
		return GsonUtil.gson.fromJson(response, type);
	}

}
