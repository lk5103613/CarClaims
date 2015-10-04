package com.taoqibao.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.taoqibao.fragments.IndexFragment;
import com.taoqibao.fragments.ReportFragment;
import com.taoqibao.fragments.TakeMobileFragment;
import com.taoqibao.fragments.WorkplateFragment;

public class IndexPagerAdapter extends FragmentPagerAdapter {

	private IndexFragment mIndexFragment = new IndexFragment();
	private TakeMobileFragment mTakeMobileFragment = new TakeMobileFragment();
	private WorkplateFragment mWorkPlateFragment = new WorkplateFragment();
	private ReportFragment mReportFragment = new ReportFragment();

	private Fragment[] mFragments = new Fragment[] { mIndexFragment,
			mTakeMobileFragment, mWorkPlateFragment, mReportFragment };

	public IndexPagerAdapter(FragmentManager fm) {
		super(fm);
	}

	@Override
	public int getCount() {
		return mFragments.length;
	}

	@Override
	public Fragment getItem(int position) {
		return mFragments[position];
	}

}
