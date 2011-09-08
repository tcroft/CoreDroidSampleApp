package com.coredroidsample.bo;

import com.coredroid.bo.CoreUser;

/**
 * Add our own custom user properties
 */
public class User extends CoreUser {

	private String description;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		dirty();
		this.description = description;
	}
}
