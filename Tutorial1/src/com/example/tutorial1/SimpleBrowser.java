package com.example.tutorial1;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;

public class SimpleBrowser extends Activity implements OnClickListener{

	EditText url;
	WebView ourBrow;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_simple_browser);
		
		ourBrow = (WebView) findViewById(R.id.wvBrowser);
		
		ourBrow.getSettings().setJavaScriptEnabled(true);
		ourBrow.getSettings().setLoadWithOverviewMode(true);
		ourBrow.getSettings().setUseWideViewPort(true);
		ourBrow.setWebViewClient(new ourViewClient());
		try{
			ourBrow.loadUrl("http://www.google.com");
		}catch(Exception e){
			e.printStackTrace();
		}
		
		Button go = (Button) findViewById(R.id.bGo);
		Button back = (Button) findViewById(R.id.bBack);
		Button refresh = (Button) findViewById(R.id.bRefresh);
		Button forward = (Button) findViewById(R.id.bForward);
		Button clearHistory = (Button) findViewById(R.id.bHistory);
		url = (EditText) findViewById(R.id.etURL);
		go.setOnClickListener(this);
		back.setOnClickListener(this);
		forward.setOnClickListener(this);
		refresh.setOnClickListener(this);
		clearHistory.setOnClickListener(this);
	} 

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.simple_browser, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		switch(item.getItemId()){
		
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()){
		case R.id.bGo:
			String theWebsite = url.getText().toString();
			ourBrow.loadUrl(theWebsite);
			//hiding keyboard after using an edit text
			InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
			imm.hideSoftInputFromWindow(url.getWindowToken(), 0);
			break;
		case R.id.bBack:
			if(ourBrow.canGoBack())
				ourBrow.goBack();
			break;
		case R.id.bForward:
			if(ourBrow.canGoForward())
				ourBrow.goBack();
			break;
		case R.id.bRefresh:
			ourBrow.reload();
			break;
		case R.id.bHistory:
			ourBrow.clearHistory();
			break;
		}
	}
	
	
	
}
