package com.example.aaronyamil.androidproject;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.example.aaronyamil.androidproject.adapter.ViewPagerAdapter;

public class DashBoard extends AppCompatActivity {
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board);

        getSupportActionBar().setElevation(0);//por defecto es 21

        tabLayout = (TabLayout)findViewById(R.id.tab_bar);

        tabLayout.addTab(tabLayout.newTab().setText("Post"));
        tabLayout.addTab(tabLayout.newTab().setText("Users"));

        viewPager = (ViewPager) findViewById(R.id.view_pager);
        ViewPagerAdapter adapter =  new ViewPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.logout_option:
                logout();
                return true;
            case R.id.new_post_option:
                createPost();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void createPost() {
        SharedPreferences preferences = getSharedPreferences(
                getString(R.string.app_name), MODE_PRIVATE);
        Intent intent = new Intent(this, CreatePostActivity.class);
        startActivity(intent);
    }

    private void logout() {
        SharedPreferences preferences = getSharedPreferences(
                getString(R.string.app_name), MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.remove("username");
        editor.commit();
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
