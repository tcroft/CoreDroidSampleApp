package com.coredroidsample.ui;

import android.os.Bundle;
import android.view.View;

import com.coredroidsample.R;
import com.coredroidsample.SampleApp;
import com.coredroidsample.SampleAppActivity;
import com.coredroidsample.bo.User;

public class LoginDialog extends SampleAppActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.login);
		
		setClickListener(R.id.loginButton, new LoginListener());
	}
	
	private class LoginListener implements View.OnClickListener {
		@Override
		public void onClick(View v) {
			
			User user = SampleApp.getUser();
			if (user == null) {
				user = new User();
				SampleApp.setUser(user);
			}

			// Set up new user information
			user.setName(getViewText(R.id.usernameText));
			user.setPassword(getViewText(R.id.passwordText));
			
			finish();
		}
	}
	
}
