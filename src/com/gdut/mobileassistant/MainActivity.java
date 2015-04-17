package com.gdut.mobileassistant;

import com.gdut.Util.Util;
import com.gdut.mobileassistant.service.AssistantService;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Display;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity implements OnClickListener{

	private Button ControlCenter;
	private AssistantApp app;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		app = (AssistantApp)getApplication();
		initResources();
	}

	private void initResources() {
		ControlCenter = (Button) this.findViewById(R.id.control_center);
		ControlCenter.setOnClickListener(this);

	}

	@Override
	public void onClick(View v) {
		if(v == ControlCenter){
			initScreenSize();
			Intent i = new Intent(this,com.gdut.mobileassistant.service.AssistantService.class);
			i.setAction(AssistantService.Control_Certer_Action);
			if(app.IsControlCenterActivate()){
				i.putExtra(AssistantService.Control_Certer_Switch, false);
				ControlCenter.setText(R.string.control_center_off);
			}else{
				i.putExtra(AssistantService.Control_Certer_Switch, true);
				ControlCenter.setText(R.string.control_center_on);
			}
			this.startService(i);
		}
		
	}

	private void initScreenSize() {
		Display display = this.getWindowManager().getDefaultDisplay();
		int width = display.getWidth();
		int height= display.getHeight();
		app.setScreenWidth(width);
		app.setScreenHeight(height);
	}

}
