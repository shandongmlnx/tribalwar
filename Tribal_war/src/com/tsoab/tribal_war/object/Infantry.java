package com.tsoab.tribal_war.object;

import java.io.Serializable;
import java.util.List;
import java.util.Random;

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
import com.tsoab.tribal_war.constant.BitmapConstant;
import com.tsoab.tribal_war.constant.SoldierConstant;

public class Infantry extends GameSoldier {

	private Bitmap[][] infantryBitmapss;

	public Infantry(List<GameSoldier> enemySoldierList) {

		bloodCurrent = SoldierConstant.InfantryBloodTotal;
		directionCurrent = Direction.NORTH;
		coordCurrent = new CoordMN();
		this.enemySoldierList = enemySoldierList;

		random = new Random();

		infantryBitmapss = BitmapFact.getinfantryBitmapss();
	}

	@Override
	public void drawSelf(Canvas canvas) {

		if (canvas == null)
			return;

		CoordXY coordXY = CoordMN.getCoordXY(coordCurrent);
		canvas.drawBitmap(infantryBitmapss[actionState.position * 4
				+ directionCurrent.position][step], coordXY.x, coordXY.y, null);
	}

	@Override
	public void action() {

		// 没有目标
		if (enemySoldierList == null || enemySoldierList.size() == 0)
			actionState = ActionState.STAND;

		// 是否有攻击对象
		if (attackGameSoldier != null
				&& attackGameSoldier.getBloodCurrent() > 0) {

			// 在攻击范围内
			if (CoordMN.distance(coordCurrent,
					attackGameSoldier.getCoordCurrent()) <= SoldierConstant.InfantryATKRange) {
				attack();
				return;
			}
		} else {
			// 寻找目标
			findAttackObject();
			// 在攻击范围内
			if (CoordMN.distance(coordCurrent,
					attackGameSoldier.getCoordCurrent()) <= SoldierConstant.InfantryATKRange) {
				attack();
				return;
			}
		}
		// 移动
		move();
	}

	@Override
	protected void attack() {

		actionState = ActionState.ATK;
	}

	@Override
	protected void move() {

		// 向东移动
		if (coordCurrent.m < attackGameSoldier.getCoordCurrent().m) {
			directionCurrent = Direction.EAST;
			coordCurrent.m++;
		}
		// 向西移动
		else if (coordCurrent.m > attackGameSoldier.getCoordCurrent().m) {
			directionCurrent = Direction.WEST;
			coordCurrent.m--;
		} // 向南移动
		else if (coordCurrent.n < attackGameSoldier.getCoordCurrent().n) {
			directionCurrent = Direction.SOUTH;
			coordCurrent.n++;
		} // 向北移动
		else if (coordCurrent.n > attackGameSoldier.getCoordCurrent().n) {
			directionCurrent = Direction.NORTH;
			coordCurrent.n--;
		}
		actionState = ActionState.MOVE;
		step = (step + 1) % BitmapConstant.InfantryBitmapLines;
	}

	@Override
	protected void beAttacked(float atk) {

	}

	@Override
	protected void findAttackObject() {

		// 没有敌军
		if (enemySoldierList == null || enemySoldierList.size() == 0) {
			attackGameSoldier = null;
			return;
		}

		attackGameSoldier = enemySoldierList.get(0);
		for (GameSoldier soldier : enemySoldierList) {
			if (CoordMN.distance(coordCurrent,
					attackGameSoldier.getCoordCurrent()) > CoordMN.distance(
					coordCurrent, soldier.getCoordCurrent()))
				attackGameSoldier = soldier;
		}
	}

}
