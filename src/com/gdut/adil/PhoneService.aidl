package com.gdut.adil;

import com.gdut.adil.mCallBack;
import com.gdut.adil.AIDLBitmap;
interface PhoneService{
	boolean invokTest(boolean on,int slot);
	void insertSimDB(String Iccid,boolean activate);
	int getSimActivate(String Iccid);
	void takeScreenCap(mCallBack cb,int w,int h);
	AIDLBitmap ScreenCap(int w,int h);
}