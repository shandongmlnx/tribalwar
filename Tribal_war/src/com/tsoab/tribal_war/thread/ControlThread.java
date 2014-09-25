package com.tsoab.tribal_war.thread;

import com.tsoab.tribal_war.object.GameView;

public class ControlThread extends Thread {

	private GameView gameView;
	private boolean runFlag;

	public ControlThread(GameView gameView) {

		this.gameView = gameView;
	}

	@Override
	public void run() {

		runFlag = true;
		while (runFlag) {
			gameView.draw();
			try {
				Thread.sleep(30);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void setStop() {
		runFlag = false;
	}
}
