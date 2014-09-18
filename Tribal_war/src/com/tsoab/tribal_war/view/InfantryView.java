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

	private SurfaceHolder holder;
	private Bitmap[][] bitmaps;

	private int bitmapIndex = 0;

	private MainActivity mainActivity;

	public InfantryView(MainActivity mainActivity) {
		super(mainActivity);

		this.mainActivity = mainActivity;

		holder = this.getHolder();
		holder.addCallback(this);
	}

	private void DrawSelf(Canvas canvas) {

		if (canvas == null)
			return;

		canvas.drawColor(Color.BLACK);

		for (int i = 0; i < InfantryBitmapRows; i++) {
			canvas.drawBitmap(bitmaps[i][bitmapIndex], getWidth() / 2,
					getHeight() / InfantryBitmapRows * i, null);
		}

		bitmapIndex++;
		bitmapIndex = bitmapIndex >= InfantryBitmapLines ? 0 : bitmapIndex;
	}

}
