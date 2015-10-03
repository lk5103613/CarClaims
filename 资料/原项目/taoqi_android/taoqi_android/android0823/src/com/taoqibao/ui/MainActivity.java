package com.taoqibao.ui;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;



import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class MainActivity extends FragmentActivity {
private FragmentManager fragmentManager;
	
	private Map<String, Fragment> fragmentMap = new HashMap();
	
	private LinearLayout tab1,tab2,tab3,tab4;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_activity);

		tab1 = (LinearLayout) findViewById(R.id.tab1);
		tab2 = (LinearLayout) findViewById(R.id.tab2);
		tab3 = (LinearLayout) findViewById(R.id.tab3);
		tab4 = (LinearLayout) findViewById(R.id.tab4);
	 
		
		tab1.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				setTabSelection(0);
			}
		});
		tab2.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				setTabSelection(1);
			}
		});
		tab3.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				setTabSelection(2);
			}
		});
		tab4.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				setTabSelection(3);
			}
		});
	
		
		fragmentManager = getSupportFragmentManager();
		setTabSelection(0);
	}
	
	private void setTabSelection(int index) {
		tab1.setSelected(false);
		tab2.setSelected(false);
		tab3.setSelected(false);
		tab4.setSelected(false);
	 
		
		FragmentTransaction transaction = fragmentManager.beginTransaction();
		hiddenFragment(transaction);
		
		Fragment fragment = null;
		switch (index) {
		case 0:
			fragment = new IndexFragment();
			tab1.setSelected(true);
			break;
		case 1:
			fragment = new YDJCFragment();
			tab2.setSelected(true);
			break;
		case 2:
			fragment = new WorkKanBanFragment();
			tab3.setSelected(true);
			break;
		case 3:
			fragment = new ReportFragment();
			tab4.setSelected(true);
			break;
		
		}
		transaction.add(R.id.frameLayout, fragment);
		fragmentMap.put(String.valueOf(index), fragment);
		transaction.commit();
	}
	
	private void hiddenFragment(FragmentTransaction transaction) {
		Iterator<Entry<String, Fragment>> iterator = fragmentMap.entrySet()
				.iterator();
		while (iterator.hasNext()) {
			Entry<String, Fragment> entry = iterator.next();
			transaction.hide(entry.getValue());
		}
	}
	
	
	

}
