package com.gdut.adil;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;

public class AIDLBitmap implements Parcelable{

	private Bitmap bitmap;
	
	public AIDLBitmap() {
		super();
	}


	public AIDLBitmap(Parcel source) {
		bitmap = (Bitmap) source.readValue(Bitmap.class.getClassLoader());
	}

	
	public Bitmap getBitmap() {
		return bitmap;
	}


	public void setBitmap(Bitmap bitmap) {
		this.bitmap = bitmap;
	}


	//private byte[] sbitmap;
	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel out, int flag) {
		//out.writeByteArray(sbitmap);
		out.writeValue(bitmap);
	}

	public static final Parcelable.Creator<AIDLBitmap> CREATOR = new Parcelable.Creator<AIDLBitmap>() {

		@Override
		public AIDLBitmap createFromParcel(Parcel source) {
			return new AIDLBitmap(source);
		}

		@Override
		public AIDLBitmap[] newArray(int size) {
			return new AIDLBitmap[size];
		}
	};
}
