package com.tsoab.tribal_war.object;

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
	}

	@Override
	public void action() {

		if (attackGameSoldier != null
				&& attackGameSoldier.getBloodCurrent() > 0) {

			// 在攻击范围内
			if (CoordMN.distance(coordCurrent,
					attackGameSoldier.getCoordCurrent()) <= SoldierConstant.InfantryATKRange) {
				attack();
			}
		}
		// 寻找目标
		findAttackObject();
		// 移动
		move();
	}

	@Override
	protected void attack() {
		// TODO Auto-generated method stub

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
	}

	@Override
	protected void beAttacked(float atk) {
		// TODO Auto-generated method stub

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
