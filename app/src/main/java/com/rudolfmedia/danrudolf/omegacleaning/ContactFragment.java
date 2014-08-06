package com.rudolfmedia.danrudolf.omegacleaning;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
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

					Context context = getActivity().getApplicationContext();
					CharSequence text = "Please enter a name";
					int duration = Toast.LENGTH_SHORT;

					Toast toast = Toast.makeText(context, text, duration);
					toast.show();
				} else if (address.getText().length() == 0) {

					Context context = getActivity().getApplicationContext();
					CharSequence text = "Please enter an address";
					int duration = Toast.LENGTH_SHORT;

					Toast toast = Toast.makeText(context, text, duration);
					toast.show();
				} else if (phoneNumber.getText().length() == 0) {

					Context context = getActivity().getApplicationContext();
					CharSequence text = "Please enter a phonenumber";
					int duration = Toast.LENGTH_SHORT;

					Toast toast = Toast.makeText(context, text, duration);
					toast.show();
				} else {

					emailIntent.setType("plain/text");
					emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL, new String[]{"danRudolf@gmail.com"});
					emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Request Cleaning");
					emailIntent.putExtra(android.content.Intent.EXTRA_TEXT, "I would like to request a Cleaning for This Date");
					startActivity(Intent.createChooser(emailIntent, "Request Cleaning With"));
				}
			}
		});

		return rLayout;
    }
}
