package com.gdut.mobileassistant;

import android.app.Application;

public class AssistantApp extends Application{

	private boolean IsControlCenterActivate;
	private boolean IsControlCenterOpen;
	@Override
	public void onCreate() {
		initApp();
		super.onCreate();
	}
	private void initApp() {
		IsControlCenterActivate= false;
		IsControlCenterOpen = false;
	}
	public boolean IsControlCenterActivate() {
		return IsControlCenterActivate;
	}
	public void setControlCenterActivate(boolean isControlCenterActivate) {
		IsControlCenterActivate = isControlCenterActivate;
	}
	public boolean isIsControlCenterOpen() {
		return IsControlCenterOpen;
	}
	public void setIsControlCenterOpen(boolean isControlCenterOpen) {
		IsControlCenterOpen = isControlCenterOpen;
	}

}
