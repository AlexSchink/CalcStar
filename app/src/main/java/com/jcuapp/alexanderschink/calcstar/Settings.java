package com.jcuapp.alexanderschink.calcstar;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CompoundButton;
import android.widget.Switch;


public class Settings extends AppCompatActivity {

    public Switch switchMusic;
    private SoundManager soundManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        soundManager = new SoundManager(this);


        switchMusic = (Switch) findViewById(R.id.switchMusic);

    }


    @Override
    protected void onResume() {
        super.onResume();

        SharedPreferences sharedPrefs = getSharedPreferences("CalcStar", MODE_PRIVATE);
        switchMusic.setChecked(sharedPrefs.getBoolean("switchState", false));


        //depending on the state of the switch: turn background music on or off
        switchMusic.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (switchMusic.isChecked()) {
                    soundManager.play();
                } else {
                    soundManager.stop();
                }

                checkSwitch();
            }
        });
    }


    //write the state of the switch in the shared preferences to be able to recall the state later
    public void checkSwitch() {

        if (switchMusic.isChecked()) {
            SharedPreferences.Editor editor = getSharedPreferences("CalcStar", MODE_PRIVATE).edit();
            editor.putBoolean("switchState", true);
            editor.apply();


        } else {
            SharedPreferences.Editor editor = getSharedPreferences("CalcStar", MODE_PRIVATE).edit();
            editor.putBoolean("switchState", false);
            editor.apply();

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
        if (id == R.id.action_highscore) {
            Intent intentHighscore = new Intent(this, Highscore.class);
            startActivity(intentHighscore);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}
