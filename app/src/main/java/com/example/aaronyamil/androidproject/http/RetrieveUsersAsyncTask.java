package com.example.aaronyamil.androidproject.http;




import android.os.AsyncTask;

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
public class RetrieveUsersAsyncTask extends AsyncTask<Void, Void, List<User>> {
    private UserFragment fragment;

    public RetrieveUsersAsyncTask(UserFragment userFragment) {
        this.fragment = userFragment;
    }

    @Override
    protected List<User> doInBackground(Void... params) {
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("http://dip-androiducbv2.herokuapp.com/")
                .build();

        UserService service = retrofit.create(UserService.class);
        Call<List<User>> call = service.getUsers();


        try {
            Response<List<User>> response = call.execute();
            return  response.body();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new ArrayList<>();

    }
    @Override
    protected void onPostExecute(List<User> users) {
        fragment.getAdapter().clear();
        fragment.getAdapter().addAll(users);
    }
}
