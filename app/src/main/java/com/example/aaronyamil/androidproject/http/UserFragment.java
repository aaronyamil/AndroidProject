package com.example.aaronyamil.androidproject.http;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.aaronyamil.androidproject.R;
import com.example.aaronyamil.androidproject.adapter.UserAdapter;

/**
 * Created by AaronYamil on 6/16/2016.
 */
public class UserFragment extends Fragment {
    private ListView listView;
    private UserAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_post, container, false);
        listView = (ListView)view.findViewById(R.id.posts_list_view);
        adapter = new UserAdapter(getActivity());
        listView.setAdapter(adapter);

        RetrieveUsersAsyncTask task = new RetrieveUsersAsyncTask(this);
        task.execute();
        // Inflate the layout for this fragment
        return view;
    }

    public UserAdapter getAdapter(){
        return adapter;
    }
}
