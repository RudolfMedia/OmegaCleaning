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


public class ReferFriend extends Fragment {



	public ReferFriend() {
		// Required empty public constructor
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 Bundle savedInstanceState) {
		final RelativeLayout referLayout = (RelativeLayout)inflater.inflate(R.layout.fragment_refer_friend, container, false);

		final View toastLayout = inflater.inflate(R.layout.toastlayout,
				(ViewGroup) referLayout.findViewById(R.id.toast_layout_root));

		final TextView nameText = (TextView) referLayout.findViewById(R.id.referName);
		final TextView contactText = (TextView) referLayout.findViewById(R.id.referContact);

		Button sendButton = (Button) referLayout.findViewById(R.id.sendRefer);



		final Intent referEmail = new Intent(Intent.ACTION_SEND);

		sendButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {

				if (nameText.getText().length() == 0){

					TextView text = (TextView) toastLayout.findViewById(R.id.text);
					text.setText("Please Enter a Name");

					Toast toast = new Toast(getActivity().getApplicationContext());
					toast.setGravity(Gravity.TOP, 0, 250);
					toast.setDuration(Toast.LENGTH_SHORT);
					toast.setView(toastLayout);
					toast.show();

				}

				else if (contactText.getText().length() == 0){

					TextView text = (TextView) toastLayout.findViewById(R.id.text);
					text.setText("Please Enter Contact Info");

					Toast toast = new Toast(getActivity().getApplicationContext());
					toast.setGravity(Gravity.TOP, 0, 250);
					toast.setDuration(Toast.LENGTH_SHORT);
					toast.setView(toastLayout);
					toast.show();

				}

				else{

					referEmail.setType("plain/text");
					referEmail.putExtra(android.content.Intent.EXTRA_SUBJECT, "Client Referral");
					referEmail.putExtra(android.content.Intent.EXTRA_EMAIL, new String[]{"OmegaServicesOffice@gmail.com"});
					referEmail.putExtra(android.content.Intent.EXTRA_TEXT,
							"Hello, \nWe would like to refer a client for service. \n" + nameText.getText() + "can be reached at " + contactText.getText() + "\n\n Thanks!");
					startActivity(Intent.createChooser(referEmail, "Send Email With"));
				}
			}
		});


		return referLayout;

	}

}
