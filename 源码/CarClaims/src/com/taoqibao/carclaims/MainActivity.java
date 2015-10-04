package com.taoqibao.carclaims;

import android.os.Bundle;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;

import com.taoqibao.adapter.IndexPagerAdapter;
import com.taoqibao.widget.HackyViewPager;

public class MainActivity extends BaseActivity implements OnClickListener {
	
	private HackyViewPager mViewPager;
	private IndexPagerAdapter mPagerAdapter;
	private ViewGroup mTab1, mTab2, mTab3, mTab4;
	private ViewGroup[] mTabs;
	private int mCurrentIndex = -1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		initView();
	}
	
	private void initView() {
		mViewPager = (HackyViewPager) findViewById(R.id.viewpager);
		mPagerAdapter = new IndexPagerAdapter(getSupportFragmentManager());
		mViewPager.setAdapter(mPagerAdapter);
		mTab1 = (ViewGroup) findViewById(R.id.tab1);
		mTab2 = (ViewGroup) findViewById(R.id.tab2);
		mTab3 = (ViewGroup) findViewById(R.id.tab3);
		mTab4 = (ViewGroup) findViewById(R.id.tab4);
		mTab1.setOnClickListener(this);
		mTab2.setOnClickListener(this);
		mTab3.setOnClickListener(this);
		mTab4.setOnClickListener(this);
		mTabs = new ViewGroup[]{mTab1, mTab2, mTab3, mTab4};
		mViewPager.addOnPageChangeListener(new OnPageChangeListener() {
			
			@Override
			public void onPageSelected(int index) {
				if(index == mCurrentIndex)
					return;
			}
			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
			}
			@Override
			public void onPageScrollStateChanged(int arg0) {
			}
		});
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.tab1:
			if(mCurrentIndex == 0)
				return;
			mCurrentIndex = 0;
			break;
		case R.id.tab2:
			if(mCurrentIndex == 1)
				return;
			mCurrentIndex = 1;
			break;
		case R.id.tab3:
			if(mCurrentIndex == 2)
				return;
			mCurrentIndex = 2;
			break;
		case R.id.tab4:
			if(mCurrentIndex == 3)
				return;
			mCurrentIndex = 3;
			break;
		default:
			break;
		}
		mViewPager.setCurrentItem(mCurrentIndex);
	}
	
}
