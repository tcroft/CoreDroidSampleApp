package com.coredroidsample.bo;

import com.coredroid.core.DirtyableCoreObject;

/** 
 * Represents state that will go away when the app is restarted.
 * 
 * Note that it doesn't specify that it is persistent so it is implicitly cleaned 
 * when the app does a full restart.  It _will_ keep state across activity starts and stops (and interrupts)
 */
public class SampleAppState extends DirtyableCoreObject {

	private boolean userWelcomed;

	public boolean isUserWelcomed() {
		return userWelcomed;
	}

	public void setUserWelcomed(boolean userWelcomed) {
		dirty();
		this.userWelcomed = userWelcomed;
	}
	
}
