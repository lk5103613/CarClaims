package com.taoqibao.dao;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

import com.taoqibao.po.UserPO;
import com.taoqibao.tools.CONSTANTS;

public class CustomerDao {
	public static JSONObject updatePwd(String uid, String newPwd,String  newPwd2) {
		String url = CONSTANTS.HOST+"/tqb1.0/mlogin/login.json";

		UserPO po = null;
		HttpClient client = new DefaultHttpClient();
		HttpPost request;
		try {
			request = new HttpPost(new URI(url));
			List params = new ArrayList();

			params.add(new BasicNameValuePair("uid", uid));
			params.add(new BasicNameValuePair("pwd", newPwd));
			params.add(new BasicNameValuePair("pwd2",newPwd2));

		 

			request.setEntity(new UrlEncodedFormEntity(params, HTTP.UTF_8));
			HttpResponse response = client.execute(request);
			if (response.getStatusLine().getStatusCode() == 200) {
				HttpEntity entity = response.getEntity();
				if (entity != null) {
					po = new UserPO();
					String out = EntityUtils.toString(entity, "UTF-8");
				 

					JSONObject jo = new JSONObject(out);
					int code = jo.getInt("code");
					if (code == 1) {
						return jo;

					}

					return null;

				}
			}
		} catch (Exception e) {
			e.printStackTrace();

		}
		return null;

	}

}
