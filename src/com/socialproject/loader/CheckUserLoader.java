package com.socialproject.loader;

import org.json.JSONException;

import com.framework.application.FrameworkApplication;
import com.framework.model.User;

import android.app.Activity;
import android.content.Context;
import android.support.v4.content.AsyncTaskLoader;

public class CheckUserLoader extends AsyncTaskLoader<User> {

	public CheckUserLoader(Context context) {
		super(context);

	}

	

	@Override
	public User loadInBackground() {

		if (((FrameworkApplication) ((Activity) getContext()).getApplication())
				.getAppState().isAppUserSessionValid()) {

			try {
				return ((FrameworkApplication) ((Activity) getContext())
						.getApplication()).getAppState().getAppUserSession();
			} catch (JSONException e) {

				return null;
			}

		}

		User usr = new User();
		usr.setPassword("admin");
		usr.setUsername("admin");
		return usr;
	}
	
	@Override
	protected void onStartLoading() {
        forceLoad();

	}

	@Override
	public void deliverResult(User data) {

		User us = data;
		
		
		super.deliverResult(data);
	}

}
