package com.socialproject.splashactivity;

import com.socialproject.tempate.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class LoginFragment extends Fragment  {

	private Button btn_create_account;
	private Button btn_login;
	private Button btn_login_with_fb;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View inflateView = inflater.inflate(R.layout.fragment_login, null);

		btn_create_account = (Button) inflateView
				.findViewById(R.id.btn_create_account);
		btn_login = (Button) inflateView.findViewById(R.id.btn_login);
		btn_login_with_fb = (Button) inflateView
				.findViewById(R.id.btn_login_with_fb);

		return inflateView;
	}
}
