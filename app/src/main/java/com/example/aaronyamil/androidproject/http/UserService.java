package com.example.aaronyamil.androidproject.http;


import com.example.aaronyamil.androidproject.model.User;


import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by AaronYamil on 6/15/2016.
 */
public interface UserService {
    @GET("users")
    Call<List<User>> getUsers();
}
