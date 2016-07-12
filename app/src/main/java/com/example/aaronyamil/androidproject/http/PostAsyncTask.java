package com.example.aaronyamil.androidproject.http;

import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import com.example.aaronyamil.androidproject.CreatePostActivity;
import com.example.aaronyamil.androidproject.DashBoard;
import com.example.aaronyamil.androidproject.model.Post;


import java.io.IOException;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by AaronYamil on 7/11/2016.
 */

public class PostAsyncTask extends AsyncTask<Post, Void, Post> {
    private CreatePostActivity activity;

    public PostAsyncTask(CreatePostActivity activity) { this.activity = activity;}

    @Override
    protected Post doInBackground(Post... params) {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://dip-androiducbv2.herokuapp.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        PostsService service = retrofit.create(PostsService.class);
        Call<Post> call = service.create(params[0]);
        try{
            Response<Post> response = call.execute();
            Post post = response.body();
            Log.d("CreatePostActivity","pruebas2" + post);
            return post;
        }catch (IOException e2) {
            e2.printStackTrace();
        }

        return null;
    }

    @Override
    protected void onPostExecute(Post post) {
        if (post == null) {
            // Codigo de error
            Toast.makeText(activity, "Create unsuccessful", Toast.LENGTH_LONG).show();
        } else {

            Toast.makeText(activity,
                    "Create post successful",
                    Toast.LENGTH_LONG).show();
            Intent intent = new Intent(activity, DashBoard.class);
            activity.startActivity(intent);
        }
    }
}
