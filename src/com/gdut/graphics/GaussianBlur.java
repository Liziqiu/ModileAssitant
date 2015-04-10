
package com.gdut.graphics;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;

public class GaussianBlur {

	private RenderScript rs;
	private Matrix matrix;
	private ScriptIntrinsicBlur script;
	
	private float Radius =5.0f; //模糊程度
	private float Scale =0.25f; //为加快模糊，图片进行缩小处理的比例
	public GaussianBlur(Context context) {
		init(context);
	}
	
	public GaussianBlur(float radius, float scale,Context context) {
		super();
		Radius = radius;
		Scale = scale;
		init(context);
	}


	private void init(Context context){
		rs = RenderScript.create(context);
		matrix =new Matrix();
		script = ScriptIntrinsicBlur.create(rs, Element.U8_4(rs));
	}
	
	private Bitmap SetScale(Bitmap bitmap,float size){
		matrix.reset();
		matrix.postScale(size, size);
		
		return Bitmap.createBitmap(bitmap,0,0,bitmap.getWidth(),bitmap.getHeight(),matrix,true);
	}
	
	public Bitmap androidblur(Bitmap mbitmap){
		Bitmap bitmaps = SetScale(mbitmap,Scale);
		Bitmap result = bitmaps.copy(bitmaps.getConfig(), true);
		Allocation input = Allocation.createFromBitmap(rs,bitmaps,Allocation.MipmapControl.MIPMAP_NONE,Allocation.USAGE_SCRIPT);
		Allocation output = Allocation.createTyped(rs, input.getType());
		script.setRadius(Radius);
		script.setInput(input);
		script.forEach(output);
		output.copyTo(result);
		return result;
	}

	public float getRadius() {
		return Radius;
	}

	public void setRadius(float radius) {
		Radius = radius;
	}

	public float getScale() {
		return Scale;
	}

	public void setScale(float scale) {
		Scale = scale;
	}
	
	
}
