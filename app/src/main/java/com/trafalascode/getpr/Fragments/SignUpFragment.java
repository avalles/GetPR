package com.trafalascode.getpr.Fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.trafalascode.getpr.R;
import com.trafalascode.getpr.SetUpProfile;


/**
 * A simple {@link Fragment} subclass.
 */
public class SignUpFragment extends Fragment {

    Button signup;

    public SignUpFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootview = inflater.inflate(R.layout.fragment_sign_up, container, false);

        signup = (Button)rootview.findViewById(R.id.signupButton);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), SetUpProfile.class);
                startActivity(intent);
            }
        });


        return rootview;
    }

}
