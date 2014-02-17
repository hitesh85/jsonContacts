package com.example.jsoncontacts;


import java.text.SimpleDateFormat;
import java.util.Calendar;

import android.os.Parcel;
import android.os.Parcelable;

public class Contact implements Parcelable{

	private String name;
	private int employeeID;
	private String company;
	private String deatilsURL;
	private boolean isFav;
	private String lrgIMG;
	private String email;
	private String website;
	private String street;
	private String city;
	private String state;
	private String country;
	private String zip;
	private long lat;
	private long longi;
	private String smlIMG;
	private String bday;
	private String phone_work;
	private String phone_home;
	private String phone_mobile;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getEmployeeID() {
		return employeeID;
	}
	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getDeatilsURL() {
		return deatilsURL;
	}
	public void setDeatilsURL(String deatilsURL) {
		this.deatilsURL = deatilsURL;
	}
	public boolean isFav() {
		return isFav;
	}
	public void setFav(boolean isFav) {
		this.isFav = isFav;
	}
	public String getLrgIMG() {
		return lrgIMG;
	}
	public void setLrgIMG(String lrgIMG) {
		this.lrgIMG = lrgIMG;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public long getLat() {
		return lat;
	}
	public void setLat(long lat) {
		this.lat = lat;
	}
	public long getLongi() {
		return longi;
	}
	public void setLongi(long longi) {
		this.longi = longi;
	}
	public String getSmlIMG() {
		return smlIMG;
	}
	public void setSmlIMG(String smlIMG) {
		this.smlIMG = smlIMG;
	}
	public String getBday() {
		return bday;
	}
	public void setBday(String bday) {
		Calendar calendar = Calendar.getInstance();
		Long timeInMillis = Long.valueOf(bday);
		calendar.setTimeInMillis(timeInMillis);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		String date = sdf.format(calendar.getTime()); 
		
		this.bday = date;
	}
	public String getPhone_work() {
		return phone_work;
	}
	public void setPhone_work(String phone_work) {
		this.phone_work = phone_work;
	}
	public String getPhone_home() {
		return phone_home;
	}
	public void setPhone_home(String phone_home) {
		this.phone_home = phone_home;
	}
	public String getPhone_mobile() {
		return phone_mobile;
	}
	public void setPhone_mobile(String phone_mobile) {
		this.phone_mobile = phone_mobile;
	}
	
	
	@Override
	public int describeContents() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public void writeToParcel(Parcel out, int flags) {
		out.writeString(name);
		out.writeInt(employeeID);
		out.writeString(company);
		out.writeString(deatilsURL);
		out.writeByte((byte) (isFav ? 1 : 0));
		out.writeString(lrgIMG);
		out.writeString(email);
		out.writeString(website);
		out.writeString(street);
		out.writeString(city);
		out.writeString(state);
		out.writeString(country);
		out.writeString(zip);
		out.writeLong(lat);
		out.writeLong(longi);
		out.writeString(smlIMG);
		out.writeString(bday);
		out.writeString(phone_work);
		out.writeString(phone_home);
		out.writeString(phone_mobile);
	}
	
	public static final Parcelable.Creator<Contact> CREATOR = new Parcelable.Creator<Contact>() {
        public Contact createFromParcel(Parcel in) {
            return new Contact(in);
        }

        public Contact[] newArray(int size) {
            return new Contact[size];
        }
    };
	
    private Contact(Parcel in) {
        name = in.readString();
        employeeID = in.readInt();
        company = in.readString();
        deatilsURL = in.readString();;
    	isFav = in.readByte() != 0;
    	lrgIMG = in.readString();
    	email = in.readString();
    	website = in.readString();
    	street = in.readString();
    	city = in.readString();
    	state = in.readString();
    	country = in.readString();
    	zip = in.readString();
    	lat = in.readLong();
    	longi = in.readLong();
    	smlIMG = in.readString();
    	bday = in.readString();
    	phone_work = in.readString();
    	phone_home = in.readString();
    	phone_mobile = in.readString();
    }
    
	public Contact() {
		super();
		this.name = "";
		this.employeeID = 0;
		this.company = "";
		this.deatilsURL = "";
		this.isFav = false;
		this.lrgIMG = "";
		this.email = "";
		this.website = "";
		this.street = "";
		this.city = "";
		this.state = "";
		this.country = "";
		this.zip = "";
		this.lat = 0;
		this.longi = 0;
		this.smlIMG = "";
		this.bday = "";
		this.phone_work = "";
		this.phone_home = "";
		this.phone_mobile = "";
	}
}
