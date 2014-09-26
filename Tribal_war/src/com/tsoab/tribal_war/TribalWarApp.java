package com.tsoab.tribal_war;

import android.app.Application;
import android.util.DisplayMetrics;

import com.tsoab.tribal_war.fact.BitmapFact;

public class TribalWarApp extends Application{

	@Override
	public void onCreate() {
		super.onCreate();

		BitmapFact.setTribalWarApp(this);
	}
}
