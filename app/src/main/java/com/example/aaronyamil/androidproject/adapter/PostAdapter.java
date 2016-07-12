package com.example.aaronyamil.androidproject.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.aaronyamil.androidproject.R;
import com.example.aaronyamil.androidproject.model.Post;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by AaronYamil on 6/15/2016.
 */
public class PostAdapter extends ArrayAdapter<Post> {
    public PostAdapter(Context context){
        super(context, R.layout.post_item_layout);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Post oPost = getItem(position);
        View currentView;
        if(convertView == null){
            LayoutInflater inflater = LayoutInflater.from(getContext());
            currentView = inflater.inflate(R.layout.post_item_layout, parent,false);
        }else{
            currentView = convertView;
        }

        TextView titletextview = (TextView) currentView.findViewById(R.id.title_text_view);
        TextView contenttextview = (TextView) currentView.findViewById(R.id.content_text_view);
        CircleImageView profileImageView = (CircleImageView) currentView.findViewById(R.id.profile_image_view);

        titletextview.setText(oPost.getTitle());
        contenttextview.setText(oPost.getContent());
        //instalar el glide
        Glide.with(getContext()).load(oPost.getUser().getPictureUrl()).into(profileImageView);

        return currentView;
    }


}
