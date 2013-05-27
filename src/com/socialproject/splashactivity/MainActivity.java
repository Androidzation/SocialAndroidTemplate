package com.socialproject.splashactivity;

import com.socialproject.tempate.R;
import com.socialproject.tempate.R.layout;
import com.socialproject.tempate.R.menu;

import android.os.Bundle;
import android.app.Activity;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.Menu;

public class MainActivity extends FragmentActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		SplashFragment mSplashFragment = new SplashFragment();
		FragmentManager mFragmentManager = getSupportFragmentManager();
		FragmentTransaction mFt = mFragmentManager.beginTransaction();

		mFt.add(R.id.realcontent, mSplashFragment);
		mFt.commit();
	}

}
