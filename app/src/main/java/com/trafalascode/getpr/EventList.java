package com.trafalascode.getpr;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.trafalascode.getpr.Adapters.EventListAdapter;

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



    }
}
