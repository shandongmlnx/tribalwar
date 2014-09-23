package com.tsoab.tribal_war.object;

import java.util.List;
import java.util.Random;

import android.graphics.Canvas;

public abstract class GameSoldier {
	
	protected float bloodCurrent; // 当前血量
	protected Direction directionCurrent; // 当前方向
	protected ActionState actionState; // 当前运动状态
	protected GameSoldier attackGameSoldier; // 攻击对象
	protected CoordMN coordCurrent; // 当前位置
	protected List<GameSoldier> enemySoldierList; // 敌军

	protected Random random; // 随机数

	protected int step; // 当前步数

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
	 * 控制自己该怎么做
	 */
	abstract public void action();

	/**
	 * 攻击
	 */
	abstract protected void attack();

	/**
	 * 移动
	 */
	abstract protected void move();

	/**
	 * 被攻击
	 * 
	 * @param atk
	 *            被攻击的攻击力
	 */
	abstract protected void beAttacked(float atk);

	/**
	 * 寻找目标
	 */
	abstract protected void findAttackObject();

}
