package com.tsoab.tribal_war.object;

import java.util.List;
import java.util.Random;

import android.graphics.Bitmap;
import android.graphics.Canvas;

import com.tsoab.tribal_war.constant.BitmapConstant;
import com.tsoab.tribal_war.constant.SoldierConstant;
import com.tsoab.tribal_war.fact.BitmapFact;

public class Infantry extends Soldier {

	private Bitmap[][] infantryBitmapss;

	public Infantry(List<Soldier> enemySoldierList) {

		bloodCurrent = SoldierConstant.InfantryBloodTotal;
		directionCurrent = Direction.SOUTH;
		actionState = ActionState.MOVE;
		coordCurrent = new CoordMN();
		this.enemySoldierList = enemySoldierList;

		infantryBitmapss = BitmapFact.getinfantryBitmapss();
	}

	@Override
	public void drawSelf(Canvas canvas) {

		if (canvas == null)
			return;

		CoordXY coordXY = coordCurrent.getCoordXY();
		canvas.drawBitmap(infantryBitmapss[actionState.position * 4
				+ directionCurrent.position][step], coordXY.x, coordXY.y, null);
	}

}
