package com.gdut.mobileassistant.service;

import com.gdut.Util.Util;
import com.gdut.mobileassistant.AssistantApp;
import com.gdut.mobileassistant.ui.AppShotcut;
import com.gdut.mobileassistant.ui.BirnessControl;
import com.gdut.mobileassistant.ui.ControlCenterView;
import com.gdut.mobileassistant.ui.MusicPlayControl;
import com.gdut.mobileassistant.ui.ShotcutPanel;
import com.gdut.mobileassistant.ui.SlindingHandle;

import android.content.Context;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

public class ControlCenterManager {

	private static final String TAG = "zhiqiang";
	private Context context;
	private WindowManager wm;
	private SlindingHandle mSlindingHandle;
	private ControlCenterView mControlCenterView;
	private AssistantApp app;
	
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
		app = (AssistantApp) context.getApplicationContext();
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
	
	public void closeControlCenterViewAnimation(){
		Util.log(TAG, "closeControlCenterViewAnimation");
		mControlCenterView.ShowWhileControlView(false);
		app.setIsControlCenterOpen(false);
	}
	
	public void initControlViewMenu(){
		mControlCenterView.AddControlViewItem(new ShotcutPanel(context).getmView());
		mControlCenterView.AddControlViewItem(new BirnessControl(context).getmView());
		mControlCenterView.AddControlViewItem(new MusicPlayControl(context).getmView());
		mControlCenterView.AddControlViewItem(new AppShotcut(context).getmView());
	}

}
