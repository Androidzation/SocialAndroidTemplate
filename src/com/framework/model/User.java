package com.framework.model;

import org.json.JSONException;
import org.json.JSONObject;

import android.os.Parcel;
import android.os.Parcelable;

public class User extends Model {

	private String username;
	private String password;

	/*
	 * when you read the object property in the source you must read in same
	 * sequence that you use in writing in the parcel
	 */
	public User(Parcel source) {

		this.username = source.readString();
		this.password = source.readString();

	}

	/*
	 * create a user object from the json string
	 */
	public User(JSONObject jsonObject) throws JSONException {

		this.username = jsonObject.getString("username");
		this.password = jsonObject.getString("password");
	}

	public User() {
	}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {

		dest.writeString(this.username);
		dest.writeString(this.password);

	}

	public static final Parcelable.Creator<User> CREATOR = new Parcelable.Creator<User>() {

		public User createFromParcel(Parcel source) {
			return new User(source);
		}

		public User[] newArray(int size) {
			return new User[size];
		}

	};

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUsername() {
		return username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword() {
		return password;
	}

	@Override
	public JSONObject toJSONObject() throws JSONException {

		JSONObject jUser = new JSONObject();

		jUser.put("username", username);

		jUser.put("password", password);

		return jUser;
	}

	@Override
	public String toJSONString() throws JSONException {
		return toJSONObject().toString();
	}

}
