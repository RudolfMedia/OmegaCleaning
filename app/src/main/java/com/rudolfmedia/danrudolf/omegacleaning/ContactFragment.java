package com.rudolfmedia.danrudolf.omegacleaning;

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


public class ContactFragment extends android.app.Fragment {

	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment and create an instance to call the "findViewById" method on.
        final RelativeLayout rLayout = (RelativeLayout)inflater.inflate(R.layout.fragment_cleaning, container, false);
		final View layout = inflater.inflate(R.layout.toastlayout,
				(ViewGroup) rLayout.findViewById(R.id.toast_layout_root));


		//Create Email intent
		final Intent emailIntent = new Intent(Intent.ACTION_SEND);

		Button schedule = (Button) rLayout.findViewById(R.id.schedule_button);
		schedule.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				TextView name = (TextView) rLayout.findViewById(R.id.schedule_name);
				TextView address = (TextView) rLayout.findViewById(R.id.schedule_address);
				TextView phoneNumber = (TextView) rLayout.findViewById(R.id.schedule_phone);

				if (name.getText().length() == 0) {

					TextView text = (TextView) layout.findViewById(R.id.text);
					text.setText("Please Enter a Name");

					Toast toast = new Toast(getActivity().getApplicationContext());
					toast.setGravity(Gravity.TOP, 0, 250);
					toast.setDuration(Toast.LENGTH_SHORT);
					toast.setView(layout);
					toast.show();

				} else if (address.getText().length() == 0) {

					TextView text = (TextView) layout.findViewById(R.id.text);
					text.setText("Please Enter an Address");

					Toast toast = new Toast(getActivity().getApplicationContext());
					toast.setGravity(Gravity.TOP, 0, 250);
					toast.setDuration(Toast.LENGTH_SHORT);
					toast.setView(layout);
					toast.show();

				} else if (phoneNumber.getText().length() == 0) {

					TextView text = (TextView) layout.findViewById(R.id.text);
					text.setText("Please Enter a Phone Number");

					Toast toast = new Toast(getActivity().getApplicationContext());
					toast.setGravity(Gravity.TOP, 0, 250);
					toast.setDuration(Toast.LENGTH_SHORT);
					toast.setView(layout);
					toast.show();

				} else {

					emailIntent.setType("plain/text");
					emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL, new String[]{"danRudolf@gmail.com"});
					emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Request Cleaning");
					emailIntent.putExtra(android.content.Intent.EXTRA_TEXT,
					"Hello,\n \nI would like to request a quote for cleaning at " + address.getText()+". "+"Please feel free to contact " +
					name.getText() + " at " + phoneNumber.getText() +"\n\nThanks!");
					startActivity(Intent.createChooser(emailIntent, "Request Cleaning With"));
				}
			}
		});

		return rLayout;
    }
}
