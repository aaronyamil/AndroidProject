package com.example.aaronyamil.androidproject.http;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.widget.Toast;

import com.example.aaronyamil.androidproject.MainActivity;
import com.example.aaronyamil.androidproject.R;
import com.example.aaronyamil.androidproject.model.User;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoginAsyncTask extends AsyncTask<User, Void, User> {
    private MainActivity activity;

    public LoginAsyncTask(MainActivity activity) {
        this.activity = activity;
    }

    @Override
    protected User doInBackground(User... params) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://dip-androiducbv2.herokuapp.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        PostsService service = retrofit.create(PostsService.class);
        Call<User> call = service.login(params[0]);
        try {
            Response<User> response = call.execute();
            User user = response.body();

            return user;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(User user) {
        if (user == null) {
            // Codigo de error
            Toast.makeText(activity, "Login unsuccessful", Toast.LENGTH_LONG).show();
        } else {
            // Guardar al usuario en las preferencias
            SharedPreferences sharedPreferences = activity.getSharedPreferences(
                    activity.getString(R.string.app_name),
                    Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putInt("user_id", user.getId());
            Toast.makeText(activity,
                    "Login successful, username: " + user.getUsername(),
                    Toast.LENGTH_LONG).show();
        }
    }



}
