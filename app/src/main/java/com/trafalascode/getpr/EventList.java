package com.trafalascode.getpr;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.trafalascode.getpr.Adapters.EventListAdapter;

import java.util.List;

public class EventList extends AppCompatActivity {

    ListView eventList;
    EventListAdapter adapter;
    Button west;
    Button north;
    Button east;
    Button south;
    Button metro;
    int pressed = 0;

    ImageView mapImage;

    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_list);

        eventList = (ListView)findViewById(R.id.eventListListView);
        west = (Button)findViewById(R.id.westButton);
        north = (Button)findViewById(R.id.northButton);
        east = (Button)findViewById(R.id.eastButton);
        south = (Button)findViewById(R.id.southButton);
        metro = (Button)findViewById(R.id.metroButton);
        mapImage = (ImageView)findViewById(R.id.mapImageView);

        progressBar = (ProgressBar)findViewById(R.id.progressBar);

        adapter = new EventListAdapter(this);
        eventList.setAdapter(adapter);

        west.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (pressed != 1) {
                    mapImage.setImageResource(R.drawable.oeste);
                    pressed = 1;
                } else {
                    mapImage.setImageResource(R.drawable.vacio);
                    pressed = 0;
                }
            }
        });

        north.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (pressed != 2) {
                    mapImage.setImageResource(R.drawable.norte);
                    pressed = 2;
                } else {
                    mapImage.setImageResource(R.drawable.vacio);
                    pressed = 0;
                }
            }
        });

        east.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (pressed != 3) {
                    mapImage.setImageResource(R.drawable.este);
                    pressed = 3;
                } else {
                    mapImage.setImageResource(R.drawable.vacio);
                    pressed = 0;
                }
            }
        });

        south.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (pressed != 4) {
                    mapImage.setImageResource(R.drawable.sur);
                    pressed = 4;
                }
                else {
                    mapImage.setImageResource(R.drawable.vacio);
                    pressed = 0;
                }
            }
        });

        metro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (pressed != 5) {
                    mapImage.setImageResource(R.drawable.metro);
                    pressed = 5;
                } else {
                    mapImage.setImageResource(R.drawable.vacio);
                    pressed = 0;
                }
            }
        });

        ParseQuery<ParseObject> query = new ParseQuery<>("event");
        query.findInBackground(new FindCallback<ParseObject>() {
            @Override
            public void done(List<ParseObject> objects, ParseException e) {
                adapter.setData(objects);
                progressBar.setVisibility(View.GONE);

            }
        });

    }
}
