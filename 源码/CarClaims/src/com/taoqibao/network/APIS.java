package com.taoqibao.network;

public class APIS {
	
	public static final String BASE_URL = "http://121.40.28.92:8080";
	public static final String BASE_URL2 = "http://www.taoqiball.com";
	
	public static final String LOGIN = BASE_URL + "/tqb1.0/mlogin/login.action?code=%1&username=%2&password=%3//登陆";
	
	public static final String GET_PROVIENCE_LIST = BASE_URL2 + "/tqb1.0/mobileCenterConstant/getProvinceList.action//获取省份列表";
	public static final String GET_CITY_LIST = BASE_URL2 + "/tqb1.0/mobileCenterConstant/%1/getChildrenList.action//获取城市列表";
	
	// Car
	public static final String GET_CAR_PRE_FIX = BASE_URL2 + "/tqb1.0/mobileCenterConstant/getCarPreFix.action//获取车牌号前缀";
	public static final String GET_CAR_BRAND = BASE_URL2 + "/tqb1.0/mobileCenterConstant/getCarBrandMap.action//获取车辆品牌";
	public static final String GET_CAR_COMMON_BRAND = BASE_URL2 + "/tqb1.0/mobileCenterConstant/getCarCommonBrandList.action//获取常用品牌";
	
	public static final String GET_CAR_FAC_BY_ID = BASE_URL2 + "/tqb1.0/mobileCenterConstant/%1/getCarFactoryLineByBrandId.action//根据id获取分类";
	public static final String GET_CAR_ENGINE_BY_ID = BASE_URL2 + "/tqb1.0/mobileCenterConstant/%1/getCarEngineByLineId.action//根据id获取排量";
	public static final String GET_CAR_MAIN_BY_ID = BASE_URL2 + "/tqb1.0/mobileCenterConstant/%1/%2/%3/%4/getCarMainByCondition.action//根据id获取车辆主要信息";
	
	// 保险
	public static final String GET_INSURANCE_LIST = BASE_URL2 + "/tqb1.0/mobileInsuranceCompany/getInsuranceCompanyList.action?idOwnOrg=%1//获取保险公司列表";
	public static final String ADD_INSURANCE = BASE_URL2 + "/tqb1.0/mobileInsuranceCompany/addInsuranceCompany.action?name=%1&province=%2&city=%3&area=%4&street=%5"
			+ "address=%6&detailAddress=%7&contacts=%8&contactMobile=%9&contactTelephone=%10&fax=%11&isDel=%12&idOwnOrg=%13//添加保险";
	
	// 客户
	public static final String GET_CUSTOMER_BY_KEY = BASE_URL2 + "/tqb1.0/mobileCustomerCar/getCustomerCarList.action?idOwnOrg=%1&keyWord=%2//查询客户信息";
	public static final String ADD_CUSTOMER = BASE_URL2 + "/tqb1.0/mobileCustomerCar/addCustomerCar.action?name=%1&cellPhone=%2&idOwnOrg=%3&carNo=%4&carPrefix=%5&"
			+ "sex=%6&vin=%7&brandId=%8&factoryId=%9&lineId=%10&engineId=%11&mainId=%12&mengineNumber=%13&factoryCode=%14&idInsuranceCompany=%15&insurancepolicyNo=%16//添加客户";
	
	public static final String GET_BRAND_LIST = BASE_URL2 + "/tqb1.0/mobileCenterConstant/getBrandList.action//获取所有材料品牌列表";
	public static final String GET_BRAND_BY_KEY = BASE_URL2 + "/tqb1.0/mobileCenterConstant/getBrandsByKeyWord.action?keyWord=%1//根据关键字查询材料品牌";
	
	public static final String GET_STUFF_CAT = BASE_URL2 + "/tqb1.0/mobileCenterConstant/getStuffCategories.action//获得材料种类";
	public static final String QUERY_STUFF = BASE_URL2 + "/tqb1.0/mobileStuff/queryStuffInfo.action?idOwnOrg=%1&param=%2//查询材料";
	public static final String ADD_STUFF = BASE_URL2 + "/tqb1.0/mobileStuff/addStuff.action?orgnaizationId=%1&tmPartInfo=%2";
	
	public static final String GET_OWE_AMOUNT_CUSTOMER_LIST = BASE_URL2 + "/tqb1.0/mobilePayment/getOweAmountCustomerList.action?idOwnOrg=%1";
	public static final String GET_GATHER_INFO = BASE_URL2 + "/tqb1.0/mobilePayment/getGatheringInfo.action?idOwnOrg=%1&idSourceBill=%2&businessType=%3";
	public static final String GATHERING = BASE_URL2 + "/tqb1.0/mobilePayment/gathering.action?idOwnOrg=%1&businessType=%2";
	public static final String CUSTOMER_GATHERING = BASE_URL2 + "/tqb1.0/mobilePayment/customerGathering.action?idOwnOrg=%1&idCustomer=%2";
	
	public static final String GET_CHECK_CATEGORY = BASE_URL2 + "/tqb1.0/mobileCarCheck/getCheckCategory.action";
	

}
