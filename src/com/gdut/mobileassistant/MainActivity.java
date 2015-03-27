package com.gdut.mobileassistant;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity implements OnClickListener{

	private Button ControlCenter;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initResources();
	}

	private void initResources() {
		ControlCenter = (Button) this.findViewById(R.id.control_center);
		ControlCenter.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		if(v == ControlCenter){
			
		}
		
	}

}
