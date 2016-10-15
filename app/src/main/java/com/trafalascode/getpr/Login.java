package com.trafalascode.getpr;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;

public class Login extends AppCompatActivity {

    EditText username, pass;
    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = (EditText)findViewById(R.id.loginUsername);
        pass = (EditText)findViewById(R.id.loginPassword);
        login = (Button)findViewById(R.id.loginButton);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onLoginPressed();
            }
        });
    }

    public void onLoginPressed() {
        ParseUser.logInInBackground(username.getText().toString(), pass.getText().toString(), new LogInCallback() {
            @Override
            public void done(ParseUser user, ParseException e) {
                if (e == null && user != null) {
                    Toast.makeText(Login.this, "User successfully logged in.", Toast.LENGTH_LONG).show();
                } else if (user == null) {
                    Toast.makeText(Login.this, "Invalid credentials.", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(Login.this, "Error: " + e.getMessage(), Toast.LENGTH_LONG).show();
                }

            }
        });
    }
}
