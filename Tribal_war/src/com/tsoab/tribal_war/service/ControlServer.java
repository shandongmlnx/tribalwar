package com.tsoab.tribal_war.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import com.tsoab.tribal_war.object.GameView;
import com.tsoab.tribal_war.thread.ControlThread;

public class ControlServer extends Service {

	private ControlThread controlThread;
	private static GameView gameView;

	@Override
	public IBinder onBind(Intent intent) {
		return null;
	}

	@Override
	public void onCreate() {
		super.onCreate();
		
		try {
			createAllThread();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
	
	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		
		return super.onStartCommand(intent, flags, startId);
	}
	
	public static void setGameView(GameView gameView) {
		ControlServer.gameView = gameView;
	}

	private void createAllThread() throws InterruptedException {
		if (controlThread != null && controlThread.isAlive()) {
			controlThread.setStop();
			controlThread.join();
		}
		controlThread = new ControlThread(gameView);
		controlThread.start();
	}
	
	private void stopAllThread() throws InterruptedException {
		if (controlThread != null && controlThread.isAlive()) {
			controlThread.setStop();
			controlThread.join();
		}
	}
	
	@Override
	public void onDestroy() {
		try {
			stopAllThread();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
