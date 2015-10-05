package com.taoqibao.carclaims;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class AddInsuranceActivity extends BaseActivity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_add_insurance);
	}
	
	public void selectArea(View v) {
		Intent intent = new Intent(mContext, SelectLocationActivity.class);
		startActivity(intent);
	}

}
