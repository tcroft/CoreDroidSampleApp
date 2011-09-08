package com.coredroidsample;

import com.coredroid.core.CoreApplication;
import com.coredroidsample.bo.AppPreferences;
import com.coredroidsample.bo.SampleAppState;
import com.coredroidsample.bo.User;

/**
 * This class extends the core application to provide convenience methods
 */
public class SampleApp extends CoreApplication {

	public static User getUser() {
		return getState().get(User.class);
	}
	
	public static void setUser(User user) {
		getState().set(User.class, user);
	}
	
	public static void signout() {
		getState().clear();
		
		// Force removal of user object
		getState().set(User.class, null);
		getState().set(AppPreferences.class, null);
	}
	
	/**
	 * The appstate demonstrate a persistent object that doesn't change during application use, but is cleared on app restart
	 */
	public static SampleAppState getAppState() {
		SampleAppState state = getState().get(SampleAppState.class);
		if (state == null) {
			state = new SampleAppState();
			getState().set(SampleAppState.class, state);
		}
		return state;
	}

	/**
	 * The preferences demonstrate a persistent object that doesn't change during application use that persists across app restarts
	 */
	public static AppPreferences getPreferences() {
		AppPreferences prefs = getState().get(AppPreferences.class);
		if (prefs == null) {
			prefs = new AppPreferences();
			getState().set(AppPreferences.class, prefs);
		}
		return prefs;
	}
}
