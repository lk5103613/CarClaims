package com.taoqibao.carclaims;

import android.os.Bundle;

import com.taoqibao.adapter.RepairPagerAdapter;
import com.taoqibao.widget.HackyViewPager;

public class RepairActivity extends BaseActivity {
	
	private HackyViewPager mViewpager;
	private RepairPagerAdapter mPagerAdapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_repair);
		initView();
	}
	
	private void initView() {
		mViewpager = (HackyViewPager) findViewById(R.id.tab_viewpager);
//		mViewpager.setLocked(true);
		mPagerAdapter = new RepairPagerAdapter(getSupportFragmentManager());
		mViewpager.setAdapter(mPagerAdapter);
	}

}
