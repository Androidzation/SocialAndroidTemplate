package com.framework.application;

import com.framework.model.User;

import android.app.Application;

public abstract class FrameworkApplication extends Application {

	protected AppStatePreference mAppState;

	@Override
	public void onCreate() {

		mAppState = new AppStatePreference(getApplicationContext());

		super.onCreate();
	}

	/**
	 * @return the mAppState
	 */
	public AppStatePreference getAppState() {
		return mAppState;
	}

}
