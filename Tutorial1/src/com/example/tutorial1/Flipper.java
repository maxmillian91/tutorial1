package com.example.tutorial1;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ViewFlipper;

public class Flipper extends Activity implements OnClickListener{

	ViewFlipper flippy;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_flipper);
		
		flippy = (ViewFlipper) findViewById(R.id.viewFlipper1);
		flippy.setOnClickListener(this);
		flippy.setFlipInterval(500);
		flippy.startFlipping();
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		flippy.showNext();
	}
}
