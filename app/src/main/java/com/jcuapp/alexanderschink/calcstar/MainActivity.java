package com.jcuapp.alexanderschink.calcstar;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {

    private SharedPreferences preferences;
    private Button buttonEasy;
    private Button buttonMedium;
    private Button buttonHard;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        buttonEasy = (Button) findViewById(R.id.buttonEasy);
        buttonMedium = (Button) findViewById(R.id.buttonMedium);
        buttonHard = (Button) findViewById(R.id.buttonHard);





    }

    @Override
    protected void onStart() {
        super.onStart();
        preferences = getSharedPreferences("CalcStar", MODE_PRIVATE);
        final Intent intentGame = new Intent(MainActivity.this, GameScreen.class);

        //according to which button is pressed the level is saved (to be able to call the right method later)
        // and the game starts

        buttonEasy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                preferences.edit().putString("Level", "easy").apply();
                startActivity(intentGame);

            }
        });

        buttonMedium.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                preferences.edit().putString("Level", "medium").apply();
                startActivity(intentGame);

            }

        });
        buttonHard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                preferences.edit().putString("Level", "hard").apply();
                startActivity(intentGame);

            }
        });


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
        if (id == R.id.action_highscore) {
            Intent intentHighscore = new Intent(this, Highscore.class);
            startActivity(intentHighscore);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
