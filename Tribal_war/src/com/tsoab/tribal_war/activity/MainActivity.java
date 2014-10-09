package com.tsoab.tribal_war.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;

import com.tsoab.tribal_war.R;
import com.tsoab.tribal_war.object.GameView;
import com.tsoab.tribal_war.object.Map;
import com.tsoab.tribal_war.service.ControlServer;

public class MainActivity extends ActionBarActivity {

	public final static String ControlServerAction = "com.tsoab.tribal_war.service.ControlServer";
	
	public static int Screem_Width, Screem_Heigh;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		// È«ÆÁ
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		
		GetScreemPhysicsSize();

		GameView gameView = new GameView(this);
		setContentView(gameView);

		Intent intent = new Intent(ControlServerAction);
		startService(intent);

		ControlServer.setGameView(gameView);

	}
	
	public void GetScreemPhysicsSize()
	{
		DisplayMetrics metric = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(metric);
		Screem_Width = metric.widthPixels;  // ÆÁÄ»¿í¶È£¨ÏñËØ£©
		Screem_Heigh = metric.heightPixels;  // ÆÁÄ»¸ß¶È£¨ÏñËØ£©
		Map.setCellSize();
	}


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();

		Intent intent = new Intent(ControlServerAction);
		stopService(intent);
	}
}
