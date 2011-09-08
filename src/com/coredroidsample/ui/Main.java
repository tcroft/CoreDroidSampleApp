package com.coredroidsample.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;

import com.coredroid.util.LogIt;
import com.coredroidsample.R;
import com.coredroidsample.SampleApp;
import com.coredroidsample.SampleAppActivity;
import com.coredroidsample.bo.AppPreferences;
import com.coredroidsample.bo.SampleAppState;
import com.coredroidsample.bo.User;

public class Main extends SampleAppActivity {

	private AppPreferences prefs;
	private SampleAppState state;
	private User user;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.main);
		
		setVisible(R.id.messageText, false);
		
		setClickListener(R.id.signoutButton, new SignOutListener());
	}

	@Override
	protected void onResume() {
		super.onResume();

		// Handle first time login
		user = SampleApp.getUser();
		if (user == null) {
			startActivity(new Intent(this, LoginDialog.class));
			return;
		}

		prefs = SampleApp.getPreferences();
		state = SampleApp.getAppState();

		updateUI();
	}
	
	@Override
	protected void onPause() {

		// Prefs will be null if we forwarded to Login
		if (prefs != null) {
			commit();
		}
		
		super.onPause();
	}
	
	private void commit() {
		// Copy values back to model
		int planet = -1;
		switch(((RadioGroup)findViewById(R.id.planetGroup)).getCheckedRadioButtonId()) {
		case R.id.earthRadio: planet = 0; break;
		case R.id.jupiterRadio: planet = 1; break;
		case R.id.saturnRadio: planet = 2; break;
		}
		prefs.setSelection(planet);
		LogIt.d(this, "Selection: " + planet);
	}

	private void updateUI() {

		// Copy model to uI
		int planet = -1;
		switch(prefs.getSelection()) {
		case 0: planet = R.id.earthRadio; break;
		case 1: planet = R.id.jupiterRadio; break;
		case 2: planet = R.id.saturnRadio; break;
		}
		LogIt.d(this, "Applying: " + prefs.getSelection() + " - " + planet);
		((RadioGroup)findViewById(R.id.planetGroup)).check(planet);
		
		// Message to the user
		setVisible(R.id.messageText, !state.isUserWelcomed());
		if (!state.isUserWelcomed()) {
			setViewText(R.id.messageText, "Welcome " + user.getName());
		}
	}
	
	private class SignOutListener implements View.OnClickListener {

		@Override
		public void onClick(View v) {
			
			// Clear state
			SampleApp.signout();

			// Clear the activity and start over
			startActivity(new Intent(Main.this, Main.class));
			finish();
		}
		
	}
}
