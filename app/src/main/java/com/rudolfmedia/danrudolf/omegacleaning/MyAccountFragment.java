package com.rudolfmedia.danrudolf.omegacleaning;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;

/**
 * Created by danRudolf on 7/21/14.
 */
public class MyAccountFragment extends Fragment{

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 Bundle savedInstanceState) {
		RelativeLayout rootView =  (RelativeLayout) inflater.inflate(R.layout.fragment_account, container, false);

		Button signupButton = (Button) rootView.findViewById(R.id.sign_up);
		signupButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {

				Fragment signupFragment = new SignUp();
				FragmentManager fragmentManager = getFragmentManager();
				FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
				fragmentTransaction.replace(R.id.loginFragment, signupFragment);
				fragmentTransaction.addToBackStack(null);
				fragmentTransaction.commit();

			}
		});

		return rootView;
	}
}
