package com.example.cobaspeech;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ContactListsAdapter extends BaseAdapter {
    private ArrayList<ContactListModel> data;
    private Activity activity;
    public ContactListsAdapter(Activity a, ArrayList<ContactListModel> d) {
        activity = a;
        data = d;
    }
    public int getCount() {
        return data.size();
    }
    public Object getItem(int position) {
        return data.get(position);
    }
    public long getItemId(int position) {
        return position;
    }
    public View getView(int position, View convertView, ViewGroup parent) {
        final ContactListModel data = (ContactListModel) getItem(position);
        convertView = LayoutInflater.from(activity).inflate(R.layout.listview_contact_list, parent,false);
        TextView nama = (TextView) convertView.findViewById(R.id.label);
        TextView notelp = (TextView) convertView.findViewById(R.id.sublabel);
        nama.setText(data.getNama());
        notelp.setText(data.getNotelp());
        return convertView;
    }
}
