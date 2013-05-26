package com.framework.model;

import org.json.JSONException;
import org.json.JSONObject;

import android.os.Parcelable;

public abstract class Model implements Parcelable {

	public abstract JSONObject toJSONObject() throws JSONException;

	public abstract String toJSONString() throws JSONException;
	
	

}
