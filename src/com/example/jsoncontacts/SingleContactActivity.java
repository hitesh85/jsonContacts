package com.example.jsoncontacts;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.jsoncontacts.R;

public class SingleContactActivity  extends Activity {
	
	private Contact contact;
	private ProgressDialog pDialog;
	private TextView lblName;
	private TextView lblCompany;
	private TextView lblMobile;
	private TextView lblHome;
	private TextView lblWork;
	private TextView lblStreet;
	private TextView lblCity;
	private TextView lblZip;
	private TextView lblBday;
	private TextView lblEmail;
	private TextView lblFav;
	private ImageView bgImg;
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_contact);
       
        
        // Get JSON values from previous intent
        Bundle data = getIntent().getExtras();
        contact = data.getParcelable("contact");
        
        // Displaying all values on the screen
        lblName = (TextView) findViewById(R.id.name_label);
        lblCompany = (TextView) findViewById(R.id.company_label);
        lblMobile = (TextView) findViewById(R.id.mobile_label);
    	lblHome = (TextView) findViewById(R.id.home_label);
    	lblWork = (TextView) findViewById(R.id.work_label);
    	lblStreet = (TextView) findViewById(R.id.street);
    	lblCity = (TextView) findViewById(R.id.city);
    	lblZip = (TextView) findViewById(R.id.zip);
    	lblBday  = (TextView) findViewById(R.id.bday);
    	lblEmail = (TextView) findViewById(R.id.email);
    	lblFav = (TextView) findViewById(R.id.fav);
    	bgImg = (ImageView) findViewById(R.id.imageView1);
        
       
        new GetDetails().execute();
        
        
        

    }
	
	private class GetDetails extends AsyncTask<Void, Void, Void> {
		public ImageLoader imageLoader;
		
		@Override
		protected void onPreExecute() {
			super.onPreExecute();
			// Showing progress dialog
			pDialog = new ProgressDialog(SingleContactActivity.this);
			pDialog.setMessage("Please wait...");
			pDialog.setCancelable(false);
			pDialog.show();
			imageLoader=new ImageLoader(SingleContactActivity.this.getApplicationContext());
		}

		@Override
		protected Void doInBackground(Void... arg0) {
			contact = JsonParser.parseDetails(contact);
			return null;
		}

		@Override
		protected void onPostExecute(Void result) {
			super.onPostExecute(result);
			// Dismiss the progress dialog
			
			lblName.setText(contact.getName());
	        lblCompany.setText(contact.getCompany());
	        lblMobile.setText("Mobile: " + contact.getPhone_mobile());
	    	lblHome.setText("Home: " + contact.getPhone_home());
	    	lblWork.setText("Work: " + contact.getPhone_work());
	    	lblStreet.setText(contact.getStreet());
	    	lblCity.setText(contact.getCity() + ", " +contact.getState());
	    	lblZip.setText(contact.getZip());
	    	lblBday.setText("Birthdate: " + contact.getBday());
	    	lblEmail.setText("Email: " +contact.getEmail());
	    	if(contact.isFav()){
	    		lblFav.setText("*");
	    	}
	    	imageLoader.DisplayImage(contact.getLrgIMG(), bgImg);
	    	
			if (pDialog.isShowing())
				pDialog.dismiss();
		}

	}
}
