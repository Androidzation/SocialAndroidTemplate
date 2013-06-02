package com.socialproject.splashactivity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.LoaderManager.LoaderCallbacks;
import android.support.v4.content.Loader;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.framework.model.User;
import com.socialproject.loader.CheckUserLoader;
import com.socialproject.tempate.R;

public class SplashFragment extends Fragment implements LoaderCallbacks<User> {

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

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		getLoaderManager().initLoader(0, null, this);

	}

	@Override
	public Loader<User> onCreateLoader(int arg0, Bundle arg1) {
		CheckUserLoader cul = new CheckUserLoader(getActivity());
		return cul;
	}

	@Override
	public void onLoadFinished(Loader<User> arg0, User arg1) {

		if (arg1 != null) {

		}

	}

	@Override
	public void onLoaderReset(Loader<User> arg0) {
		// TODO Auto-generated method stub

	}

}
