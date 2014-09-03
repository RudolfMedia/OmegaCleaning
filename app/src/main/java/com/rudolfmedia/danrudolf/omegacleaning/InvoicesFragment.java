package com.rudolfmedia.danrudolf.omegacleaning;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;


public class InvoicesFragment extends Fragment {


    public static InvoicesFragment newInstance(String mNumber, String mDate, String mAddress, String mJob, String mTotal) {

		InvoicesFragment details = new InvoicesFragment();

		Bundle stringArgs = new Bundle();
		stringArgs.putString("number", mNumber);
		stringArgs.putString("date", mDate);
		stringArgs.putString("address", mAddress);
		stringArgs.putString("job", mJob);
		stringArgs.putString("total", mTotal);

		details.setArguments(stringArgs);

		return details;
    }

	public String getNumber() {
		return getArguments().getString("number", " ");
	}

	public String getDate() {
		return getArguments().getString("date", " ");
	}

	public String getAddress() {
		return getArguments().getString("address", " ");
	}

	public String getJob() {
	 String job = getArguments().getString("job", " ");
		return job;
	}

	public String getTotal() {
		return getArguments().getString("total", " ");
	}


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        RelativeLayout layout = (RelativeLayout) inflater.inflate(R.layout.fragment_invoices, container, false);

		TextView numberView = (TextView) layout.findViewById(R.id.invoiceDetailNo);
		numberView.setText(getNumber());

		TextView dateView = (TextView) layout.findViewById(R.id.invoiceDetailDate);
		dateView.setText(getDate());

		TextView addressView = (TextView) layout.findViewById(R.id.invoiceDetailAddress);
		addressView.setText(getAddress());

		TextView detailView = (TextView) layout.findViewById(R.id.jobDetailView);
		detailView.setText(getJob().replace("\\n", "\n"));

		TextView totalView = (TextView) layout.findViewById(R.id.detailTotal);
		totalView.setText(getTotal());

		return layout;
    }



}
