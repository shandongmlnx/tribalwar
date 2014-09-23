package com.tsoab.tribal_war.object;

import java.io.Serializable;

import android.content.Context;
import android.graphics.Canvas;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;

public class GameView extends SurfaceView implements Callback, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5333267168154554427L;

	private Infantry infantryView;
	
//	private SurfaceHolder holder;

	public GameView(Context context) {
		super(context);
		
//		holder = this.getHolder();
//		holder.addCallback(this);

	}
	
	public void draw() {

		System.out.println("ssakdjsdjkabisudhiua");
		
//		Canvas canvas = holder.lockCanvas();
//		infantryView.drawSelf(canvas);
//		holder.unlockCanvasAndPost(canvas);
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
