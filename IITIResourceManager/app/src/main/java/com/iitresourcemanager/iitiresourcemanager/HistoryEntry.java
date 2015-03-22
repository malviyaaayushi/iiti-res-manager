package com.iitresourcemanager.iitiresourcemanager;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class HistoryEntry extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history_entry);
        final EditText rn=(EditText)findViewById(R.id.rollno);
        final Spinner it=(Spinner)findViewById(R.id.item);
        final EditText tm=(EditText)findViewById(R.id.time);
        final EditText dt=(EditText)findViewById(R.id.date);
        final Spinner tp=(Spinner)findViewById(R.id.type);


        Button add=(Button)findViewById(R.id.add);
        final HistoryEntryDataSource p=new HistoryEntryDataSource(this);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String rollNumber=rn.getText().toString();
                final String item=it.getSelectedItem().toString();
                final String time=tm.getText().toString();
                final String date=dt.getText().toString();
                final String type=tp.getSelectedItem().toString();
                p.open();
                p.insert(rollNumber,item,time,date,type);
                onBackPressed();
            }
        });

    }

    @Override
    public void onBackPressed() {
        Intent i = new Intent(this, AdminMainActivity.class);
        startActivity(i);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_history_entry, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
