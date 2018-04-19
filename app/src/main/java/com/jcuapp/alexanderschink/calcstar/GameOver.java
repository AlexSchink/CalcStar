package com.jcuapp.alexanderschink.calcstar;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class GameOver extends AppCompatActivity {
    private SharedPreferences preferences;
    public TextView scoreView;
    public EditText editName;
    public Button buttonHighscore;
    public Button buttonAddScore;
    public Button buttonTwitter;
    private DatabaseHandler db;

    public String currentScore;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gameover);

        db = new DatabaseHandler(this);

        scoreView = (TextView) findViewById(R.id.scoreView);
        buttonAddScore = (Button) findViewById(R.id.buttonAddScore);
        buttonHighscore = (Button) findViewById(R.id.buttonHighscore);
        buttonTwitter = (Button) findViewById(R.id.buttonTwitter);

        editName = (EditText) findViewById(R.id.editName);


        preferences = getSharedPreferences("CalcStar", MODE_PRIVATE);
        currentScore = preferences.getString("score", "");

        scoreView.setText(currentScore);



        //OnClickListener to add score of lost game to database
        buttonAddScore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    db.addScore(Integer.parseInt(currentScore), String.valueOf(editName.getText()));

                    Toast.makeText(GameOver.this, "Score saved", Toast.LENGTH_SHORT).show();


            }
        });




        //move to activity Hiscores
        final Intent intentHighscore = new Intent(this, Highscore.class);

        buttonHighscore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(intentHighscore);
            }
        });

        //start tweeting
        final Intent intentTweet = new Intent(this, Tweet.class);
        buttonTwitter.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {

                startActivity(intentTweet);
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
