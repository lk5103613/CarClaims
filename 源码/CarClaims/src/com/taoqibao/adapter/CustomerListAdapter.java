package com.taoqibao.adapter;

import java.util.List;
import java.util.Locale;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.taoqibao.carclaims.R;
import com.taoqibao.entity.Customer;
import com.taoqibao.widget.sortlistview.SortModel;

public class CustomerListAdapter extends BaseAdapter {
	
	private LayoutInflater mInflater;
	private List<Customer> mCustomers;
	
	public CustomerListAdapter(Context context, List<Customer> customers) {
		mInflater = LayoutInflater.from(context);
		this.mCustomers = customers;
	}

	@Override
	public int getCount() {
		return mCustomers.size();
	}

	@Override
	public Object getItem(int position) {
		return mCustomers.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		Customer customer = mCustomers.get(position);
		final SortModel content = customer.sortModel;
		ViewHolder vh;
		if(convertView == null) {
			convertView = mInflater.inflate(R.layout.item_customer_list, parent, false);
			vh = new ViewHolder(convertView);
			convertView.setTag(vh);
		} else {
			vh = (ViewHolder) convertView.getTag();
		}
		int section = getSectionForPosition(position);
		if(position == getPositionForSection(section)){
			vh.sCatalog.setVisibility(View.VISIBLE);
			vh.sCatalog.setText(content.getSortLetters());
		}else{
			vh.sCatalog.setVisibility(View.GONE);
		}
		vh.sLblName.setText(customer.name);
		vh.sLblCarNo.setText(customer.carNo);
		vh.sLblPhoneNum.setText(customer.cellPhone);
		return convertView;
	}
	
	public int getSectionForPosition(int position) {
		return mCustomers.get(position).sortModel.getSortLetters().charAt(0);
	}
	
	public int getPositionForSection(int section) {
		for (int i = 0; i < getCount(); i++) {
			String sortStr = mCustomers.get(i).sortModel.getSortLetters();
			char firstChar = sortStr.toUpperCase(Locale.getDefault()).charAt(0);
			if (firstChar == section) {
				return i;
			}
		}
		return -1;
	}
	
	public void update(List<Customer> customers) {
		this.mCustomers = customers;
		notifyDataSetChanged();
	}
	
	public class ViewHolder {
		public TextView sCatalog;
		public TextView sLblName;
		public TextView sLblCarNo;
		public TextView sLblPhoneNum;
		public View sDivider;
		
		public ViewHolder(View v) {
			sCatalog = (TextView) v.findViewById(R.id.catalog);
			sLblName = (TextView) v.findViewById(R.id.lbl_name);
			sLblCarNo = (TextView) v.findViewById(R.id.lbl_car_no);
			sLblPhoneNum = (TextView) v.findViewById(R.id.lbl_phone_num);
			sDivider = (View) v.findViewById(R.id.divider);
		}
	}

}
