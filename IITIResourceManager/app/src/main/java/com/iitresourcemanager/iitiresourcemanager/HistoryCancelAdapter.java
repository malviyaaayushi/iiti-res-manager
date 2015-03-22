package com.iitresourcemanager.iitiresourcemanager;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by aayushi on 17/3/15.
 */
public class HistoryCancelAdapter extends ArrayAdapter<HistoryEntryData> {
    public HistoryCancelAdapter(Context context) {
        super(context, R.layout.history_item);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;
        if (v == null) {
            LayoutInflater vi = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = vi.inflate(R.layout.history_cancel_item, null,false);
        }
        TextView roll = (TextView) v.findViewById(R.id.hist_cancel_rollno);
        TextView date = (TextView) v.findViewById(R.id.hist_cancel_date);
        TextView item = (TextView) v.findViewById(R.id.hist_cancel_item);
        TextView time = (TextView) v.findViewById(R.id.hist_cancel_time);
        TextView id = (TextView) v.findViewById(R.id.hist_cancel_id);
        Button cancel = (Button) v.findViewById(R.id.hist_cancel_button);

        final HistoryEntryData data = getItem(position);
        roll.setText(data.getRollNumber());
        date.setText(data.getDate());
        item.setText(data.getItem());
        time.setText(data.getTime());
        id.setText("#"+data.getColumnId());

        final Intent i = new Intent(v.getContext(), HistoryCancel.class);
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        final HistoryEntryDataSource p=new HistoryEntryDataSource(getContext());

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                p.open();
                p.delete(Long.toString(data.getColumnId()));
                p.close();
                v.getContext().startActivity(i);
            }
        });

        return v;
    }
}
