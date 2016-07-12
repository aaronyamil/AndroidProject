package com.example.aaronyamil.androidproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.aaronyamil.androidproject.http.PostAsyncTask;
import com.example.aaronyamil.androidproject.model.Post;

public class CreatePostActivity extends AppCompatActivity {

    private EditText title;
    private EditText content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_post);

        this.title = (EditText)findViewById(R.id.title_post);
        this.content = (EditText)findViewById(R.id.content_post);
    }

    public void createPost(View view) {
        Post post = new Post();
        post.setTitle(title.getText().toString());
        post.setContent(content.getText().toString());

        PostAsyncTask task = new PostAsyncTask(this);
        task.execute(post);
    }
}
