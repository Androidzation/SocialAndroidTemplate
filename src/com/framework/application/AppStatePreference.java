package com.framework.application;

import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

import com.framework.model.User;

public class AppStatePreference {

	private String APP_STATE_PREF = "app_state_pref";
	private SharedPreferences mApplicationState;

	public AppStatePreference(Context context) {

		mApplicationState = context.getSharedPreferences(APP_STATE_PREF,
				Context.MODE_PRIVATE);
	}

	public void saveAppUserSession(User mUser) throws JSONException {

		Editor mEditor = mApplicationState.edit();
		mEditor.putString(APP_USER_SESSION, mUser.toJSONString());
		mEditor.commit();
	}

	public User getAppUserSession() throws JSONException {

		String mUserJsonString = mApplicationState.getString(APP_USER_SESSION,
				null);

		if (mUserJsonString != null) {

			User mUser = new User(new JSONObject(mUserJsonString));

			return mUser;
		}

		return null;

	}

	public boolean invalidAppUserSession() {

		if (mApplicationState.contains(APP_USER_SESSION)) {

			Editor mEdit = mApplicationState.edit();
			mEdit.remove(APP_USER_SESSION);
			mEdit.commit();

		}
		return true;
	}

	public boolean isAppUserSessionValid() {

		if (mApplicationState.contains(APP_USER_SESSION)) {

			return true;
		} else {

			return false;
		}

	}

	/*
	 * SharedPreference Key list
	 */

	private String APP_USER_SESSION = "app_user_session";

}
