package com.taoqibao.ui.repair;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.taoqibao.ui.R;



public class RepairTab0 extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.repair_tab0);
		
		//
		
		this.findViewById(R.id.searchLL).setOnClickListener(
				new View.OnClickListener() {

					@Override
					public void onClick(View arg0) {

						Intent intent = new Intent();
						
						intent.setClass(RepairTab0.this,
								GongDanUI.class);

						RepairTab0.this.startActivity(intent);

					}
				});
		
		
	}

}
