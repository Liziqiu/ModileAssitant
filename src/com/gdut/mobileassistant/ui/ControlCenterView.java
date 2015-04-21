package com.gdut.mobileassistant.ui;

import com.gdut.Util.Util;
import com.gdut.mobileassistant.R;
import com.gdut.mobileassistant.service.ControlCenterManager;

import android.content.Context;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnKeyListener;
import android.view.WindowManager;
import android.widget.AbsoluteLayout;
import android.widget.LinearLayout;

public class ControlCenterView {

	private static final String TAG = "zhiqiang";
	private Context context;
	private ControlCenterConfig config;
	private LinearLayout contain;
	private SlindingHandle mSlindingHandle;
	private WindowManager.LayoutParams wmParams=null;
	private AbsoluteLayout.LayoutParams ControlViewParams ;
	private AbsControlView mAbsControlView;
	private ControlCenterManager mControlCenterManager;

	public ControlCenterView(Context context) {
		super();
		this.context = context;
		config = new ControlCenterConfig();
		initControlView();
	}
	
	private void initControlView(){
		config.ControlCotain=(View) LayoutInflater.from(context).inflate(R.layout.control_center, null);
		mSlindingHandle=new SlindingHandle(context);
		mSlindingHandle.setControlView(this);
		config.ControlHandle = mSlindingHandle.gethandle();
		contain = (LinearLayout) config.ControlCotain.findViewById(R.id.contain);
		contain.addView(config.ControlHandle);
		ControlViewParams = (AbsoluteLayout.LayoutParams)contain.getLayoutParams();
		mAbsControlView = (AbsControlView) config.ControlCotain.findViewById(R.id.control_contain);
	}
	
	public void AddControlViewItem(View Item){
		contain.addView(Item);
	}
	public View getControlView(){
		return config.ControlCotain;
	}
	
	public WindowManager.LayoutParams getLayoutParams(){
		Util.log(TAG, "ControlCenterView:getLayoutParams");
		//if(wmParams == null){
			wmParams =new WindowManager.LayoutParams();
			wmParams.type=WindowManager.LayoutParams.TYPE_SYSTEM_ERROR;
			//wmParams.type=WindowManager.LayoutParams.TYPE_APPLICATION ;
			wmParams.flags = WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN ;
			wmParams.gravity = Gravity.LEFT | Gravity.TOP;
			wmParams.x=0;
			wmParams.y=0;
			wmParams.width=WindowManager.LayoutParams.MATCH_PARENT;
			wmParams.height=WindowManager.LayoutParams.MATCH_PARENT;
			wmParams.format=1;
	//	}
		return wmParams;
	}
	
	public void moveTouch(int position){
		int wHeight=config.ControlCotain.getHeight();
		int controlHeight = contain.getHeight();
		int dis = wHeight-controlHeight-100;//+100 for implements the spring effect
		if(position>dis){
			move(position);
		}
	}
	
	public void move(int position){
		ControlViewParams.x=0;
		ControlViewParams.y=position;
		config.ControlCotain.setLayoutParams(ControlViewParams);
		config.ControlCotain.invalidate();
	}
	public void ShowWhileControlView(boolean show){
		if(show){
			move(config.ControlCotain.getHeight()-contain.getHeight());
		}else{
			mControlCenterManager.remove(getControlView());
		}
	}
	public void setmControlCenterManager(ControlCenterManager mControlCenterManager) {
		this.mControlCenterManager = mControlCenterManager;
		mAbsControlView.setControlCenterManager(mControlCenterManager);
	}
	class ControlCenterConfig{
		public final int BOTTOM=0;
		public final int RIGHT=1;
		public final int LEFT=2;
		
		public View ControlCotain;
		public View ControlHandle;
		public int toward=BOTTOM;
	}
}
