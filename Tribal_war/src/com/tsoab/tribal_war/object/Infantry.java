package com.tsoab.tribal_war.object;

import java.util.List;
import java.util.Random;

import android.graphics.Bitmap;
import android.graphics.Canvas;

import com.tsoab.tribal_war.constant.BitmapConstant;
import com.tsoab.tribal_war.constant.SoldierConstant;
import com.tsoab.tribal_war.fact.BitmapFact;

public class Infantry extends GameSoldier {

	private Bitmap[][] infantryBitmapss;

	public Infantry(List<GameSoldier> enemySoldierList) {

		bloodCurrent = SoldierConstant.InfantryBloodTotal;
		directionCurrent = Direction.SOUTH;
		actionState = ActionState.MOVE;
		coordCurrent = new CoordMN();
		this.enemySoldierList = enemySoldierList;

		random = new Random();

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

	@Override
	public void action() {

		// û��Ŀ��
		if (enemySoldierList == null || enemySoldierList.size() == 0) {
			actionState = ActionState.STAND;
			return;
		}
		// �Ƿ��й�������
		if (attackGameSoldier != null
				&& attackGameSoldier.getBloodCurrent() > 0) {

			// �ڹ�����Χ��
			if (CoordMN.distance(coordCurrent,
					attackGameSoldier.getCoordCurrent()) <= SoldierConstant.InfantryATKRange) {
				attack();
				return;
			}
		} else {
			// Ѱ��Ŀ��
			findAttackObject();
			// �ڹ�����Χ��
			if (CoordMN.distance(coordCurrent,
					attackGameSoldier.getCoordCurrent()) <= SoldierConstant.InfantryATKRange) {
				attack();
				return;
			}
		}
		// �ƶ�
		move();
	}

	@Override
	protected void attack() {

		actionState = ActionState.ATK;
	}

	@Override
	protected void move() {

		boolean ismove = false;

		// ���ƶ�
		if (coordCurrent.m < attackGameSoldier.getCoordCurrent().m
				&& new CoordMN(coordCurrent.m + 1, coordCurrent.n).validCoord()) {
			directionCurrent = Direction.EAST;
			coordCurrent.m++;
			ismove = true;
		}
		// �����ƶ�
		if (!ismove && coordCurrent.m > attackGameSoldier.getCoordCurrent().m
				&& new CoordMN(coordCurrent.m - 1, coordCurrent.n).validCoord()) {
			directionCurrent = Direction.WEST;
			coordCurrent.m--;
			ismove = true;
		} // �����ƶ�
		if (!ismove && coordCurrent.n < attackGameSoldier.getCoordCurrent().n
				&& new CoordMN(coordCurrent.m, coordCurrent.n + 1).validCoord()) {
			directionCurrent = Direction.SOUTH;
			coordCurrent.n++;
			ismove = true;
		} // ���ƶ�
		if (!ismove && coordCurrent.n > attackGameSoldier.getCoordCurrent().n
				&& new CoordMN(coordCurrent.m, coordCurrent.n - 1).validCoord()) {
			directionCurrent = Direction.NORTH;
			coordCurrent.n--;
			ismove = true;
		}
		actionState = ActionState.MOVE;
		step = (step + 1) % BitmapConstant.InfantryBitmapLines;
	}

	@Override
	protected void beAttacked(float atk) {

	}

	@Override
	protected void findAttackObject() {

		// û�ео�
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
