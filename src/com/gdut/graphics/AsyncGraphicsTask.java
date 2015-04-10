package com.gdut.graphics;

import android.os.Handler;
import android.os.Message;

/**
 * ��ʱ�������õ�ͼƬ���ֲ����ı仯���ں�̨��ɻ�ͼ������done����
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
	 * ��̨������ɺ����ô˷���
	 */
	public abstract void done();
	/**
	 * ���õ�ͼƬ�����Ƿ��Ѿ������仯�����˺�������true���Ὺʼ��̨Taskȥ��ͼ
	 * @return
	 */
	public abstract boolean IsChanged();
	/**
	 * ����Ļ�ͼ�����ڴ˷���ʵ��
	 */
	public abstract void process();
	/**
	 * �����Ƿ���Ҫ��ʼ����ֹͣTask
	 * @param enable
	 */
	public void SetTaskStart(boolean enable){
		activate = enable;
		if(activate){
			mhandler.post(mRunnable);
		}
	}
	/**
	 * ���ü��������仯�ļ��ʱ��
	 * @param accuracy ����
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
