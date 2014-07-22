package com.rudolfmedia.danrudolf.omegacleaning;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;


public class ContactFragment extends android.app.Fragment {

	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        RelativeLayout rLayout = (RelativeLayout)inflater.inflate(R.layout.fragment_contact, container, false);
		//Create Email intent
		final Intent emailIntent = new Intent(Intent.ACTION_SEND);

		Button sendQuote = (Button) rLayout.findViewById(R.id.quote_button);

		sendQuote.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				emailIntent.setType("plain/text");
				emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL, new String[]{"danRudolf@gmail.com"});
				emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Quote Request");
				emailIntent.putExtra(android.content.Intent.EXTRA_TEXT, "I would like to request a quote for cleaning");
				startActivity(Intent.createChooser(emailIntent, "Request Quote With"));

			}
		});

		Button schedule = (Button) rLayout.findViewById(R.id.schedule_button);
		schedule.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				emailIntent.setType("plain/text");
				emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL, new String[]{"danRudolf@gmail.com"});
				emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Request Cleaning");
				emailIntent.putExtra(android.content.Intent.EXTRA_TEXT, "I would like to request a Cleaning for This Date");
				startActivity(Intent.createChooser(emailIntent, "Request Cleaning With"));
			}
		});

		return rLayout;
    }
}
