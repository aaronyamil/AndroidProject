package com.example.aaronyamil.androidproject.http;

import com.example.aaronyamil.androidproject.model.Post;
import com.example.aaronyamil.androidproject.model.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface PostsService {
    @GET("/users.json")
    Call<List<User>> getAllUsers();
    @POST("/login.json")
    Call<User> login(@Body User user);
    @GET("posts?user_id=1")
    Call<List<Post>> getPosts();
    @POST("posts?user_id=2")
    Call<Post> create(@Body Post post);
}
