package com.gdut.graphics;

import android.os.Handler;
import android.os.Message;

/**
 * 随时监听设置的图片各种参数的变化，在后台完成绘图后会调用done（）
 * @author zhiqiang.lei
 *
 */
public abstract class AsyncGraphicsTask {

	private boolean activate = false;
	private static final int PROCESS_DONE =0;
	private int accuracy = 100;	
	private Runnable threadrun;	
	private Runnable mRunnable = new Runnable(){

		@Override
		public void run() {
			if(IsChanged()){
				new Thread(threadrun).start();
			}else{
				if(activate){
					mhandler.postDelayed(mRunnable, accuracy);
				}
			}
		}
		
	};
	
	private Handler mhandler = new Handler(){

		@Override
		public void handleMessage(Message msg) {
			super.handleMessage(msg);
			switch(msg.what){
				case PROCESS_DONE:
					//if(activate){
					done();
					mhandler.post(mRunnable);
					//}
					break;
			}
		}
		
	};
	
	
	
	public AsyncGraphicsTask() {
		threadrun = new BackGroundThread();
		
	}

	/**
	 * 后台任务完成后会调用此方法
	 */
	public abstract void done();
	/**
	 * 设置的图片参数是否已经发生变化。若此函数返回true，会开始后台Task去绘图
	 * @return
	 */
	public abstract boolean IsChanged();
	/**
	 * 具体的绘图流程在此方法实现
	 */
	public abstract void process();
	/**
	 * 设置是否需要开始或者停止Task
	 * @param enable
	 */
	public void SetTaskStart(boolean enable){
		activate = enable;
		if(activate){
			mhandler.post(mRunnable);
		}
	}
	/**
	 * 设置监听参数变化的间隔时间
	 * @param accuracy 毫秒
	 */
	public void setAccuracy(int accuracy) {
		this.accuracy = accuracy;
	}



	class BackGroundThread implements Runnable{

		@Override
		public void run() {
			process();
			mhandler.sendMessage(mhandler.obtainMessage(PROCESS_DONE));
		}
		
	}
	
	
}
