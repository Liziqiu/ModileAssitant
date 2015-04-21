package com.gdut.mobileassistant.ui;

import android.content.Context;
import android.view.View;

public abstract class absControlItemView {

	protected Context context;
	protected View mView;
	public absControlItemView(Context context) {
		super();
		this.context = context;
		mView = CreateItemView();
	}
	protected abstract View CreateItemView();
	
	public View getmView() {
		return mView;
	}
	
	
}
