package com.trafalascode.getpr;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.VideoView;

import com.parse.Parse;
import com.trafalascode.getpr.Adapters.MainPagerAdapter;
import com.trafalascode.getpr.Utility.CustomViewPager;

public class MainActivity extends AppCompatActivity {

    VideoView videoView;

    public CustomViewPager viewPager;
    MainPagerAdapter adapter;

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

        viewPager = (CustomViewPager)findViewById(R.id.container);

        adapter = new MainPagerAdapter(getSupportFragmentManager());

        viewPager.setAdapter(adapter);

        viewPager.setCurrentItem(1);

        viewPager.setPagingEnabled(false);


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


    public void signup(View view) {
        Intent intent = new Intent(this, SignUp.class);
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {

        if(viewPager.getCurrentItem() == 0){
            viewPager.setCurrentItem(1);
        }else if(viewPager.getCurrentItem() == 2){
            viewPager.setCurrentItem(1);
        }

//        super.onBackPressed();
    }
}
