package com.gdut.mobileassistant.service;

import com.gdut.mobileassistant.ui.ControlCenterView;
import com.gdut.mobileassistant.ui.SlindingHandle;

import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

public class ControlCenterManager {

	private Context context;
	private WindowManager wm;
	private SlindingHandle mSlindingHandle;
	private ControlCenterView mControlCenterView;
	
	public ControlCenterManager(Context c) {
		init(c);
	}

	public void init(Context c){
		context=c;
		mSlindingHandle = new SlindingHandle(c);
		mSlindingHandle.setmControlCenterManager(this);
		mControlCenterView = new ControlCenterView(c);
		mControlCenterView.setmControlCenterManager(this);
		mSlindingHandle.setControlView(mControlCenterView);
		initWindowManager();
		initControlViewMenu();
	}
	private void initWindowManager() {
		wm = (WindowManager) context.getApplicationContext().getSystemService("window");
	}
	
	public void enableControlCenter(boolean enable){
		if(enable){
			wm.addView(mSlindingHandle.gethandle(), mSlindingHandle.getLayoutParams());
		}else{
			wm.removeView(mSlindingHandle.gethandle());
		}
	}
	
	public void addView(View v,WindowManager.LayoutParams p){
		wm.addView(v, p);
	}
	public void remove(View v){
		wm.removeView(v);
	}
	public void initControlViewMenu(){
		Button b = new Button(context);
		b.setText("bb");
		Button c = new Button(context);
		c.setText("cc");
		Button d = new Button(context);
		d.setText("dd");
		mControlCenterView.AddControlViewItem(b);
		mControlCenterView.AddControlViewItem(c);
		mControlCenterView.AddControlViewItem(d);
	}
}
