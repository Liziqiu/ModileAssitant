package com.gdut.mobileassistant.ui;

import com.gdut.mobileassistant.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

public class MusicPlayControl extends absControlItemView{

	public MusicPlayControl(Context context) {
		super(context);
	}

	@Override
	protected View CreateItemView() {
		return LayoutInflater.from(this.context).inflate(R.layout.music_player_control, null);
	}

}
