package com.trafalascode.getpr;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.parse.Parse;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Parse.initialize(new Parse.Configuration.Builder(this)
        .applicationId("7oYbPZwkqpIvKxgrYis6BtBz2cygQRlBTmqK2Ufv")
        .clientKey("51h9KKW4eciUoZRl09qD7hcilttHkE1UVC0yyeeJ")
        .server("https://parseapi.back4app.com/")
        .build());
    }

    public void login(View view) {
        Intent intent = new Intent(this, Login.class);
        startActivity(intent);
    }

    public void signup(View view) {
        Intent intent = new Intent(this, SignUp.class);
        startActivity(intent);
    }
}
