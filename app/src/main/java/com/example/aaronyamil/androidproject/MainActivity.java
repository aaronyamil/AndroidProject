package com.example.aaronyamil.androidproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.aaronyamil.androidproject.http.LoginAsyncTask;
import com.example.aaronyamil.androidproject.model.User;

public class MainActivity extends AppCompatActivity {
    private EditText usernameEditText;
    private EditText passwordEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        usernameEditText = (EditText)findViewById(R.id.username_text);
        passwordEditText = (EditText)findViewById(R.id.password_text);
    }

    public void onLogin(View view) {
        String username = usernameEditText.getText().toString();
        String password = passwordEditText.getText().toString();
        //RequestUsersAsyncTask task = new RequestUsersAsyncTask();
        //task.execute();
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);

        LoginAsyncTask task = new LoginAsyncTask(this);
        task.execute(user);
    }
}
