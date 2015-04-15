package com.gdut.Util;

import android.util.Log;

public class Util {

	private final static boolean DEBUG=true;
	public static void log(String TAG, String message){
		if(DEBUG){
			Log.d(TAG, message);
		}
	}
}
