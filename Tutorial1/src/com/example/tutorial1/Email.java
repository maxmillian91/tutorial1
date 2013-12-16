package com.example.tutorial1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Email extends Activity implements View.OnClickListener{
	
	EditText personEmail, intro, personsName, stupidThings, hatefulAction,
	outro;
	String emailAdd, beginning, name, stupidAction, hatefulAct, out;
	Button sendEmail;
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		convertEditTextVarsIntroStringAndYesThisIsAMethodWeCreated();
		String emailAddress[] = {emailAdd};
		String message = "Well Hello"
				+ name
				+ "I just wanted to say "
				+ beginning
				+ ". Not only that but I hate when you "
				+ stupidAction
				+ ", that just really makes me crazy. I just want make you "
				+ hatefulAct
				+ ". Welp, thats all I wanted to chit-chatter about, oh and"
				+ out
				+ ". Oh also if you get bored you should check out abcd "
				+ '\n' + "I'm good";
		
		Intent emailIntent = new Intent(android.content.Intent.ACTION_SEND);
		emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL, emailAddress);
		emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "I hate you!");
		emailIntent.setType("plain/text");
		emailIntent.putExtra(android.content.Intent.EXTRA_TEXT, message);
		startActivity(emailIntent);
		
	}
	private void convertEditTextVarsIntroStringAndYesThisIsAMethodWeCreated() {
		// TODO Auto-generated method stub
		emailAdd = personEmail.getText().toString();
		beginning = intro.getText().toString();
		name = personsName.getText().toString();
		stupidAction = stupidThings.getText().toString();
		hatefulAct = hatefulAction.getText().toString();
		out = outro.getText().toString();
	}
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.email);
		initializeVars();
		sendEmail.setOnClickListener(this);
	}
	private void initializeVars() {
		// TODO Auto-generated method stub
		personEmail = (EditText) findViewById(R.id.editText1);
		intro = (EditText) findViewById(R.id.editText2);
		personsName = (EditText) findViewById(R.id.editText3);
		stupidThings = (EditText) findViewById(R.id.editText4);
		hatefulAction = (EditText) findViewById(R.id.editText5);
		outro = (EditText) findViewById(R.id.editText6);
		sendEmail = (Button) findViewById(R.id.button1);
	}
	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		finish();
	}
	
	
}
