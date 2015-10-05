package com.taoqibao.adapter;

import java.util.List;
import java.util.Locale;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.like.likeutils.network.NetworkUtil;
import com.taoqibao.carclaims.R;
import com.taoqibao.entity.CarBrand;
import com.taoqibao.widget.sortlistview.SortModel;

public class CarBrandListAdapter extends BaseAdapter {
	
	private List<CarBrand> mBrands;
	private LayoutInflater mInflater;
	private ImageLoader mImgLoader;
	
	public CarBrandListAdapter(Context context, List<CarBrand> brands) {
		mInflater = LayoutInflater.from(context);
		mBrands = brands;
		mImgLoader = NetworkUtil.getInstance(context).getImageLoader();
	}

	@Override
	public int getCount() {
		return mBrands.size();
	}

	@Override
	public CarBrand getItem(int position) {
		return mBrands.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder vh;
		CarBrand brand = getItem(position);
		final SortModel content = brand.sortModel;
		if(convertView == null) {
			convertView = mInflater.inflate(R.layout.item_car_list, parent, false);
			vh = new ViewHolder(convertView);
			convertView.setTag(vh);
		} else {
			vh = (ViewHolder) convertView.getTag();
		}
		mImgLoader.get(brand.carBrandImgDomainUrl, ImageLoader.getImageListener(vh.sImgLogo, R.color.white, R.color.white));
		vh.sLblBrandName.setText(brand.brandName);
		int section = getSectionForPosition(position);
		if(position == getPositionForSection(section)){
			vh.sLblCatalog.setVisibility(View.VISIBLE);
			vh.sLblCatalog.setText(content.getSortLetters());
		}else{
			vh.sLblCatalog.setVisibility(View.GONE);
		}
		return convertView;
	}
	
	public void update(List<CarBrand> brands) {
		this.mBrands = brands;
		notifyDataSetChanged();
	}
	
	public int getSectionForPosition(int position) {
		return mBrands.get(position).sortModel.getSortLetters().charAt(0);
	}
	
	public int getPositionForSection(int section) {
		for (int i = 0; i < getCount(); i++) {
			String sortStr = mBrands.get(i).sortModel.getSortLetters();
			char firstChar = sortStr.toUpperCase(Locale.getDefault()).charAt(0);
			if (firstChar == section) {
				return i;
			}
		}
		return -1;
	}
	
	public class ViewHolder {
		public TextView sLblCatalog;
		public ImageView sImgLogo;
		public TextView sLblBrandName;
		
		public ViewHolder(View convertView) {
			this.sLblCatalog = (TextView) convertView.findViewById(R.id.catalog);
			this.sImgLogo = (ImageView) convertView.findViewById(R.id.logo);
			this.sLblBrandName = (TextView) convertView.findViewById(R.id.brand_name);
		}
	}

}
