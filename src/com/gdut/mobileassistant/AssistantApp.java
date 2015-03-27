package com.gdut.mobileassistant;

import android.app.Application;

public class AssistantApp extends Application{

	private boolean IsControlCenterActivate;
	@Override
	public void onCreate() {
		initApp();
		super.onCreate();
	}
	private void initApp() {
		IsControlCenterActivate= false;
	}
	public boolean IsControlCenterActivate() {
		return IsControlCenterActivate;
	}
	public void setControlCenterActivate(boolean isControlCenterActivate) {
		IsControlCenterActivate = isControlCenterActivate;
	}

}
