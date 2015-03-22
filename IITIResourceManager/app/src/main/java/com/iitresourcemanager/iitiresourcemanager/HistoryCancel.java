package com.iitresourcemanager.iitiresourcemanager;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import java.util.List;


public class HistoryCancel extends ActionBarActivity {

    private ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cancel_history);
        lv = (ListView) findViewById(R.id.lv_cancel_history);
        HistoryEntryDataSource p=new HistoryEntryDataSource(getApplicationContext());
        p.open();
        List<HistoryEntryData> all=p.getAllHistoryEntryData();
        HistoryCancelAdapter adapter = new HistoryCancelAdapter(getApplicationContext());
        adapter.addAll(all);
        lv.setAdapter(adapter);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_history, menu);
        return true;
    }

    @Override
    public void onBackPressed() {
        Intent i = new Intent(this, AdminMainActivity.class);
        startActivity(i);
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
