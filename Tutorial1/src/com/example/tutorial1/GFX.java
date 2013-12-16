package com.example.tutorial1;

import com.example.tutorial1.GFXSurface.MyBringBackSurface;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;

public class GFX extends Activity{

	myBringBack ourView;
	WakeLock wL;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		PowerManager pM = (PowerManager)getSystemService(Context.POWER_SERVICE);
		wL = pM.newWakeLock(PowerManager.FULL_WAKE_LOCK, "whatever");
		super.onCreate(savedInstanceState);
		
		setContentView(ourView);
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		wL.release();
		super.onPause();
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		wL.acquire();
		super.onResume();
	}
	
}
