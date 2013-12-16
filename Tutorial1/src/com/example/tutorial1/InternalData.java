package com.example.tutorial1;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class InternalData extends Activity implements OnClickListener{

	EditText sharedData;
	TextView dataResults;
	FileOutputStream fos;
	String FILENAME="InternalString";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_shared_prefs);
		setupVariable();
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId()){
		case R.id.bSave:
			String data = sharedData.getText().toString();
			//Saving data via file
			/*File f = new File(FILENAME);
			try {
				fos = new FileOutputStream(f);
				//write some data
				fos.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			*/
			try {
				fos = openFileOutput(FILENAME, Context.MODE_PRIVATE);
				fos.write(data.getBytes());
				fos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			break;
		case R.id.bLoad:
			
			break;
		}
	}

	private void setupVariable(){
		Button save = (Button) findViewById(R.id.bSave);
		Button load = (Button) findViewById(R.id.bLoad);
		sharedData = (EditText) findViewById(R.id.etSharedPrefs);
		dataResults = (TextView) findViewById(R.id.tvLoadSharedPrefs);
		save.setOnClickListener(this);
		load.setOnClickListener(this);
		try {
			fos = openFileOutput(FILENAME, Context.MODE_PRIVATE);
			fos.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
