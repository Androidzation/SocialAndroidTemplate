package com.socialproject.loader;

import org.json.JSONException;

import android.app.Activity;
import android.content.Context;
import android.support.v4.content.AsyncTaskLoader;

import com.framework.application.FrameworkApplication;
import com.framework.model.User;

public class CheckUserLoader extends AsyncTaskLoader<User> {

	private Activity activity;

	public CheckUserLoader(Context context) {

		super(context);
		activity = (Activity) context;

	}

	@Override
	protected void onStartLoading() {
		forceLoad();
	}

	@Override
	public User loadInBackground() {

		if (((FrameworkApplication) (activity).getApplication()).getAppState()
				.isAppUserSessionValid()) {

			try {
				return ((FrameworkApplication) ((activity)).getApplication())
						.getAppState().getAppUserSession();
			} catch (JSONException e) {

				return null;
			}

		} else {
			return null;
		}

	}

	@Override
	public void deliverResult(User data) {

		User us = data;

		super.deliverResult(data);
	}

}
