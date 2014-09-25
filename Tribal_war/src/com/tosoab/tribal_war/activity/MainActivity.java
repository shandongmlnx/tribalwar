package com.tosoab.tribal_war.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.tsoab.tribal_war.R;
import com.tsoab.tribal_war.object.GameView;
import com.tsoab.tribal_war.service.ControlServer;

public class MainActivity extends ActionBarActivity {

	public final static String ControlServerAction = "com.tsoab.tribal_war.service.ControlServer";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		GameView gameView = new GameView(this);
		setContentView(gameView);
		
		Intent intent = new Intent(ControlServerAction);
		startService(intent);
		
		ControlServer.setGameView(gameView);
		
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
