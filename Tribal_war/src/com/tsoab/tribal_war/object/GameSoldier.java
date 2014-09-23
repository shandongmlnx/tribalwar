package com.tsoab.tribal_war.object;

import java.util.List;
import java.util.Random;

import android.graphics.Canvas;

public abstract class GameSoldier {
	
	protected float bloodCurrent; // ��ǰѪ��
	protected Direction directionCurrent; // ��ǰ����
	protected ActionState actionState; // ��ǰ�˶�״̬
	protected GameSoldier attackGameSoldier; // ��������
	protected CoordMN coordCurrent; // ��ǰλ��
	protected List<GameSoldier> enemySoldierList; // �о�

	protected Random random; // �����

	protected int step; // ��ǰ����

	public GameSoldier getAttackGameSoldier() {
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
	abstract public void action();

	/**
	 * ����
	 */
	abstract protected void attack();

	/**
	 * �ƶ�
	 */
	abstract protected void move();

	/**
	 * ������
	 * 
	 * @param atk
	 *            �������Ĺ�����
	 */
	abstract protected void beAttacked(float atk);

	/**
	 * Ѱ��Ŀ��
	 */
	abstract protected void findAttackObject();

}
