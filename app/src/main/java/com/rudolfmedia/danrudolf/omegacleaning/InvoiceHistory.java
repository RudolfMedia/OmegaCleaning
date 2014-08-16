package com.rudolfmedia.danrudolf.omegacleaning;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ListView;

import com.parse.ParseObject;
import com.parse.ParseQueryAdapter;


public class InvoiceHistory extends Fragment {

	private ParseQueryAdapter<ParseObject> invoiceAdapter;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

final   FrameLayout layout = (FrameLayout) inflater.inflate(R.layout.fragment_invoice_history, container, false);

		ListView invoicesListView = (ListView) layout.findViewById(R.id.invoiceList);

		invoiceAdapter = new ParseQueryAdapter<ParseObject>(getActivity(), "Invoice");
		invoiceAdapter.setTextKey("Date");
		invoicesListView.setAdapter(invoiceAdapter);
		invoiceAdapter.loadObjects();

		return layout;
    }

}
