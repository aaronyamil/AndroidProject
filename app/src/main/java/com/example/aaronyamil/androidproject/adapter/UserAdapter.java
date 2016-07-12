package com.example.aaronyamil.androidproject.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.aaronyamil.androidproject.R;
import com.example.aaronyamil.androidproject.model.User;


/**
 * Created by AaronYamil on 6/15/2016.
 */

public class UserAdapter extends ArrayAdapter<User> {

    public UserAdapter(Context context){
        super(context, R.layout.user_item_layout);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        User user = getItem(position);
        View currentView;
        if(convertView == null){
            LayoutInflater inflater = LayoutInflater.from(getContext());
            currentView = inflater.inflate(R.layout.user_item_layout, parent,false);
        }else{
            currentView = convertView;
        }

        TextView nametextview = (TextView) currentView.findViewById(R.id.name_text_view);
        TextView emailtextview = (TextView) currentView.findViewById(R.id.email_text_view);

        nametextview.setText(user.getUsername());
        emailtextview.setText(user.getEmail());

        return currentView;
    }
}
