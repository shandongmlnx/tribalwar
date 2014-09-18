package com.tsoab.tribal_war.view;

import com.tsoab.tribal_war.R;
import com.tsoab.tribal_war.bitmap_manage.BitmapFact;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;

public class GameView extends SurfaceView implements Callback {

	@Override
	public void surfaceCreated(SurfaceHolder holder) {


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
