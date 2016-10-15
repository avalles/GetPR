package com.trafalascode.getpr;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

public class SignUp extends AppCompatActivity {

    EditText email, pass;
    Button signUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        email = (EditText)findViewById(R.id.signUpEmailEditText);
        pass = (EditText)findViewById(R.id.signUpPassEditText);
        signUp = (Button)findViewById(R.id.signUpButton);

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onSignUpPressed();
            }
        });

    }

    public void onSignUpPressed(){
        ParseUser user = new ParseUser();
        user.setUsername("test");
        user.setEmail(email.getText().toString());
        user.setPassword(pass.getText().toString());

        user.signUpInBackground(new SignUpCallback() {
            @Override
            public void done(ParseException e) {
                if(e==null){
                    Toast.makeText(SignUp.this, "User signed up", Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(SignUp.this, "Error: " + e.getMessage(), Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
