package com.tsoab.tribal_war.object;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;

import com.tsoab.tribal_war.activity.MainActivity;
import com.tsoab.tribal_war.constant.BitmapConstant;

public class GameView extends SurfaceView implements Callback {

	private Infantry infantry;
	private SurfaceHolder holder;

	private List<Soldier> pSoldierList, cSoldierList;
	private List<Tree> treeList;

	public GameView(Context context) {
		super(context);

		holder = this.getHolder();
		holder.addCallback(this);

		pSoldierList = new ArrayList<Soldier>();
		cSoldierList = new ArrayList<Soldier>();
		treeList = new ArrayList<Tree>();
		
		List<CoordXY> treePosList = Map.getTreePos();
		for (CoordXY drawRoot : treePosList) {
			treeList.add(new Tree(drawRoot, BitmapConstant.Tree_Size));
			System.out.println(drawRoot);
		}

		// pSoldierList.add(SoldierFact.getInfantry(cSoldierList));
		// pSoldierList.add(SoldierFact.getInfantry(cSoldierList));
		// pSoldierList.add(SoldierFact.getInfantry(cSoldierList));

	}

	public synchronized void draw() {

		for (Soldier soldier : pSoldierList) {
			soldier.action();
		}

		Canvas canvas = holder.lockCanvas();
		if (canvas == null)
			return;

		canvas.drawColor(Color.BLACK);
		
		// draw map
		Paint paint = new Paint();
		paint.setColor(Color.GREEN);
		float tempWidth = Map.Cell_Width;
		for (int i = 0; i < Map.MAP_WIDTH; i++) {
			canvas.drawLine(tempWidth*i, 0, tempWidth*i, MainActivity.Screem_Heigh, paint);
		}
		float tempHeigh = Map.Cell_Heigh;
		for (int i = 0; i < Map.MAP_HEIGH; i++) {
			canvas.drawLine(0, tempHeigh*i, MainActivity.Screem_Width, tempHeigh*i, paint);
		}
		
		// draw tree
		for (Tree tree : treeList) {
			tree.drawSelf(canvas);
		}

		// draw player soldier
		for (Soldier soldier : pSoldierList) {
			soldier.drawSelf(canvas);
		}

		// draw computer soldier
		for (Soldier soldier : cSoldierList) {
			soldier.drawSelf(canvas);
		}

		holder.unlockCanvasAndPost(canvas);
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {

		switch (event.getAction()) {
		case MotionEvent.ACTION_DOWN:
//			int x = (int) event.getX();
//			int y = (int) event.getY();
//
//			synchronized (GameView.this) {
//				cSoldierList.add(SoldierFact.getInfantry(cSoldierList,
//						new CoordXY(x, y)));
//			}
//
//			System.out.println("add InfantryO");
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
