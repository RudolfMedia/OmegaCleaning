package com.rudolfmedia.danrudolf.omegacleaning;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;

/**
 * Created by danRudolf on 7/21/14.
 */
public class MyAccountFragment extends Fragment{

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 Bundle savedInstanceState) {
		final RelativeLayout rootView =  (RelativeLayout) inflater.inflate(R.layout.fragment_account, container, false);

		Button signupButton = (Button) rootView.findViewById(R.id.sign_up);
		signupButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {

				Fragment signupFragment = new SignUp();
				FragmentManager fragmentManager = getFragmentManager();
				FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
				fragmentTransaction.replace(R.id.placeholder, signupFragment);
				fragmentTransaction.addToBackStack(null);
				fragmentTransaction.commit();

			}

		});

		Button loginButtom = (Button) rootView.findViewById(R.id.login);
		final TextView loginName = (TextView) rootView.findViewById(R.id.enterEmail);
		final TextView loginPassword = (TextView) rootView.findViewById(R.id.password_signin);

		loginButtom.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {

				if (loginName.getText().length() == 0){

					Context context = getActivity().getApplicationContext();
					CharSequence text = "Please enter your email";
					int duration = Toast.LENGTH_SHORT;

					Toast toast = Toast.makeText(context, text, duration);
					toast.setGravity(Gravity.TOP, 0, 250);
					toast.show();

				}

				else if(loginPassword.getText().length() == 0){
					Context context = getActivity().getApplicationContext();
					CharSequence text = "Please enter your password";
					int duration = Toast.LENGTH_SHORT;

					Toast toast = Toast.makeText(context, text, duration);
					toast.setGravity(Gravity.TOP, 0, 250);
					toast.show();
				}
				else {

					ParseUser.logInInBackground(loginName.getText().toString(), loginPassword.getText().toString(), new LogInCallback() {
						@Override
						public void done(ParseUser parseUser, ParseException e) {

							if (parseUser != null) {
								Fragment accounthistory = new InvoiceHistory();
								FragmentManager fragmentManager = getFragmentManager();
								FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
								fragmentTransaction.replace(R.id.placeholder, accounthistory);
								fragmentTransaction.addToBackStack(null);
								fragmentTransaction.commit();

							}
							else{
								Context context = getActivity().getApplicationContext();
								CharSequence text = e.getMessage();
								int duration = Toast.LENGTH_SHORT;
								Toast toast = Toast.makeText(context, text, duration);
								toast.setGravity(Gravity.TOP, 0, 250);
								toast.show();

							}

						}
					});

				}
			}
		});

		return rootView;
	}
}
