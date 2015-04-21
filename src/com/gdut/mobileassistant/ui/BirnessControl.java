package com.gdut.mobileassistant.ui;

import com.gdut.mobileassistant.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

public class BirnessControl extends absControlItemView{

	public BirnessControl(Context context) {
		super(context);
	}

	@Override
	protected View CreateItemView() {
		return LayoutInflater.from(this.context).inflate(R.layout.briness_control, null);
	}

}
