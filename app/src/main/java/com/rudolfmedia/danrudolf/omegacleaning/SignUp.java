package com.rudolfmedia.danrudolf.omegacleaning;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
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

		final View layout = inflater.inflate(R.layout.toastlayout, (ViewGroup) rootView.findViewById(R.id.toast_layout_root));

		final View layoutBlue = inflater.inflate(R.layout.bluetoast, (ViewGroup) rootView.findViewById(R.id.toast_layout_blue));

		Button createAccount = (Button) rootView.findViewById(R.id.create_account);

		createAccount.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {

				TextView nameField = (TextView) rootView.findViewById(R.id.nameField);
				TextView emailField = (TextView) rootView.findViewById(R.id.signup_email);
				TextView password = (TextView) rootView.findViewById(R.id.signup_password);
				TextView confirmPassword = (TextView) rootView.findViewById(R.id.signup_password_confirm);

				if (nameField.getText().length() == 0){

					TextView text = (TextView) layout.findViewById(R.id.text);
					text.setText("Please Enter a Name");

					Toast toast = new Toast(getActivity().getApplicationContext());
					toast.setGravity(Gravity.TOP, 0, 250);
					toast.setDuration(Toast.LENGTH_SHORT);
					toast.setView(layout);
					toast.show();

				}

				else if (emailField.getText().length() == 0){

					TextView text = (TextView) layout.findViewById(R.id.text);
					text.setText("Please Enter an Email Address");

					Toast toast = new Toast(getActivity().getApplicationContext());
					toast.setGravity(Gravity.TOP, 0, 250);
					toast.setDuration(Toast.LENGTH_SHORT);
					toast.setView(layout);
					toast.show();
				}

				else if (password.getText().length() == 0){
					TextView text = (TextView) layout.findViewById(R.id.text);
					text.setText("Please Enter a Password");

					Toast toast = new Toast(getActivity().getApplicationContext());
					toast.setGravity(Gravity.TOP, 0, 250);
					toast.setDuration(Toast.LENGTH_SHORT);
					toast.setView(layout);
					toast.show();
				}

				else if (password.getText().length() < 4){
					TextView text = (TextView) layout.findViewById(R.id.text);
					text.setText("Password Must Be 4 Characters Long");

					Toast toast = new Toast(getActivity().getApplicationContext());
					toast.setGravity(Gravity.TOP, 0, 250);
					toast.setDuration(Toast.LENGTH_SHORT);
					toast.setView(layout);
					toast.show();
				}

				else if (!password.getText().toString().equals(confirmPassword.getText().toString())){
					TextView text = (TextView) layout.findViewById(R.id.text);
					text.setText("Passwords Do Not Match");

					Toast toast = new Toast(getActivity().getApplicationContext());
					toast.setGravity(Gravity.TOP, 0, 250);
					toast.setDuration(Toast.LENGTH_SHORT);
					toast.setView(layout);
					toast.show();
				}

				else{

					ParseUser user = new ParseUser();
					user.setUsername(emailField.getText().toString().toLowerCase());
					user.setEmail(emailField.getText().toString().toLowerCase());
					user.setPassword(password.getText().toString());
					user.put("Name", nameField.getText().toString());

					user.signUpInBackground(new SignUpCallback() {
						@Override
						public void done(ParseException e) {

							if (e == null){
								TextView text = (TextView) layout.findViewById(R.id.text);
								text.setText("Account Created!");

								Toast toast = new Toast(getActivity().getApplicationContext());
								toast.setGravity(Gravity.TOP, 0, 250);
								toast.setDuration(Toast.LENGTH_SHORT);
								toast.setView(layout);
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

								TextView textError = (TextView) layoutBlue.findViewById(R.id.textBlue);
								textError.setText(e.getMessage());

								Toast toast = new Toast(getActivity().getApplicationContext());
								toast.setGravity(Gravity.TOP, 0, 250);
								toast.setDuration(Toast.LENGTH_SHORT);
								toast.setView(layoutBlue);
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
