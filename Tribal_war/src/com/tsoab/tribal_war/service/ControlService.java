package com.tsoab.tribal_war.service;

import com.tsoab.tribal_war.thread.ControlThread;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class ControlService extends Service{
	
	private ControlThread controlThread;

	@Override
	public IBinder onBind(Intent intent) {
		return null;
	}
	
	@Override
	public void onCreate() {
		super.onCreate();
		
	}
	
	@Override
	public void onDestroy() {
		super.onDestroy();
	}

	private void createAllThread()
	{
		controlThread = new ControlThread();
	}
}
