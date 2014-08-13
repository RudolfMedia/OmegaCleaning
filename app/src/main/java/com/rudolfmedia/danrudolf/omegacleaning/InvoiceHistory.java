package com.rudolfmedia.danrudolf.omegacleaning;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ListView;


public class InvoiceHistory extends Fragment {


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

		final String[] values = new String[] { "Android List View",
				"Adapter implementation",
				"Simple List View In Android",
				"Create List View Android",
				"Android Example",
				"List View Source Code",
				"List View Array Adapter",
				"Android Example List View"
		};


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        FrameLayout layout = (FrameLayout) inflater.inflate(R.layout.fragment_invoice_history, container, false);

		ListView invoicesListView = (ListView) layout.findViewById(R.id.invoiceList);



		return layout;
    }


}
