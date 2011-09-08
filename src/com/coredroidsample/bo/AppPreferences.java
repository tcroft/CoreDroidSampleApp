package com.coredroidsample.bo;

import com.coredroid.core.DirtyableCoreObject;

/**
 * A simple example of handling application preferences
 */
public class AppPreferences extends DirtyableCoreObject {

	private int selection = -1; // Sets default value

	@Override
	public boolean isPersistent() {
		return true;
	}
	
	public int getSelection() {
		return selection;
	}

	public void setSelection(int selection) {
		dirty();
		this.selection = selection;
	}
	
}
