package com.taoqibao.adapter;

import com.taoqibao.fragments.OweHistoryFragment;
import com.taoqibao.fragments.RepairFragment;
import com.taoqibao.fragments.RepairHistoryFragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class RepairPagerAdapter extends FragmentPagerAdapter {
	
	private RepairFragment mRepairFragment = new RepairFragment();
	private RepairHistoryFragment mRepairHistoryFragment = new RepairHistoryFragment();
	private OweHistoryFragment mOweHistoryFragment = new OweHistoryFragment();
	
	private Fragment[] mFragments = new Fragment[]{mRepairFragment, mRepairHistoryFragment, mOweHistoryFragment};

	public RepairPagerAdapter(FragmentManager fm) {
		super(fm);
	}

	@Override
	public Fragment getItem(int index) {
		return mFragments[index];
	}

	@Override
	public int getCount() {
		return mFragments.length;
	}

}
