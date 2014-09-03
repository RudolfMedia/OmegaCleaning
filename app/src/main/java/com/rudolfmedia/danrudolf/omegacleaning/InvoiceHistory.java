package com.rudolfmedia.danrudolf.omegacleaning;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ListView;

import com.parse.ParseObject;
import com.parse.ParseQueryAdapter;


public class InvoiceHistory extends Fragment {

//	private ParseQueryAdapter<ParseObject> CustomAdapter;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

final   FrameLayout layout = (FrameLayout) inflater.inflate(R.layout.fragment_invoice_history, container, false);

		ListView invoicesListView = (ListView) layout.findViewById(R.id.invoiceList);

		final ParseQueryAdapter adapter = new CustomAdapter(getActivity());
		invoicesListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

				ParseObject object = adapter.getItem(i);

				Fragment detailView = InvoicesFragment.newInstance(object.getString("InvoiceNumber"),
						object.getString("Date"), object.getString("Address"), object.getString("Details"), object.getString("TotalCost"));

				FragmentManager fragmentManager = getFragmentManager();
				FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
				fragmentTransaction.replace(R.id.placeholder, detailView);
				fragmentTransaction.addToBackStack(null);
				fragmentTransaction.commit();
			}
		});

		invoicesListView.setAdapter(adapter);
		adapter.loadObjects();

		return layout;
    }

}
