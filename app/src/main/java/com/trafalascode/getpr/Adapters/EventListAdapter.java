package com.trafalascode.getpr.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.parse.ParseObject;
import com.trafalascode.getpr.R;

import java.util.List;

/**
 * Created by Luis on 10/15/2016.
 */

public class EventListAdapter extends BaseAdapter {

    Context context;
    LayoutInflater inflater = null;
    List<ParseObject> Events;

    public EventListAdapter(Context context){
        this.context = context;
        inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public void setData(List<ParseObject> Events) {
        this.Events = Events;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return (Events == null) ? 0 : Events.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View rowView = inflater.inflate(R.layout.row_event, viewGroup, false);
        TextView title;
        TextView description;
        title = (TextView) rowView.findViewById(R.id.eventTitle);
        description = (TextView) rowView.findViewById(R.id.eventDescription);
        title.setText(Events.get(i).getString("eventName"));
        description.setText(Events.get(i).getString("description"));
        return rowView;
    }
}
