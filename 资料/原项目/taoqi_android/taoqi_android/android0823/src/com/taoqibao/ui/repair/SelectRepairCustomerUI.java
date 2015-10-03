package com.taoqibao.ui.repair;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.taoqibao.ui.R;
import com.taoqibao.ui.lipei.Insurance4CustomerUI;

public class SelectRepairCustomerUI extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.select_customer);

		this.findViewById(R.id.userLL).setOnClickListener(
				new View.OnClickListener() {

					@Override
					public void onClick(View arg0) {

						Intent intent = new Intent();
						
						intent.setClass(SelectRepairCustomerUI.this,
								RepairTab0.class);

						SelectRepairCustomerUI.this.startActivity(intent);

					}
				});

	}

}
