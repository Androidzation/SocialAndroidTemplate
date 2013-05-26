package com.socialproject.splashactivity;

import com.socialproject.tempate.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class SplashFragment extends Fragment {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View mSplashView = inflater.inflate(R.layout.fragment_splash, null);
		return mSplashView;

	}

	@Override
	public void onStart() {
		
		super.onStart();
	}

}
