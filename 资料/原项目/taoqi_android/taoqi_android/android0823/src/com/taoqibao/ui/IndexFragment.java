package com.taoqibao.ui;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.taoqibao.ui.index.BaoYangUI;
import com.taoqibao.ui.index.SelectCustomerUI;
import com.taoqibao.ui.index.ShouKuanUI;
import com.taoqibao.ui.index.XiCheUI;
import com.taoqibao.ui.lipei.SelectLiPeiCustomerUI;
import com.taoqibao.ui.repair.SelectRepairCustomerUI;






public class IndexFragment extends BaseFagment {
	@Override
	public void onDestroy() {
	
		super.onDestroy();

	}

	LinearLayout customerLL;//客户
	LinearLayout miaoShaIv;
	
	View view;
	Activity act;
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
		
		
		
		view = inflater.inflate(R.layout.index, null);
		act = this.getActivity();
		 
		 
			view.findViewById(R.id.activity_btn_1).setOnClickListener(new View.OnClickListener() {

				@Override
				public void onClick(View arg0) {
					Intent intent = new Intent();
					intent.setClass(act, SelectCustomerUI.class);
					act.startActivity(intent);

				}
			});
	 
		
		
		
		
		//维修
		view.findViewById(R.id.activity_btn_2).setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent();
				intent.setClass(act, SelectRepairCustomerUI.class);
				act.startActivity(intent);

			}
		});
	
		
		
		
		
		//洗车
		view.findViewById(R.id.activity_btn_3).setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent();
				intent.setClass(act, XiCheUI.class);
				act.startActivity(intent);

			}
		});
		
		//理赔
		view.findViewById(R.id.activity_btn_4).setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent();
				//intent.setClass(act, LiPeiUI.class);
				intent.setClass(act, SelectLiPeiCustomerUI.class);
				
				act.startActivity(intent);

			}
		});
		
		
	 
		miaoShaIv = (LinearLayout) view.findViewById(R.id.activity_btn_5);
		if (miaoShaIv != null) {
			miaoShaIv.setOnClickListener(new View.OnClickListener() {

				@Override
				public void onClick(View arg0) {
					Intent intent = new Intent();
					intent.setClass(act, BaoYangUI.class);
				    act.startActivity(intent);

				}
			});
		}
		
		
		//收款
		view.findViewById(R.id.activity_btn_6).setOnClickListener(new View.OnClickListener() {

				@Override
				public void onClick(View arg0) {
					Intent intent = new Intent();
					intent.setClass(act, ShouKuanUI.class);
				    act.startActivity(intent);

				}
			});
		
		 
		
//		LinearLayout callLL = (LinearLayout) view.findViewById(R.id.activity_btn_7);
//		if (callLL != null) {
//			callLL.setOnClickListener(new View.OnClickListener() {
//
//				@Override
//				public void onClick(View arg0) {
//					//拨打电话
//
//				}
//			});
//		}
		
		//
		
		
		
		
		
		
		return  view;

	}
	 

	 

}
