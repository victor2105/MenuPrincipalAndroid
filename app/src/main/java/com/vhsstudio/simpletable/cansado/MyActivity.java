package com.vhsstudio.simpletable.cansado;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;


public class MyActivity extends Activity {

    GridView gridview;

    final String EXTRA_TABLE_NAME = "table_name";
    final String EXTRA_TABLE_ID = "table_id";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);


        gridview = (GridView) findViewById(R.id.gridview);
        gridview.setAdapter(new AdapterTable(this, R.layout.table, Control.getInstance().getAllComments()));

        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            //public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
            //    Toast.makeText(MyActivity.this, "" + position, Toast.LENGTH_SHORT).show();
            //}

            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                Intent intent = new Intent(MyActivity.this, TableView.class);
                startActivity(intent);
            }

        });

    }

    @Override
    public void onPause() {
        super.onPause();  // Always call the superclass method first

        // Release the Camera because we don't need it when paused
        // and other activities might need to use it.

    }

    @Override
    public void onResume() {
        super.onResume();  // Always call the superclass method first

        // Get the Camera instance as the activity achieves full user focus

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }


    private void newTable (){
        AdapterTable adapter = (AdapterTable) gridview.getAdapter();
        Table table = null;

        String name = "";

        table = Control.getInstance().createTable(name, "2014-11-11", "2014-12-11");

        adapter.add(table);

        adapter.notifyDataSetChanged();
    }

    private void delete(){
        /*AdapterTable adapter = (AdapterTable) listView.getAdapter();
        Table table = null;

        if(listView.getAdapter().getCount() > 0){
            table = (Table) listView.getAdapter().getItem(0);
            tableDAO.deleteTable(table);
            adapter.remove(table);
        }

        adapter.notifyDataSetChanged();
*/
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        if (id == R.id.action_new_table) {
            newTable();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
