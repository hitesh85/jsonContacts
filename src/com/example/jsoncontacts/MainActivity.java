package com.example.jsoncontacts;

import com.example.jsoncontacts.MainActivity;
import com.example.jsoncontacts.R;
import com.example.jsoncontacts.itemAdapter;

import java.util.ArrayList;



import android.os.AsyncTask;
import android.os.Bundle;
import android.app.ListActivity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

public class MainActivity extends ListActivity {
	
	private ProgressDialog pDialog;
	
	private static String url = "https://solstice.applauncher.com/external/contacts.json";
	ArrayList<Contact> contactList;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		contactList = new ArrayList<Contact>();
		
		ListView lv = getListView();

		// Listview on item click listener
		lv.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				

				// Starting single contact activity
				Intent in = new Intent(getApplicationContext(),SingleContactActivity.class);
				in.putExtra("contact", contactList.get(position));
				startActivity(in);
				

			}
		});

		// Calling async task to get json
		new GetContacts().execute();
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	private class GetContacts extends AsyncTask<Void, Void, Void> {
		
		@Override
		protected void onPreExecute() {
			super.onPreExecute();
			// Showing progress dialog
			pDialog = new ProgressDialog(MainActivity.this);
			pDialog.setMessage("Please wait...");
			pDialog.setCancelable(false);
			pDialog.show();

		}

		@Override
		protected Void doInBackground(Void... arg0) {
			contactList = JsonParser.parseContact(url);
			return null;
		}

		@Override
		protected void onPostExecute(Void result) {
			super.onPostExecute(result);
			// Dismiss the progress dialog
			if (pDialog.isShowing())
				pDialog.dismiss();
			/**
			 * Updating parsed JSON data into ListView
			 * */
			ListAdapter adapter = new itemAdapter(MainActivity.this, contactList);
			
			setListAdapter(adapter);
		}

	}

}
