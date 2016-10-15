package com.trafalascode.getpr;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.trafalascode.getpr.Adapters.EventListAdapter;

import java.util.List;

public class EventList extends AppCompatActivity {

    ListView eventList;
    EventListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_list);

        eventList = (ListView)findViewById(R.id.eventListListView);

        adapter = new EventListAdapter(this);
        eventList.setAdapter(adapter);

        ParseQuery<ParseObject> query = new ParseQuery<>("event");
        query.findInBackground(new FindCallback<ParseObject>() {
            @Override
            public void done(List<ParseObject> objects, ParseException e) {
                adapter.setData(objects);
            }
        });

    }
}
