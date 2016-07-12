package com.example.aaronyamil.androidproject.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.aaronyamil.androidproject.PostFragment;
import com.example.aaronyamil.androidproject.http.UserFragment;


/**
 * Created by AaronYamil on 6/15/2016.
 */
public class ViewPagerAdapter extends FragmentStatePagerAdapter {
    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    //position es el fragmento a visualizar como tabs
    public Fragment getItem(int position) {

        switch (position){
            case 0:
                return new PostFragment();
            case 1:
                return new UserFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        //numero de tabs a tener
        return 2;
    }
}
