package com.gdut.mobileassistant;

import android.app.Application;

public class AssistantApp extends Application{

	public boolean IsControlCenterActivate;
	@Override
	public void onCreate() {
		initApp();
		super.onCreate();
	}
	private void initApp() {
		IsControlCenterActivate= false;
	}

}
