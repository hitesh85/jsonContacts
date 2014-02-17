package com.example.jsoncontacts;

import com.example.jsoncontacts.ServiceHandler;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.util.Log;

public class JsonParser {

	public static ArrayList<Contact> parseContact(String url){
					// Creating service handler class instance
					ServiceHandler sh = new ServiceHandler();
					ArrayList<Contact> contactList = new ArrayList<Contact>();
					
					// Making a request to url and getting response
					String jsonStr = sh.makeServiceCall(url, ServiceHandler.GET);

					Log.d("Response: ", "> " + jsonStr);

					if (jsonStr != null) {
						try {
							JSONArray contacts = new JSONArray(jsonStr);
							

							// looping through All Contacts
							for (int i = 0; i < contacts.length(); i++) {
								JSONObject c = contacts.getJSONObject(i);
								Contact contact = new Contact();
								
								contact.setName(c.getString("name"));
								contact.setEmployeeID(c.getInt("employeeId"));
								contact.setCompany(c.getString("company"));
								contact.setDeatilsURL(c.getString("detailsURL"));
								contact.setSmlIMG(c.getString("smallImageURL"));
								contact.setBday(c.getString("birthdate"));
								

								JSONObject phone = c.getJSONObject("phone");
								if(phone.has("mobile")){
									contact.setPhone_mobile(phone.getString("mobile"));
								} else {
									contact.setPhone_mobile("");
								}
								
								if(phone.has("home")){
									contact.setPhone_home(phone.getString("home"));
								} else {
									contact.setPhone_home("");
								}
								
								if(phone.has("work")){
									contact.setPhone_work(phone.getString("work"));
								} else {
									contact.setPhone_work("");
								}
								
								contactList.add(contact);
							}
						} catch (JSONException e) {
							e.printStackTrace();
						}
					} else {
						Log.e("ServiceHandler", "Couldn't get any data from the url");
					}

					return contactList;
	}
	
	public static Contact parseDetails(Contact contact) {
		String url = contact.getDeatilsURL();
		
		ServiceHandler sh = new ServiceHandler();
		
		// Making a request to url and getting response
		String jsonStr = sh.makeServiceCall(url, ServiceHandler.GET);

		Log.d("Response: ", "> " + jsonStr);

		if (jsonStr != null) {
			try {
				
					JSONObject d = new JSONObject(jsonStr);
					
					contact.setFav(d.getBoolean("favorite"));
					contact.setLrgIMG(d.getString("largeImageURL"));
					contact.setEmail(d.getString("email"));
					contact.setWebsite(d.getString("website"));
					
					JSONObject address = d.getJSONObject("address");
					contact.setStreet(address.getString("street"));
					contact.setCity(address.getString("city"));
					contact.setState(address.getString("state"));
					contact.setCountry(address.getString("country"));
					contact.setZip(address.getString("zip"));
					contact.setLat(address.getLong("latitude"));
					contact.setLongi(address.getLong("longitude"));

				
			} catch (JSONException e) {
				e.printStackTrace();
			}
		} else {
			Log.e("ServiceHandler", "Couldn't get any data from the url");
		}


		return contact;
	}
}
