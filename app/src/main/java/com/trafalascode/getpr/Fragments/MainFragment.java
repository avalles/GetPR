package com.trafalascode.getpr.Fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.trafalascode.getpr.MainActivity;
import com.trafalascode.getpr.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment {

    Button login, signup;
    MainActivity mainActivity;

    public MainFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        mainActivity = (MainActivity)context;
        super.onAttach(context);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);

        login = (Button)rootView.findViewById(R.id.login);
        signup = (Button)rootView.findViewById(R.id.signup);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainActivity.viewPager.setCurrentItem(0);
            }
        });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainActivity.viewPager.setCurrentItem(2);
            }
        });

        return rootView;
    }

}
