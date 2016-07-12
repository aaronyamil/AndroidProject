package com.example.aaronyamil.androidproject;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.aaronyamil.androidproject.adapter.PostAdapter;
import com.example.aaronyamil.androidproject.http.RetrievePostsAsyncTask;
import com.example.aaronyamil.androidproject.model.Post;

public class PostFragment extends Fragment {
    private ListView listView;
    private PostAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_post, container, false);
        listView = (ListView)view.findViewById(R.id.posts_list_view);
        adapter = new PostAdapter(getActivity());
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Post p = adapter.getItem(position);
                //para ver el detalle del item seleccionado
                Toast.makeText(getActivity(),p.getTitle(), Toast.LENGTH_SHORT).show();
            }
        });

        RetrievePostsAsyncTask task = new RetrievePostsAsyncTask(this);
        task.execute();
        // Inflate the layout for this fragment
        return view;
    }

    public PostAdapter getAdapter(){
        return adapter;
    }
}
