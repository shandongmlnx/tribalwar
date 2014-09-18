package com.tsoab.tribal_war;

import com.tsoab.tribal_war.bitmap_manage.BitmapFact;

import android.app.Application;

public class TribalWarApp extends Application{

	@Override
	public void onCreate() {
		super.onCreate();

		BitmapFact.setTribalWarApp(this);
	}
}
