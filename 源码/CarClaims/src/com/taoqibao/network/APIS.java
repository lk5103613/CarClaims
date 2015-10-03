package com.taoqibao.network;

public class APIS {
	
	public static final String BASE_URL = "http://121.40.28.92:8080";
	public static final String BASE_URL2 = "http://www.taoqiball.com";
	
	public static final String LOGIN = BASE_URL + "/tqb1.0/mlogin/login.action?code=%1&username=%2&password=%3//��½";
	
	public static final String GET_PROVIENCE_LIST = BASE_URL2 + "/tqb1.0/mobileCenterConstant/getProvinceList.action//��ȡʡ���б�";
	public static final String GET_CITY_LIST = BASE_URL2 + "/tqb1.0/mobileCenterConstant/%1/getChildrenList.action//��ȡ�����б�";
	
	// Car
	public static final String GET_CAR_PRE_FIX = BASE_URL2 + "/tqb1.0/mobileCenterConstant/getCarPreFix.action//��ȡ���ƺ�ǰ׺";
	public static final String GET_CAR_BRAND = BASE_URL2 + "/tqb1.0/mobileCenterConstant/getCarBrandMap.action//��ȡ����Ʒ��";
	public static final String GET_CAR_COMMON_BRAND = BASE_URL2 + "/tqb1.0/mobileCenterConstant/getCarCommonBrandList.action//��ȡ����Ʒ��";
	
	public static final String GET_CAR_FAC_BY_ID = BASE_URL2 + "/tqb1.0/mobileCenterConstant/%1/getCarFactoryLineByBrandId.action//����id��ȡ����";
	public static final String GET_CAR_ENGINE_BY_ID = BASE_URL2 + "/tqb1.0/mobileCenterConstant/%1/getCarEngineByLineId.action//����id��ȡ����";
	public static final String GET_CAR_MAIN_BY_ID = BASE_URL2 + "/tqb1.0/mobileCenterConstant/%1/%2/%3/%4/getCarMainByCondition.action//����id��ȡ������Ҫ��Ϣ";
	
	// ����
	public static final String GET_INSURANCE_LIST = BASE_URL2 + "/tqb1.0/mobileInsuranceCompany/getInsuranceCompanyList.action?idOwnOrg=%1//��ȡ���չ�˾�б�";
	public static final String ADD_INSURANCE = BASE_URL2 + "/tqb1.0/mobileInsuranceCompany/addInsuranceCompany.action?name=%1&province=%2&city=%3&area=%4&street=%5"
			+ "address=%6&detailAddress=%7&contacts=%8&contactMobile=%9&contactTelephone=%10&fax=%11&isDel=%12&idOwnOrg=%13//��ӱ���";
	
	// �ͻ�
	public static final String GET_CUSTOMER_BY_KEY = BASE_URL2 + "/tqb1.0/mobileCustomerCar/getCustomerCarList.action?idOwnOrg=%1&keyWord=%2//��ѯ�ͻ���Ϣ";
	public static final String ADD_CUSTOMER = BASE_URL2 + "/tqb1.0/mobileCustomerCar/addCustomerCar.action?name=%1&cellPhone=%2&idOwnOrg=%3&carNo=%4&carPrefix=%5&"
			+ "sex=%6&vin=%7&brandId=%8&factoryId=%9&lineId=%10&engineId=%11&mainId=%12&mengineNumber=%13&factoryCode=%14&idInsuranceCompany=%15&insurancepolicyNo=%16//��ӿͻ�";
	
	public static final String GET_BRAND_LIST = BASE_URL2 + "/tqb1.0/mobileCenterConstant/getBrandList.action";

}
