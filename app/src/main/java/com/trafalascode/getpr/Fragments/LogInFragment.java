package com.trafalascode.getpr.Fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.trafalascode.getpr.EventList;
import com.trafalascode.getpr.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class LogInFragment extends Fragment {

    Button login;

    public LogInFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View rootView = inflater.inflate(R.layout.fragment_log_in, container, false);

        login = (Button)rootView.findViewById(R.id.loginButton);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), EventList.class);
                startActivity(intent);
            }
        });

        return rootView;
    }

}
