package com.example.aaronyamil.androidproject.http;

import android.os.AsyncTask;

import com.example.aaronyamil.androidproject.PostFragment;
import com.example.aaronyamil.androidproject.model.Post;
import com.example.aaronyamil.androidproject.model.User;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by AaronYamil on 6/15/2016.
 */
//recogera los post y lo metera al listview
public class RetrievePostsAsyncTask extends AsyncTask<Void, Void, List<Post>>{
    private PostFragment fragment;

    public RetrievePostsAsyncTask(PostFragment postFragment) {
        this.fragment = postFragment;
    }

    @Override
    protected List<Post> doInBackground(Void... params) {
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("http://dip-androiducbv2.herokuapp.com/")
                .build();

        PostsService service = retrofit.create(PostsService.class);
        Call<List<Post>> call = service.getPosts();


        try {
            Response<List<Post>> response = call.execute();
            return  response.body();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new ArrayList<>();

    }

    @Override
    protected void onPostExecute(List<Post> posts) {
        fragment.getAdapter().clear();
        User user = posts.get(0).getUser();
        fragment.getAdapter().addAll(posts);
    }
}
