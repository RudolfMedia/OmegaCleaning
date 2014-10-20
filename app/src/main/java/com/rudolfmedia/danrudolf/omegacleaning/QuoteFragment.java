package com.rudolfmedia.danrudolf.omegacleaning;

import android.app.Fragment;
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


public class QuoteFragment extends Fragment {



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final RelativeLayout rLayout = (RelativeLayout) inflater.inflate(R.layout.fragment_quote, container, false);

		final View layout = inflater.inflate(R.layout.toastlayout,
				(ViewGroup) rLayout.findViewById(R.id.toast_layout_root));

		final Intent emailIntent = new Intent(Intent.ACTION_SEND);

		Button quotebutton = (Button) rLayout.findViewById(R.id.quote_button);
		quotebutton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {

				TextView name = (TextView) rLayout.findViewById(R.id.name);
				TextView address = (TextView) rLayout.findViewById(R.id.address);
				TextView phoneNum = (TextView) rLayout.findViewById(R.id.phone);

				if (name.getText().length() == 0){

					TextView text = (TextView) layout.findViewById(R.id.text);
					text.setText("Please Enter a Name");

					Toast toast = new Toast(getActivity().getApplicationContext());
					toast.setGravity(Gravity.TOP, 0, 250);
					toast.setDuration(Toast.LENGTH_SHORT);
					toast.setView(layout);
					toast.show();
				}

				else if (address.getText().length() == 0){

					TextView text = (TextView) layout.findViewById(R.id.text);
					text.setText("Please Enter an Address");

					Toast toast = new Toast(getActivity().getApplicationContext());
					toast.setGravity(Gravity.TOP, 0, 250);
					toast.setDuration(Toast.LENGTH_SHORT);
					toast.setView(layout);
					toast.show();

				}

				else if(phoneNum.getText().length() == 0){
					TextView text = (TextView) layout.findViewById(R.id.text);
					text.setText("Please Enter a Phone Number");

					Toast toast = new Toast(getActivity().getApplicationContext());
					toast.setGravity(Gravity.TOP, 0, 250);
					toast.setDuration(Toast.LENGTH_SHORT);
					toast.setView(layout);
					toast.show();
				}

				else {

					emailIntent.setType("plain/text");
					emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL, new String[]{"OmegaServicesOffice@gmail.com"});
					emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Quote Request");
					emailIntent.putExtra(android.content.Intent.EXTRA_TEXT,
					"Hello,\n \nI would like to request a quote for " + address.getText()+". "+"Please feel free to contact " +
					name.getText() + " at " + phoneNum.getText() +"\n \n Thanks!");
					startActivity(Intent.createChooser(emailIntent, "Request Quote With"));
				}
			}
		});


		return rLayout;
    }

}
