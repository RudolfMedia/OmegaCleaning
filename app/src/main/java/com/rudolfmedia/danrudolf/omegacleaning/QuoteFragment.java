package com.rudolfmedia.danrudolf.omegacleaning;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;


public class QuoteFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        RelativeLayout rLayout = (RelativeLayout) inflater.inflate(R.layout.fragment_quote, container, false);

		final Intent emailIntent = new Intent(Intent.ACTION_SEND);

		Button quotebutton = (Button) rLayout.findViewById(R.id.quote_button);
		quotebutton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
					emailIntent.setType("plain/text");
					emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL, new String[]{"danRudolf@gmail.com"});
					emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Quote Request");
					emailIntent.putExtra(android.content.Intent.EXTRA_TEXT, "I would like to request a quote for cleaning");
					startActivity(Intent.createChooser(emailIntent, "Request Quote With"));

			}
		});


		return rLayout;
    }

}
