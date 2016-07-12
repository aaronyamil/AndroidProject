package com.example.aaronyamil.androidproject.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by AaronYamil on 7/8/2016.
 */
public class User {
    private int id;
    private String username;
    private String email;
    private String password;
    private String picture_url;
    private List<Post> post;

    public User() {
        id = 0;
        username = "";
        email = "";
        password = "";
        picture_url = "";
        post = new ArrayList<Post>();
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPictureUrl() {
        return picture_url;
    }

    public void setPictureUrl(String pictureUrl) {
        this.picture_url = pictureUrl;
    }
}

