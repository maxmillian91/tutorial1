package com.example.tutorial1;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.preference.PreferenceManager;

public class Splash extends Activity{
	
	MediaPlayer bgMusic;
	@Override
	protected void onCreate(Bundle leongWaiKit) {
		// TODO Auto-generated method stub
		super.onCreate(leongWaiKit);
		setContentView(R.layout.splash);
		bgMusic = MediaPlayer.create(Splash.this, R.raw.spartan);
		
		SharedPreferences getPrefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
		boolean music = getPrefs.getBoolean("checkbox", true);
		if(music==true)
			bgMusic.start();
		
		Thread timer = new Thread(){
			public void run(){
				try{
					sleep(5000);
				}catch(InterruptedException e){
					e.printStackTrace();
				}finally{
					Intent openMainActivity = new Intent("com.example.tutorial1.MENU");
					startActivity(openMainActivity);
				}
			}
		};
		timer.start();
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		bgMusic.release();
		finish();
	}
}
