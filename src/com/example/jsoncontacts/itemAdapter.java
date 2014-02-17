package com.example.jsoncontacts;


import com.example.jsoncontacts.R;
import java.util.ArrayList;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class itemAdapter extends BaseAdapter{

	private Activity activity;
    private ArrayList<Contact> contacts;
    private static LayoutInflater inflater=null;
    public ImageLoader imageLoader;
 
    public itemAdapter(Activity a, ArrayList<Contact> c) {
        activity = a;
        contacts= c;
        inflater = (LayoutInflater)activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        imageLoader=new ImageLoader(activity.getApplicationContext());
    }
    
	@Override
	public int getCount() {
		return contacts.size();
	}

	@Override
	public Object getItem(int position) {
		return position;
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View vi=convertView;
        if(convertView==null)
            vi = inflater.inflate(R.layout.list_item, null);
 
        TextView name = (TextView)vi.findViewById(R.id.name); // title
        TextView mobile = (TextView)vi.findViewById(R.id.mobile_label); // artist name
        ImageView thumb_image=(ImageView)vi.findViewById(R.id.thumb); // thumb image

        
        Contact contact = contacts.get(position);
 
        // Setting all values in listview
        name.setText(contact.getName());
        if(!contact.getPhone_mobile().equals("")){
        	mobile.setText("Mobile: " + contact.getPhone_mobile());
        }
        else if(!contact.getPhone_home().equals("")){
            mobile.setText("Home: " + contact.getPhone_home());
        }
        else if(!contact.getPhone_work().equals("")){
            mobile.setText("Work: " + contact.getPhone_work());
        }
        else{
        	mobile.setText("");
        }
        
        imageLoader.DisplayImage(contact.getSmlIMG(), thumb_image);
        
        
        return vi;
	}

}
