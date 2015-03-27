package com.gdut.mobileassistant.service;

import com.gdut.mobileassistant.AssistantApp;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class AssistantService extends Service{

	public static final String Control_Certer_Action = "ControlCenter";
	public static final String Control_Certer_Switch = "ControlCenterSwitch";
	
	private AssistantApp app;
	@Override
	public IBinder onBind(Intent i) {
		return null;
	}

	@Override
	public void onCreate() {
		app = (AssistantApp)getApplication();
		super.onCreate();
	}

	@Override
	public void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		if(intent==null || intent.getAction() == null){
			return super.onStartCommand(intent, flags, startId);
		}
		String action =intent.getAction();
		if(action.equalsIgnoreCase(Control_Certer_Action)){
			EnableControlCenter(intent.getBooleanExtra(Control_Certer_Switch, false));
		}
		return super.onStartCommand(intent, flags, startId);
	}

	private void EnableControlCenter(boolean enable) {
		app.setControlCenterActivate(enable);
		
	}

	
}
