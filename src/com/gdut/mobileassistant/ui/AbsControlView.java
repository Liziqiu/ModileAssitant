package com.gdut.mobileassistant.ui;

import com.gdut.Util.Util;
import com.gdut.mobileassistant.service.ControlCenterManager;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AbsoluteLayout;
import android.widget.LinearLayout;

public class AbsControlView extends AbsoluteLayout{
 
	private static final String TAG = "zhiqiang";
	private ControlCenterManager mControlCenterManager;
	

	public AbsControlView(Context context, AttributeSet attrs, int defStyleAttr,
			int defStyleRes) {
		super(context, attrs, defStyleAttr, defStyleRes);
		// TODO Auto-generated constructor stub
	}


	public AbsControlView(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		// TODO Auto-generated constructor stub
	}


	public AbsControlView(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
	}


	public AbsControlView(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}

	public void setControlCenterManager(ControlCenterManager mControlCenterManager) {
		this.mControlCenterManager = mControlCenterManager;
	}
	@Override
	public boolean dispatchKeyEvent(KeyEvent event) {
		Util.log(TAG, "dispatchKeyEvent");
		if(mControlCenterManager != null){
			mControlCenterManager.closeControlCenterViewAnimation();
		}else{
			Util.log(TAG, "mControlCenterManager = null");
		}
		return true;
	}	
	
}
