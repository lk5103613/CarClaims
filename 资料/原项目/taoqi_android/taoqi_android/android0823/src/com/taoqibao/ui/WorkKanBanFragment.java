package com.taoqibao.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class WorkKanBanFragment extends BaseFagment {
	
	View view;
	Activity act;
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
		
		
		
		view = inflater.inflate(R.layout.workkanban_fragment, null);
		act = this.getActivity();
		
		return  view;
		
	}

}
