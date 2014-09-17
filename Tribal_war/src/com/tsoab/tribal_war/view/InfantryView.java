package com.tsoab.tribal_war.view;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;

import com.tsoab.tribal_war.MainActivity;
import com.tsoab.tribal_war.R;
import com.tsoab.tribal_war.bitmap_manage.BitmapFact;

public class InfantryView extends SurfaceView implements Callback {

	private static final int InfantryBitmapRows = 20;
	private static final int InfantryBitmapLines = 8;

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

	@Override
	public void surfaceCreated(SurfaceHolder holder) {
		Bitmap bubingBitmap = BitmapFactory.decodeResource(
				mainActivity.getResources(), R.drawable.bubing);

		bitmaps = new Bitmap[InfantryBitmapRows][];
		for (int i = 0; i < InfantryBitmapRows; i++) {
			bitmaps[i] = BitmapFact.GetRowBitmaps(bubingBitmap,
					InfantryBitmapRows, InfantryBitmapLines, i);

		}
		new Thread(new Runnable() {

			@Override
			public void run() {
				while (true) {
					Canvas canvas = InfantryView.this.holder.lockCanvas();
					DrawSelf(canvas);
					InfantryView.this.holder.unlockCanvasAndPost(canvas);

					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}).start();
	}

	@Override
	public void surfaceChanged(SurfaceHolder holder, int format, int width,
			int height) {

	}

	@Override
	public void surfaceDestroyed(SurfaceHolder holder) {

	}

}
