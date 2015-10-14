package com.gdut.mobileassistant.ui;

import com.gdut.Util.Util;
import com.gdut.mobileassistant.AssistantApp;
import com.gdut.mobileassistant.R;
import com.gdut.mobileassistant.service.ControlCenterManager;

import android.content.Context;
import android.view.Display;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.View.OnTouchListener;
import android.widget.ImageView;

public class SlindingHandle implements OnTouchListener{

	private final String TAG="zhiqiang";
	
	private Context context;
	private View handle;
	private ImageView indicator = null;
	private AssistantApp app;
	private WindowManager.LayoutParams  wmParams=null;
	
	private ControlCenterView mControlCenterView;
	
	private ControlCenterManager mControlCenterManager;
	
	private boolean Top =false;
	
	public SlindingHandle(Context context) {
		super();
		this.context = context;
		app = (AssistantApp) context.getApplicationContext();
		handle = CreateHandle();
		handle.setOnTouchListener(this);
		initWindowManager();
		
	}

	public SlindingHandle(Context context,boolean isTop) {
		super();
		this.context = context;
		app = (AssistantApp) context.getApplicationContext();
		Top=isTop;
		if(isTop){
			handle = CreateHandleTop();
			indicator = (ImageView)handle.findViewById(R.id.indicator);
		}else{
			handle = CreateHandle();
		}
		handle.setOnTouchListener(this);
		initWindowManager();
		
	}
	
	private void initWindowManager() {
		wmParams =new WindowManager.LayoutParams();
		wmParams.type=WindowManager.LayoutParams.TYPE_PHONE;
		//wmParams.type=WindowManager.LayoutParams.TYPE_APPLICATION ;
		wmParams.flags|=8;
		wmParams.gravity = Gravity.LEFT | Gravity.TOP;
		
		wmParams.x=0;
		wmParams.y=app.getScreenHeight()+5;
		Util.log(TAG, "getScreenHeight()"+wmParams.y);
		
		wmParams.width=WindowManager.LayoutParams.MATCH_PARENT;
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

	private View CreateHandleTop() {
		return LayoutInflater.from(context).inflate(R.layout.slinding_handle_top, null);
	}
	
	@Override
	public boolean onTouch(View v, MotionEvent ev) {
		switch(ev.getAction()){
		case MotionEvent.ACTION_DOWN:
			Util.log(TAG, "SlindingHandle ACTION_DOWN");
			if(app.isIsControlCenterOpen()){
				
			}else{
				Util.log(TAG, "SlindingHandle  add the control view");
				mControlCenterManager.addView(mControlCenterView.getControlView(), mControlCenterView.getLayoutParams());
			}
			if(Top){
				indicator.setImageResource(R.drawable.controls_panel_arrow_downward);
			}
			break;
		case MotionEvent.ACTION_MOVE:
			mControlCenterView.moveTouch((int) ev.getRawY());
			break;
		case MotionEvent.ACTION_UP:
			Util.log(TAG, "SlindingHandle ACTION_UP");
			if(Top){
				indicator.setImageResource(R.drawable.controls_panel_indicator);
			}
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
		if(rawY>app.getScreenHeight()*4/5){
			return false;
		}
		return true;
	}

	public void setmControlCenterManager(ControlCenterManager mControlCenterManager) {
		this.mControlCenterManager = mControlCenterManager;
	}
	
}
