package com.gdut.mobileassistant.ui;

import com.gdut.Util.Util;
import com.gdut.mobileassistant.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

public class ShotcutPanel extends absControlItemView{
	
	public ShotcutPanel(Context context) {
		super(context);
		CanfigPanelView();
	}

	private void CanfigPanelView() {
		mView.getBackground().setAlpha(100);
		
	}
	

	@Override
	protected View CreateItemView() {
		// TODO Auto-generated method stub
		return LayoutInflater.from(context).inflate(R.layout.shotcut_panel, null);
	}
	
}
