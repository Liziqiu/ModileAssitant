package com.gdut.mobileassistant.ui;

import com.gdut.Util.Util;
import com.gdut.mobileassistant.AssistantApp;
import com.gdut.mobileassistant.R;
import com.gdut.mobileassistant.service.ControlCenterManager;

import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.View.OnTouchListener;

public class SlindingHandle implements OnTouchListener{

	private final String TAG="zhiqiang";
	
	private Context context;
	private View handle;
	private AssistantApp app;
	private WindowManager.LayoutParams  wmParams=null;
	
	private ControlCenterView mControlCenterView;
	
	private ControlCenterManager mControlCenterManager;
	
	public SlindingHandle(Context context) {
		super();
		this.context = context;
		app = (AssistantApp) context.getApplicationContext();
		handle = CreateHandle();
		handle.setOnTouchListener(this);
		initWindowManager();
	}

	private void initWindowManager() {
		wmParams =new WindowManager.LayoutParams();
		wmParams.type=WindowManager.LayoutParams.TYPE_STATUS_BAR_OVERLAY;
		//wmParams.type=WindowManager.LayoutParams.TYPE_APPLICATION ;
		wmParams.flags|=8;
		wmParams.gravity = Gravity.LEFT | Gravity.TOP;
		wmParams.x=0;
		wmParams.y=1920;
		wmParams.width=WindowManager.LayoutParams.WRAP_CONTENT;
		wmParams.height=WindowManager.LayoutParams.WRAP_CONTENT;
		wmParams.format=1;
		
	}
	public WindowManager.LayoutParams getLayoutParams(){
		return wmParams;
	}
	public void setControlView(ControlCenterView c){
		mControlCenterView=c;
	}
	public View gethandle(){
		if(handle == null){
			handle = CreateHandle();
		}
		return handle;
	}

	private View CreateHandle() {
		return LayoutInflater.from(context).inflate(R.layout.slinding_handle, null);
	}


	@Override
	public boolean onTouch(View v, MotionEvent ev) {
		switch(ev.getAction()){
		case MotionEvent.ACTION_DOWN:
			Util.log(TAG, "SlindingHandle ACTION_DOWN");
			if(app.isIsControlCenterOpen()){
				
			}else{
				mControlCenterManager.addView(mControlCenterView.getControlView(), mControlCenterView.getLayoutParams());
			}
			break;
		case MotionEvent.ACTION_MOVE:
			//Util.log(TAG, "SlindingHandle ACTION_MOVE");
			mControlCenterView.moveTouch((int) ev.getRawY());
			break;
		case MotionEvent.ACTION_UP:
			Util.log(TAG, "SlindingHandle ACTION_UP");
			if(IsNeedOpen((int) ev.getRawY())){
				mControlCenterView.ShowWhileControlView(true);
				app.setIsControlCenterOpen(true);
			}else{
				mControlCenterView.ShowWhileControlView(false);
				app.setIsControlCenterOpen(false);
			}
			break;
		}
		return true;
	}

	private boolean IsNeedOpen(int rawY) {
		if(rawY>1700){
			return false;
		}
		return true;
	}

	public void setmControlCenterManager(ControlCenterManager mControlCenterManager) {
		this.mControlCenterManager = mControlCenterManager;
	}
	
}
