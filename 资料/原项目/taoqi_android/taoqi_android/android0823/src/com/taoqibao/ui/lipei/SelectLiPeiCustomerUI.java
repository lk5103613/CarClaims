package com.taoqibao.ui.lipei;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.taoqibao.ui.R;

public class SelectLiPeiCustomerUI extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.select_customer);

		this.findViewById(R.id.userLL).setOnClickListener(
				new View.OnClickListener() {

					@Override
					public void onClick(View arg0) {

						Intent intent = new Intent();
						// intent.setClass(act, LiPeiUI.class);
						intent.setClass(SelectLiPeiCustomerUI.this,
								Insurance4CustomerUI.class);

						SelectLiPeiCustomerUI.this.startActivity(intent);

					}
				});

	}

}
