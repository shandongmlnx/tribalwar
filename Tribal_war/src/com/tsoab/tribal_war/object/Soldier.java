package com.tsoab.tribal_war.object;

import java.util.List;
import java.util.Random;

import com.tsoab.tribal_war.constant.BitmapConstant;
import com.tsoab.tribal_war.constant.SoldierConstant;

import android.graphics.Canvas;

public abstract class Soldier {

	protected float bloodCurrent; // ��ǰѪ��
	protected Direction directionCurrent; // ��ǰ����
	protected ActionState actionState; // ��ǰ�˶�״̬
	protected Soldier attackGameSoldier; // ��������
	protected CoordMN coordCurrent; // ��ǰλ��
	protected List<Soldier> enemySoldierList; // �о�
	protected int soldierSpeed = SoldierConstant.InfantrySpeed;

	protected Random random; // �����

	protected int step; // ��ǰ����

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
	 * �����Լ�����ô��
	 */
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

	/**
	 * ����
	 */
	protected void attack() {

		actionState = ActionState.ATK;
		step = (step + 1) % BitmapConstant.InfantryBitmapLines;
		attackGameSoldier.beAttacked(SoldierConstant.InfantryATK);
		if (attackGameSoldier.isdead())
			enemySoldierList.remove(attackGameSoldier);
	}

	/**
	 * �ƶ�
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
			System.out.println("��");
			return true;
		}
		return false;
	}

	/**
	 * ������
	 * 
	 * @param atk
	 *            �������Ĺ�����
	 */
	protected void beAttacked(float atk) {
		bloodCurrent -= atk;
	}

	/**
	 * Ѱ��Ŀ��
	 */
	protected void findAttackObject() {

		// û�ео�
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
