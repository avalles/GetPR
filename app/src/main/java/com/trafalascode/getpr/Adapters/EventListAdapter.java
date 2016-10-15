package com.trafalascode.getpr.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.trafalascode.getpr.R;

/**
 * Created by Luis on 10/15/2016.
 */

public class EventListAdapter extends BaseAdapter {

    Context context;
    LayoutInflater inflater = null;

    public EventListAdapter(Context context){
        this.context = context;
        inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }


    @Override
    public int getCount() {
        return 4;
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

        return rowView;
    }
}
