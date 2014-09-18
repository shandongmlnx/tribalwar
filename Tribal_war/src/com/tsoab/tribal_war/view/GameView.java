package com.tsoab.tribal_war.view;

import android.content.Context;
import android.graphics.Canvas;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;

public class GameView extends SurfaceView implements Callback {
	;

	private InfantryView infantryView;

	public GameView(Context context) {
		super(context);

		infantryView = new InfantryView();
	}

	@Override
	protected void onDraw(Canvas canvas) {

		infantryView.drawSelf(canvas);
	}

	@Override
	public void surfaceCreated(SurfaceHolder holder) {
	}

	@Override
	public void surfaceChanged(SurfaceHolder holder, int format, int width,
			int height) {

	}

	@Override
	public void surfaceDestroyed(SurfaceHolder holder) {

	}

}
