package com.gdut.mobileassistant.ui;

import com.gdut.Util.Util;
import com.gdut.mobileassistant.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

public class ShotcutPanel{

	private Context context;
	private View PanelView;
	private ImageView wifi;

	public ShotcutPanel(Context context) {
		this.context = context;
		PanelView = this.CreatePanelView();
	}
	
	private View CreatePanelView(){
		return LayoutInflater.from(context).inflate(R.layout.shotcut_panel, null);
	}

	public View getPanelView() {
		return PanelView;
	}
	
	private void iniItemById(){
		wifi = (ImageView) PanelView.findViewById(R.id.wifi);
	}
	
}
