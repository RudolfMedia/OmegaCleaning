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
import android.widget.TextView;
import android.widget.Toast;

import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

import java.util.Timer;
import java.util.TimerTask;


public class SignUp extends android.app.Fragment {

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

	}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

		final View rootView = inflater.inflate(R.layout.fragment_sign_up, container, false);

		Button createAccount = (Button) rootView.findViewById(R.id.create_account);

		createAccount.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {

				TextView nameField = (TextView) rootView.findViewById(R.id.nameField);
				TextView emailField = (TextView) rootView.findViewById(R.id.signup_email);
				TextView password = (TextView) rootView.findViewById(R.id.signup_password);
				TextView confirmPassword = (TextView) rootView.findViewById(R.id.signup_password_confirm);

				if (nameField.getText().length() == 0){

					Context context = getActivity().getApplicationContext();
					CharSequence text = "Please enter a name";
					int duration = Toast.LENGTH_SHORT;
					Toast toast = Toast.makeText(context, text, duration);
					toast.setGravity(Gravity.TOP, 0, 250);
					toast.show();

				}

				else if (emailField.getText().length() == 0){
					Context context = getActivity().getApplicationContext();
					CharSequence text = "Please enter an email";
					int duration = Toast.LENGTH_SHORT;
					Toast toast = Toast.makeText(context, text, duration);
					toast.setGravity(Gravity.TOP, 0, 250);
					toast.show();
				}

				else if (password.getText().length() == 0){
					Context context = getActivity().getApplicationContext();
					CharSequence text = "Please enter a password";
					int duration = Toast.LENGTH_SHORT;

					Toast toast = Toast.makeText(context, text, duration);
					toast.setGravity(Gravity.TOP, 0, 250);
					toast.show();
				}

				else if (password.getText().length() < 4){
					Context context = getActivity().getApplicationContext();
					CharSequence text = "Passwords must be at least 4 characters";
					int duration = Toast.LENGTH_SHORT;

					Toast toast = Toast.makeText(context, text, duration);
					toast.setGravity(Gravity.TOP, 0, 250);
					toast.show();
				}

				else if (!password.getText().toString().equals(confirmPassword.getText().toString())){

					Context context = getActivity().getApplicationContext();
					CharSequence text = "Passwords do not match";
					int duration = Toast.LENGTH_SHORT;

					Toast toast = Toast.makeText(context, text, duration);
					toast.setGravity(Gravity.TOP, 0, 250);
					toast.show();
				}

				else{

					ParseUser user = new ParseUser();
					user.setUsername(emailField.getText().toString());
					user.setEmail(emailField.getText().toString());
					user.setPassword(password.getText().toString());
					user.put("Name", nameField.getText().toString());

					user.signUpInBackground(new SignUpCallback() {
						@Override
						public void done(ParseException e) {

							if (e == null){
								Context context = getActivity().getApplicationContext();
								CharSequence text = "Account Created!";
								int duration = Toast.LENGTH_SHORT;

								Toast toast = Toast.makeText(context, text, duration);
								toast.setGravity(Gravity.TOP, 0, 250);
								toast.show();

								new Timer().schedule(new TimerTask() {
									@Override
									public void run() {

										Fragment login = new MyAccountFragment();
										FragmentManager fragmentManager = getFragmentManager();
										FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
										fragmentTransaction.replace(R.id.placeholder, login);
										fragmentTransaction.commit();
									}
								}, 750);

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
