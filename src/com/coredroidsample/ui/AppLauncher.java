package com.coredroidsample.ui;


import android.content.Intent;

public class AppLauncher extends com.coredroid.core.AppLauncher {

	@Override
	protected Intent onInitComplete() {
		return new Intent(this, Main.class);
	}
	
}