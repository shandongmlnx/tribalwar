package com.tsoab.tribal_war.object;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;

import com.tsoab.tribal_war.fact.SoldierFact;

public class GameView extends SurfaceView implements Callback {

	private Infantry infantry;
	private SurfaceHolder holder;

	private List<Soldier> pSoldierList, cSoldierList;

	public GameView(Context context) {
		super(context);

		holder = this.getHolder();
		holder.addCallback(this);

		pSoldierList = new ArrayList<Soldier>();
		cSoldierList = new ArrayList<Soldier>();

		infantry = SoldierFact.getInfantry(cSoldierList, new CoordXY());

	}

	public synchronized void draw() {

		 infantry.action();

		Canvas canvas = holder.lockCanvas();
		if (canvas == null)
			return;

		canvas.drawColor(Color.BLACK);
		infantry.drawSelf(canvas);

		for (Soldier soldier : cSoldierList) {
			soldier.drawSelf(canvas);
		}

		holder.unlockCanvasAndPost(canvas);
	}
	
	@Override
	public boolean onTouchEvent(MotionEvent event) {

		switch (event.getAction()) {
		case MotionEvent.ACTION_DOWN:
			int x = (int) event.getX();
			int y = (int) event.getY();

			synchronized (GameView.this) {
				cSoldierList.add(SoldierFact.getInfantry(cSoldierList,
						new CoordXY(x, y)));
			}

			System.out.println("add InfantryO");
			break;
		}

		return super.onTouchEvent(event);
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
