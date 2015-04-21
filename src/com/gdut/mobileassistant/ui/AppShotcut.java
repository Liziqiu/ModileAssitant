package com.gdut.mobileassistant.ui;

import com.gdut.mobileassistant.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

public class AppShotcut extends absControlItemView{

	public AppShotcut(Context context) {
		super(context);
	}

	@Override
	protected View CreateItemView() {
		return LayoutInflater.from(this.context).inflate(R.layout.app_shoutcut, null);
	}
}
