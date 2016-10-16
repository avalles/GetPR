package com.trafalascode.getpr;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.VideoView;

import com.parse.Parse;

public class MainActivity extends AppCompatActivity {

    VideoView videoView;

    @Override
    protected void onResume() {
        super.onResume();

        if(videoView != null){
            String uriPath = "android.resource://"+getPackageName()+"/" + + R.raw.getpr;
            Uri uri = Uri.parse(uriPath);
            videoView.setVideoURI(uri);
            videoView.start();


            /**
             * Set the video loop infinitely
             */
            videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mp) {
                    mp.setLooping(true);
                }
            });
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);

        setContentView(R.layout.activity_main);

        Parse.initialize(new Parse.Configuration.Builder(this)
        .applicationId("7oYbPZwkqpIvKxgrYis6BtBz2cygQRlBTmqK2Ufv")
        .clientKey("51h9KKW4eciUoZRl09qD7hcilttHkE1UVC0yyeeJ")
        .server("https://parseapi.back4app.com/")
        .build());

        videoView = (VideoView)findViewById(R.id.videoView);
        String uriPath = "android.resource://"+getPackageName()+"/" + R.raw.getpr;
        Uri uri = Uri.parse(uriPath);
        videoView.setVideoURI(uri);
        videoView.start();

        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.setLooping(true);
            }
        });

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
