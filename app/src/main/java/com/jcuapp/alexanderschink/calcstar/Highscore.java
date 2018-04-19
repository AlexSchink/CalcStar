package com.jcuapp.alexanderschink.calcstar;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.TextView;


public class Highscore extends AppCompatActivity {

    private DatabaseHandler db;
    public TextView highscoreView;
    private GridView highscoreGrid;
    private ArrayAdapter<String> highscores;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_highscore);


       // getting access to the database
        db = new DatabaseHandler(this);

        highscores = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1);

        highscoreGrid = (GridView) findViewById(R.id.highscoreGrid);
        highscoreGrid.setAdapter(highscores);

        //getting all values of the database
        String[] scores = db.getAllScores();

        //displaying the values of the database in the gridview using the adapter 'highscores'
        int i = 1;
        for (String sc : scores) {

            highscores.add(String.valueOf(i) + ". " + sc);
            i++;
        }


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
            Intent intentSettings = new Intent(this, Settings.class);
            startActivity(intentSettings);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
