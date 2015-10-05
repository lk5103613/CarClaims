package com.taoqibao.adapter;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.taoqibao.carclaims.R;
import com.taoqibao.entity.Insurance;

public class InsuranceListAdapter extends BaseAdapter {
	
	private LayoutInflater mInflater;
	private List<Insurance> mInsurances;
	
	public InsuranceListAdapter(Context context, List<Insurance> insurances) {
		mInflater = LayoutInflater.from(context);
		this.mInsurances = insurances;
	}

	@Override
	public int getCount() {
		return mInsurances.size();
	}

	@Override
	public Insurance getItem(int position) {
		return mInsurances.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder vh;
		Insurance insurance = mInsurances.get(position);
		if(convertView == null) {
			convertView = mInflater.inflate(R.layout.item_insurance, parent, false);
			vh = new ViewHolder(convertView);
			convertView.setTag(vh);
		} else {
			vh = (ViewHolder) convertView.getTag();
		}
		vh.sName.setText(insurance.name);
		return convertView;
	}
	
	public void update(List<Insurance> insurances) {
		this.mInsurances = insurances;
		notifyDataSetChanged();
	}
	
	public class ViewHolder {
		public TextView sName;
		
		public ViewHolder(View convertView) {
			sName = (TextView) convertView.findViewById(R.id.insurance_name);
		}
	}

}
