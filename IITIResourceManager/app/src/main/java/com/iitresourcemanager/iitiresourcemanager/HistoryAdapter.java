package com.iitresourcemanager.iitiresourcemanager;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by aayushi on 17/3/15.
 */
public class HistoryAdapter extends ArrayAdapter<HistoryEntryData> {
    public HistoryAdapter(Context context) {
        super(context, R.layout.history_item);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;
        if (v == null) {
            LayoutInflater vi = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = vi.inflate(R.layout.history_item, null,false);
        }
        TextView roll = (TextView) v.findViewById(R.id.hist_rollno);
        TextView date = (TextView) v.findViewById(R.id.hist_date);
        TextView item = (TextView) v.findViewById(R.id.hist_item);
        TextView time = (TextView) v.findViewById(R.id.hist_time);
        TextView id = (TextView) v.findViewById(R.id.hist_id);
        HistoryEntryData data = getItem(position);
        roll.setText(data.getRollNumber());
        date.setText(data.getDate());
        item.setText(data.getItem());
        time.setText(data.getTime());
        id.setText("#"+data.getColumnId());
        return v;
    }
}
