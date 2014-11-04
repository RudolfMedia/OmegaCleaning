package com.rudolfmedia.danrudolf.omegacleaning;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
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
import com.parse.ParseInstallation;
import com.parse.ParseUser;

/**
 * Created by danRudolf on 7/21/14.
 */
public class MyAccountFragment extends Fragment{


	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 Bundle savedInstanceState) {
		final RelativeLayout rootView =  (RelativeLayout) inflater.inflate(R.layout.fragment_account, container, false);
		final View layout = inflater.inflate(R.layout.toastlayout,
				(ViewGroup) rootView.findViewById(R.id.toast_layout_root));

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

					TextView text = (TextView) layout.findViewById(R.id.text);
					text.setText("Please Enter Your Email Address");

					Toast toast = new Toast(getActivity().getApplicationContext());
					toast.setGravity(Gravity.TOP, 0, 250);
					toast.setDuration(Toast.LENGTH_SHORT);
					toast.setView(layout);
					toast.show();

				}

				else if(loginPassword.getText().length() == 0){
					TextView text = (TextView) layout.findViewById(R.id.text);
					text.setText("Please Enter Your Password");

					Toast toast = new Toast(getActivity().getApplicationContext());
					toast.setGravity(Gravity.TOP, 0, 250);
					toast.setDuration(Toast.LENGTH_SHORT);
					toast.setView(layout);
					toast.show();
				}
				else {

					ParseUser.logInInBackground(loginName.getText().toString().toLowerCase(), loginPassword.getText().toString(), new LogInCallback() {
						@Override
						public void done(ParseUser parseUser, ParseException e) {

							if (parseUser != null) {

								ParseInstallation current = ParseInstallation.getCurrentInstallation();
								current.put("username", parseUser.getUsername());
								current.saveInBackground();

								Fragment accounthistory = new InvoiceHistory();
								FragmentManager fragmentManager = getFragmentManager();
								FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
								fragmentTransaction.replace(R.id.placeholder, accounthistory);
								fragmentTransaction.addToBackStack(null);
								fragmentTransaction.commit();

							}
							else{
								TextView text = (TextView) layout.findViewById(R.id.text);

								if (e.getMessage().contentEquals("i/o failure: java.net.UnknownHostException: Unable to resolve host \"api.parse.com\": No address associated with hostname")){
									text.setText("Connection Error: Please Try Again");
								}

								else{
									text.setText(e.getMessage());
								}

								Toast toast = new Toast(getActivity().getApplicationContext());
								toast.setGravity(Gravity.TOP, 0, 250);
								toast.setDuration(Toast.LENGTH_SHORT);
								toast.setView(layout);
								toast.show();

							}

						}
					});

				}
			}
		});

		Button referFriend = (Button) rootView.findViewById(R.id.refer);
		referFriend.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {

				Intent referEmail = new Intent(Intent.ACTION_SEND);
				referEmail.setType("plain/text");
				referEmail.putExtra(android.content.Intent.EXTRA_SUBJECT, "Referral From Omega Cleaning");
				referEmail.putExtra(android.content.Intent.EXTRA_TEXT,
						"Hello,\n Thanks!");
				startActivity(Intent.createChooser(referEmail, "Contact Friend With"));
			}
		});

		return rootView;
	}
}
