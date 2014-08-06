package com.rudolfmedia.danrudolf.omegacleaning;

import android.app.Fragment;
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


public class QuoteFragment extends Fragment {



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final RelativeLayout rLayout = (RelativeLayout) inflater.inflate(R.layout.fragment_quote, container, false);

		final Intent emailIntent = new Intent(Intent.ACTION_SEND);

		Button quotebutton = (Button) rLayout.findViewById(R.id.quote_button);
		quotebutton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {

				TextView name = (TextView) rLayout.findViewById(R.id.name);
				TextView address = (TextView) rLayout.findViewById(R.id.address);
				TextView phoneNum = (TextView) rLayout.findViewById(R.id.phone);

				if (name.getText().length() == 0){
					Context context = getActivity().getApplicationContext();
					CharSequence text = "Please enter a name";
					int duration = Toast.LENGTH_SHORT;

					Toast toast = Toast.makeText(context, text, duration);
					toast.show();
				}

				else if (address.getText().length() == 0){

					Context context = getActivity().getApplicationContext();
					CharSequence text = "Please enter an address";
					int duration = Toast.LENGTH_SHORT;

					Toast toast = Toast.makeText(context, text, duration);
					toast.show();

				}

				else if(phoneNum.getText().length() == 0){

					Context context = getActivity().getApplicationContext();
					CharSequence text = "Please enter a phone number";
					int duration = Toast.LENGTH_SHORT;

					Toast toast = Toast.makeText(context, text, duration);
					toast.show();
				}

				else {

					emailIntent.setType("plain/text");
					emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL, new String[]{"danRudolf@gmail.com"});
					emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Quote Request");
					emailIntent.putExtra(android.content.Intent.EXTRA_TEXT, "I would like to request a quote for cleaning");
					startActivity(Intent.createChooser(emailIntent, "Request Quote With"));
				}
			}
		});


		return rLayout;
    }

}
