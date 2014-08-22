package com.rudolfmedia.danrudolf.omegacleaning;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ListView;

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

		ParseQueryAdapter adapter = new CustomAdapter(getActivity());
//		invoicesListView.setOnClickListener(new View.OnClickListener() {
//			@Override
//			public void onClick(View view) {
//				Fragment detailView = new InvoicesFragment();
//				FragmentManager fragmentManager = getFragmentManager();
//				FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//				fragmentTransaction.replace(R.id.placeholder, detailView);
//				fragmentTransaction.commit();
//			}
//		});
		invoicesListView.setAdapter(adapter);
		adapter.loadObjects();

		return layout;
    }

}
