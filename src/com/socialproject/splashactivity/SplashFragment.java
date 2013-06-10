package com.socialproject.splashactivity;

import java.util.Timer;
import java.util.TimerTask;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.LoaderManager.LoaderCallbacks;
import android.support.v4.content.Loader;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.framework.model.User;
import com.socialproject.loader.CheckUserLoader;
import com.socialproject.tempate.R;

public class SplashFragment extends Fragment implements LoaderCallbacks<User> {

	private static int CHECK_USER_LOADER = 0;
	private Timer mTimer;
	private Handler mHandler;

	@Override
	public void onCreate(Bundle savedInstanceState) {

		mTimer = new Timer();
		mHandler = new Handler();
		super.onCreate(savedInstanceState);

	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View mSplashView = inflater.inflate(R.layout.fragment_splash, null);
		return mSplashView;

	}

	@Override
	public void onStart() {

		mTimer.schedule(new TimerTask() {

			@Override
			public void run() {

				mHandler.post(new Runnable() {

					@Override
					public void run() {
						checkUserLoginState();

					}
				});
			}
		}, 5000);

		super.onStart();

	}

	protected void checkUserLoginState() {
		Loader<User> userLoader = getLoaderManager().getLoader(
				CHECK_USER_LOADER);
		getLoaderManager().initLoader(CHECK_USER_LOADER, null, this);

	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);

	}

	@Override
	public Loader<User> onCreateLoader(int arg0, Bundle arg1) {

		CheckUserLoader cul = new CheckUserLoader(getActivity());
		return cul;
	}

	@Override
	public void onLoadFinished(Loader<User> arg0, User arg1) {

		if (arg1 != null) {

			Toast.makeText(getActivity(), "Not Null", Toast.LENGTH_LONG).show();
		} else {

			mHandler.post(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					launchLoginFragment();

				}
			});
		}

	}

	private void launchLoginFragment() {

		FragmentManager mFragmentManager = getFragmentManager();
		FragmentTransaction mFragmentTransaction = mFragmentManager
				.beginTransaction();
		LoginFragment mLoginFragment = new LoginFragment();
		mFragmentTransaction.replace(R.id.realcontent, mLoginFragment);
		mFragmentTransaction.commit();

	}

	@Override
	public void onLoaderReset(Loader<User> arg0) {
		// TODO Auto-generated method stub

	}

}
