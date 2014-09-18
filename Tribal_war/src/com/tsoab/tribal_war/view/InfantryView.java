package com.tsoab.tribal_war.view;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;

import com.tosoab.tribal_war.activity.MainActivity;
import com.tsoab.tribal_war.R;
import com.tsoab.tribal_war.bitmap_manage.BitmapFact;

public class InfantryView{

	private Bitmap[][] infantryBitmapss;

	public InfantryView() {

		infantryBitmapss = BitmapFact.getinfantryBitmapss();
	}

	public void drawSelf(Canvas canvas) {

		if (canvas == null)
			return;
	}

}
