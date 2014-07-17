package com.thenewboston.vjeko;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;

public class Splash extends Activity {
	
	MediaPlayer ourSong;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.splash);
		ourSong = MediaPlayer.create(Splash.this, R.raw.fire_splash);
		ourSong.start();
		Thread timer = new Thread() {
			public void run() {
				try {
					sleep(5000);
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					Intent onStartPoint = new Intent(
							"com.thenewboston.vjeko.MENU");
					startActivity(onStartPoint);

				}

			}
		};
		timer.start();

	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		ourSong.release();
		finish();
	}

}
