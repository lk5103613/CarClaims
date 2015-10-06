package com.taoqibao.carclaims;

import java.util.Collections;
import java.util.List;
import java.util.Locale;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.Response.Listener;
import com.taoqibao.adapter.CustomerListAdapter;
import com.taoqibao.entity.Customer;
import com.taoqibao.entity.CustomerComparator;
import com.taoqibao.network.GsonConverter;
import com.taoqibao.widget.sortlistview.CharacterParser;
import com.taoqibao.widget.sortlistview.SideBar;
import com.taoqibao.widget.sortlistview.SideBar.OnTouchingLetterChangedListener;
import com.taoqibao.widget.sortlistview.SortModel;

public class SelectCustomerActivity extends BaseActivity {
	
	public static final String TYPE = "type";
	
	private String mKeyword;
	
	private ListView mCustomerList;
	private CustomerComparator mCustomerComparator;
	private CustomerListAdapter mAdapter;
	private CharacterParser mCharacterParser;
	private SideBar mSideBar;
	private TextView mLblDialog;
	private List<Customer> mCustomers;
	private int mType = -1;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_select_customer);
		
		initView();
		
		updateList();
	}
	
	private void initView() {
		mKeyword = "";
		mType = getIntent().getIntExtra(TYPE, -1);
		mCharacterParser = CharacterParser.getInstance();
		mCustomerComparator = new CustomerComparator();
		mCustomerList = (ListView) findViewById(R.id.customer_list);
		mSideBar = (SideBar) findViewById(R.id.sidrbar);
		mLblDialog = (TextView) findViewById(R.id.dialog);
		mSideBar.setTextView(mLblDialog);
		mSideBar.setOnTouchingLetterChangedListener(new OnTouchingLetterChangedListener() {
			@Override
			public void onTouchingLetterChanged(String s) {
				int position = mAdapter.getPositionForSection(s.charAt(0));
				if(position != -1) {
					mCustomerList.setSelection(position);
				}
			}
		});
		mCustomerList.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				Intent intent = null;
				switch (mType) {
				case 1:
					break;
				case 2:
					intent = new Intent(mContext, RepairActivity.class);
					break;
				case 3:
					intent = new Intent(mContext, ClaimsActivity.class);
					break;
				default:
					return;
				}
				if(intent != null)
					startActivity(intent);
			}
		});
	}
	
	private SortModel filledData(String data) {
		SortModel model = new SortModel();
		model.setName(data);
		String pinyin = mCharacterParser.getSelling(data);
		String sortString = pinyin.substring(0, 1).toUpperCase(Locale.getDefault());
		if(sortString.matches("[A-Z]")){
			model.setSortLetters(sortString.toUpperCase(Locale.getDefault()));
		}else{
			model.setSortLetters("#");
		}
		return model;
	}
	
	private void sortCustomers() {
		for(Customer customer : mCustomers) {
			SortModel sortModel = filledData(customer.name);
			customer.sortModel = sortModel;
		}
		Collections.sort(mCustomers, mCustomerComparator);
	}
	
	private void updateList() {
		mDataFetcher.fetchCustomerByKey(mLoginUser.idOwnOrg, mKeyword, new Listener<String>() {
			@Override
			public void onResponse(String response) {
				mCustomers = GsonConverter.toCustomerList(response);
				sortCustomers();
				if(mAdapter == null) {
					mAdapter = new CustomerListAdapter(mContext, mCustomers);
					mCustomerList.setAdapter(mAdapter);
				} else {
					mAdapter.update(mCustomers);
				}
			}
		}, mErrorListener);
	}
	
	public void addCustomer(View v) {
		Intent intent = new Intent(mContext, AddCustomerActivity.class);
		startActivity(intent);
	}

}
