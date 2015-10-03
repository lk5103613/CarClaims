package com.taoqibao.ui.lipei;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.taoqibao.ui.R;

public class Insurance4CustomerUI extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.insurance4customer);

		this.findViewById(R.id.insuranceListLL).setOnClickListener(
				new View.OnClickListener() {

					@Override
					public void onClick(View arg0) {

						Intent intent = new Intent();
						// intent.setClass(act, LiPeiUI.class);
						intent.setClass(Insurance4CustomerUI.this,
								SelectInsuranceUI.class);

						Insurance4CustomerUI.this.startActivity(intent);

					}
				});

	}

}
