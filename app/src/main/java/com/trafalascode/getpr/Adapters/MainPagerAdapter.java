package com.trafalascode.getpr.Adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.trafalascode.getpr.Fragments.LogInFragment;
import com.trafalascode.getpr.Fragments.MainFragment;
import com.trafalascode.getpr.Fragments.SignUpFragment;

/**
 * Created by Luis on 10/15/2016.
 */

public class MainPagerAdapter extends FragmentPagerAdapter {

    public MainPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {

        MainFragment mainFragment = new MainFragment();
        SignUpFragment signUpFragment = new SignUpFragment();
        LogInFragment logInFragment = new LogInFragment();

        switch (position){
            case 0: return logInFragment;

            case 1: return mainFragment;

            case 2: return signUpFragment;
        }

        return null;

    }

    @Override
    public int getCount() {
        return 3;
    }
}
