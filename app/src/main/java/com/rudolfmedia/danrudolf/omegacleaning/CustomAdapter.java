package com.rudolfmedia.danrudolf.omegacleaning;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseQueryAdapter;
import com.parse.ParseUser;

/**
 * Created by danRudolf on 8/22/14.
 */
public class CustomAdapter extends ParseQueryAdapter implements AdapterView.OnItemClickListener {

	public CustomAdapter(Context context) {

		super(context, new ParseQueryAdapter.QueryFactory<ParseObject>() {
			public ParseQuery create() {
				ParseQuery query = new ParseQuery("Invoice");
				query.whereEqualTo("CustomerID", ParseUser.getCurrentUser());
				return query;
			}
		});
	}

	@Override
	public View getItemView(ParseObject object, View cellview, ViewGroup parent) {
		if (cellview == null) {

			cellview = View.inflate(getContext(), R.layout.cell_layout, null);

		}

		TextView cellDate = (TextView) cellview.findViewById(R.id.dateTextView);
		TextView invoice = (TextView) cellview.findViewById(R.id.invoiceNoTextView);
		cellDate.setText(object.getString("Date"));
		invoice.setText(object.getString("InvoiceNumber"));

		return cellview;
	}

	@Override
	public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

	}
}