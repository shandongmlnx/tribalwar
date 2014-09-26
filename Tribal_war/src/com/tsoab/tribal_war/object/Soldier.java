package com.tsoab.tribal_war.object;

import java.util.List;
import java.util.Random;

import com.tsoab.tribal_war.constant.BitmapConstant;
import com.tsoab.tribal_war.constant.SoldierConstant;

import android.graphics.Canvas;

public abstract class Soldier {

	protected float bloodCurrent; // 当前血量
	protected Direction directionCurrent; // 当前方向
	protected ActionState actionState; // 当前运动状态
	protected Soldier attackGameSoldier; // 攻击对象
	protected CoordMN coordCurrent; // 当前位置
	protected List<Soldier> enemySoldierList; // 敌军
	protected int soldierSpeed = SoldierConstant.InfantrySpeed;

	protected Random random; // 随机数

	protected int step; // 当前步数

	public void setCoordCurrent(CoordMN coordCurrent) {
		this.coordCurrent = coordCurrent;
	}

	public Soldier getAttackGameSoldier() {
		return attackGameSoldier;
	}

	public CoordMN getCoordCurrent() {
		return coordCurrent;
	}

	public float getBloodCurrent() {
		return bloodCurrent;
	}

	/**
	 * draw self
	 * 
	 * @param canvas
	 *            draw tool
	 */
	abstract public void drawSelf(Canvas canvas);

	/**
	 * 控制自己该怎么做
	 */
	public void action() {

		// 没有目标
		if (enemySoldierList == null || enemySoldierList.size() == 0) {
			actionState = ActionState.STAND;
			return;
		}
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

	/**
	 * 攻击
	 */
	protected void attack() {

		actionState = ActionState.ATK;
		step = (step + 1) % BitmapConstant.InfantryBitmapLines;
		attackGameSoldier.beAttacked(SoldierConstant.InfantryATK);
		if (attackGameSoldier.isdead())
			enemySoldierList.remove(attackGameSoldier);
	}

	/**
	 * 移动
	 */
	protected void move() {

		boolean ismove = false;

		if (Math.abs(coordCurrent.m - attackGameSoldier.getCoordCurrent().m) > Math
				.abs(coordCurrent.n - attackGameSoldier.getCoordCurrent().n)) {
			// move east
			if (!ismove)
				ismove = isMoveEast();
			// move west
			if (!ismove)
				ismove = isMoveWest();
			// move south
			if (!ismove)
				ismove = isMoveSouth();
			// move north
			if (!ismove)
				ismove = isMoveNorth();
		} else {
			// move south
			if (!ismove)
				ismove = isMoveSouth();
			// move north
			if (!ismove)
				ismove = isMoveNorth();
			// move east
			if (!ismove)
				ismove = isMoveEast();
			// move west
			if (!ismove)
				ismove = isMoveWest();
		}

		actionState = ActionState.MOVE;
		step = (step + 1) % BitmapConstant.InfantryBitmapLines;

		System.out.println(coordCurrent);
	}

	private boolean isMoveEast() {
		// move east
		if (coordCurrent.m < attackGameSoldier.getCoordCurrent().m
				&& new CoordMN(coordCurrent.m + soldierSpeed, coordCurrent.n)
						.validCoord()) {
			directionCurrent = Direction.EAST;
			coordCurrent.m += soldierSpeed;
			return true;
		}
		return false;
	}

	private boolean isMoveWest() {
		// move west
		if (coordCurrent.m > attackGameSoldier.getCoordCurrent().m
				&& new CoordMN(coordCurrent.m - soldierSpeed, coordCurrent.n)
						.validCoord()) {
			directionCurrent = Direction.WEST;
			coordCurrent.m -= soldierSpeed;
			return true;
		}
		return false;
	}

	private boolean isMoveSouth() {
		// move south
		if (coordCurrent.n < attackGameSoldier.getCoordCurrent().n
				&& new CoordMN(coordCurrent.m, coordCurrent.n + soldierSpeed)
						.validCoord()) {
			directionCurrent = Direction.SOUTH;
			coordCurrent.n += soldierSpeed;
			return true;
		}
		return false;
	}

	private boolean isMoveNorth() {
		// move north
		if (coordCurrent.n > attackGameSoldier.getCoordCurrent().n
				&& new CoordMN(coordCurrent.m, coordCurrent.n - soldierSpeed)
						.validCoord()) {
			directionCurrent = Direction.NORTH;
			coordCurrent.n -= soldierSpeed;
			System.out.println("向北");
			return true;
		}
		return false;
	}

	/**
	 * 被攻击
	 * 
	 * @param atk
	 *            被攻击的攻击力
	 */
	protected void beAttacked(float atk) {
		bloodCurrent -= atk;
	}

	/**
	 * 寻找目标
	 */
	protected void findAttackObject() {

		// 没有敌军
		if (enemySoldierList == null || enemySoldierList.size() == 0) {
			attackGameSoldier = null;
			return;
		}

		attackGameSoldier = enemySoldierList.get(0);
		for (Soldier soldier : enemySoldierList) {
			if (CoordMN.distance(coordCurrent,
					attackGameSoldier.getCoordCurrent()) > CoordMN.distance(
					coordCurrent, soldier.getCoordCurrent()))
				attackGameSoldier = soldier;
		}
	}

	protected boolean isdead() {
		return bloodCurrent <= 0;
	}

}
