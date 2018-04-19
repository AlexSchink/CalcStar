package com.jcuapp.alexanderschink.calcstar;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;


public class GameScreen extends AppCompatActivity {


    public SharedPreferences preferences;
    private static final Random randomGen = new Random();
    public TextView equationView;
    public TextView scoreView;
    public int aux1;
    public int aux2;
    public int aux3;
    public int aux4;
    public int scorecount;

    public String equation1;
    public Button[] buttonAnswer;
    public Vibrator vibrator;
    public SensorManager mSensorManager;
    public ShakeEventListener mSensorListener;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gamescreen);



        equationView = (TextView) findViewById(R.id.equationView);
        scoreView = (TextView) findViewById(R.id.scoreView);

        vibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);

        //filling the Button Array with the buttons of the layout
        buttonAnswer = new Button[4];
        buttonAnswer[0] = (Button) findViewById(R.id.button0);
        buttonAnswer[1] = (Button) findViewById(R.id.button1);
        buttonAnswer[2] = (Button) findViewById(R.id.button2);
        buttonAnswer[3] = (Button) findViewById(R.id.button3);



        final Intent intentGameover = new Intent(GameScreen.this, GameOver.class);


        mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        mSensorListener = new ShakeEventListener();
        //shaking cancels the game


        mSensorListener.setOnShakeListener(new ShakeEventListener.OnShakeListener() {

            public void onShake() {
                startActivity(intentGameover);
            }
        });


    }

    @Override
    protected void onStart() {
        super.onStart();


        //get the level previously chosen on the main screen
        preferences = getSharedPreferences("CalcStar", MODE_PRIVATE);

        String level = preferences.getString("Level", "");


        //calling the corresponding activity
        switch (level) {

            case "easy":
                Easy();
                break;

            case "medium":
                Medium();
                break;

            case "hard":
                Hard();
                break;
        }



    }

    public void Easy() {

        // generation of random values for calculations
        aux1 = randomGen.nextInt(10) + 1;
        aux2 = randomGen.nextInt(10) + 1;
        aux3 = randomGen.nextInt(2);
        aux4 = randomGen.nextInt(4);

        //decision whether addition or subtraction
        if (aux3 == 0) {

            equation1 = aux1 + " + " + aux2;
            equationView.setText(equation1);

            //assigning the right answer to a random button
            buttonAnswer[aux4].setText(Integer.toString(aux1 + aux2));

            //handling all possible outcomes
            switch (aux4) {

                case 0:
                    aux1 = randomGen.nextInt(10) + 1;
                    aux2 = randomGen.nextInt(10) + 1;
                    buttonAnswer[1].setText(Integer.toString(aux1 + aux2));

                    aux1 = randomGen.nextInt(10) + 1;
                    aux2 = randomGen.nextInt(10) + 1;
                    buttonAnswer[2].setText(Integer.toString(aux1 + aux2));

                    aux1 = randomGen.nextInt(10) + 1;
                    aux2 = randomGen.nextInt(10) + 1;
                    buttonAnswer[3].setText(Integer.toString(aux1 + aux2));
                    break;

                case 1:

                    aux1 = randomGen.nextInt(10) + 1;
                    aux2 = randomGen.nextInt(10) + 1;
                    buttonAnswer[0].setText(Integer.toString(aux1 + aux2));

                    aux1 = randomGen.nextInt(10) + 1;
                    aux2 = randomGen.nextInt(10) + 1;
                    buttonAnswer[2].setText(Integer.toString(aux1 + aux2));

                    aux1 = randomGen.nextInt(10) + 1;
                    aux2 = randomGen.nextInt(10) + 1;
                    buttonAnswer[3].setText(Integer.toString(aux1 + aux2));
                    break;

                case 2:
                    aux1 = randomGen.nextInt(10) + 1;
                    aux2 = randomGen.nextInt(10) + 1;
                    buttonAnswer[0].setText(Integer.toString(aux1 + aux2));

                    aux1 = randomGen.nextInt(10) + 1;
                    aux2 = randomGen.nextInt(10) + 1;
                    buttonAnswer[1].setText(Integer.toString(aux1 + aux2));

                    aux1 = randomGen.nextInt(10) + 1;
                    aux2 = randomGen.nextInt(10) + 1;
                    buttonAnswer[3].setText(Integer.toString(aux1 + aux2));
                    break;

                case 3:
                    aux1 = randomGen.nextInt(10) + 1;
                    aux2 = randomGen.nextInt(10) + 1;
                    buttonAnswer[0].setText(Integer.toString(aux1 + aux2));

                    aux1 = randomGen.nextInt(10) + 1;
                    aux2 = randomGen.nextInt(10) + 1;
                    buttonAnswer[1].setText(Integer.toString(aux1 + aux2));

                    aux1 = randomGen.nextInt(10) + 1;
                    aux2 = randomGen.nextInt(10) + 1;
                    buttonAnswer[2].setText(Integer.toString(aux1 + aux2));
                    break;


            }
        } else {
            equation1 = aux1 + " - " + aux2;
            equationView.setText(equation1);

            buttonAnswer[aux4].setText(Integer.toString(aux1 - aux2));

            switch (aux4) {

                case 0:
                    aux1 = randomGen.nextInt(10) + 1;
                    aux2 = randomGen.nextInt(10) + 1;
                    buttonAnswer[1].setText(Integer.toString(aux1 - aux2));

                    aux1 = randomGen.nextInt(10) + 1;
                    aux2 = randomGen.nextInt(10) + 1;
                    buttonAnswer[2].setText(Integer.toString(aux1 - aux2));

                    aux1 = randomGen.nextInt(10) + 1;
                    aux2 = randomGen.nextInt(10) + 1;
                    buttonAnswer[3].setText(Integer.toString(aux1 - aux2));
                    break;

                case 1:

                    aux1 = randomGen.nextInt(10) + 1;
                    aux2 = randomGen.nextInt(10) + 1;
                    buttonAnswer[0].setText(Integer.toString(aux1 - aux2));

                    aux1 = randomGen.nextInt(10) + 1;
                    aux2 = randomGen.nextInt(10) + 1;
                    buttonAnswer[2].setText(Integer.toString(aux1 - aux2));

                    aux1 = randomGen.nextInt(10) + 1;
                    aux2 = randomGen.nextInt(10) + 1;
                    buttonAnswer[3].setText(Integer.toString(aux1 - aux2));
                    break;

                case 2:
                    aux1 = randomGen.nextInt(10) + 1;
                    aux2 = randomGen.nextInt(10) + 1;
                    buttonAnswer[0].setText(Integer.toString(aux1 - aux2));

                    aux1 = randomGen.nextInt(10) + 1;
                    aux2 = randomGen.nextInt(10) + 1;
                    buttonAnswer[1].setText(Integer.toString(aux1 - aux2));

                    aux1 = randomGen.nextInt(10) + 1;
                    aux2 = randomGen.nextInt(10) + 1;
                    buttonAnswer[3].setText(Integer.toString(aux1 - aux2));
                    break;

                case 3:
                    aux1 = randomGen.nextInt(10) + 1;
                    aux2 = randomGen.nextInt(10) + 1;
                    buttonAnswer[0].setText(Integer.toString(aux1 - aux2));

                    aux1 = randomGen.nextInt(10) + 1;
                    aux2 = randomGen.nextInt(10) + 1;
                    buttonAnswer[1].setText(Integer.toString(aux1 - aux2));

                    aux1 = randomGen.nextInt(10) + 1;
                    aux2 = randomGen.nextInt(10) + 1;
                    buttonAnswer[2].setText(Integer.toString(aux1 - aux2));
                    break;
            }
        }
        CheckAnswer();
    }

    public void Medium() {


        aux1 = randomGen.nextInt(100) + 1;
        aux2 = randomGen.nextInt(100) + 1;
        aux3 = randomGen.nextInt(2);
        aux4 = randomGen.nextInt(4);


        if (aux3 == 0) {

            equation1 = aux1 + " + " + aux2;
            equationView.setText(equation1);

            buttonAnswer[aux4].setText(Integer.toString(aux1 + aux2));

            switch (aux4) {

                case 0:
                    aux1 = randomGen.nextInt(100) + 1;
                    aux2 = randomGen.nextInt(100) + 1;
                    buttonAnswer[1].setText(Integer.toString(aux1 + aux2));

                    aux1 = randomGen.nextInt(100) + 1;
                    aux2 = randomGen.nextInt(100) + 1;
                    buttonAnswer[2].setText(Integer.toString(aux1 + aux2));

                    aux1 = randomGen.nextInt(100) + 1;
                    aux2 = randomGen.nextInt(100) + 1;
                    buttonAnswer[3].setText(Integer.toString(aux1 + aux2));
                    break;

                case 1:

                    aux1 = randomGen.nextInt(100) + 1;
                    aux2 = randomGen.nextInt(100) + 1;
                    buttonAnswer[0].setText(Integer.toString(aux1 + aux2));

                    aux1 = randomGen.nextInt(100) + 1;
                    aux2 = randomGen.nextInt(100) + 1;
                    buttonAnswer[2].setText(Integer.toString(aux1 + aux2));

                    aux1 = randomGen.nextInt(100) + 1;
                    aux2 = randomGen.nextInt(100) + 1;
                    buttonAnswer[3].setText(Integer.toString(aux1 + aux2));
                    break;

                case 2:
                    aux1 = randomGen.nextInt(100) + 1;
                    aux2 = randomGen.nextInt(100) + 1;
                    buttonAnswer[0].setText(Integer.toString(aux1 + aux2));

                    aux1 = randomGen.nextInt(100) + 1;
                    aux2 = randomGen.nextInt(100) + 1;
                    buttonAnswer[1].setText(Integer.toString(aux1 + aux2));

                    aux1 = randomGen.nextInt(100) + 1;
                    aux2 = randomGen.nextInt(100) + 1;
                    buttonAnswer[3].setText(Integer.toString(aux1 + aux2));
                    break;

                case 3:
                    aux1 = randomGen.nextInt(100) + 1;
                    aux2 = randomGen.nextInt(100) + 1;
                    buttonAnswer[0].setText(Integer.toString(aux1 + aux2));

                    aux1 = randomGen.nextInt(100) + 1;
                    aux2 = randomGen.nextInt(100) + 1;
                    buttonAnswer[1].setText(Integer.toString(aux1 + aux2));

                    aux1 = randomGen.nextInt(100) + 1;
                    aux2 = randomGen.nextInt(100) + 1;
                    buttonAnswer[2].setText(Integer.toString(aux1 + aux2));
                    break;


            }
        } else {
            equation1 = aux1 + " - " + aux2;
            equationView.setText(equation1);

            buttonAnswer[aux4].setText(Integer.toString(aux1 - aux2));

            switch (aux4) {

                case 0:
                    aux1 = randomGen.nextInt(100) + 1;
                    aux2 = randomGen.nextInt(100) + 1;
                    buttonAnswer[1].setText(Integer.toString(aux1 - aux2));

                    aux1 = randomGen.nextInt(100) + 1;
                    aux2 = randomGen.nextInt(100) + 1;
                    buttonAnswer[2].setText(Integer.toString(aux1 - aux2));

                    aux1 = randomGen.nextInt(100) + 1;
                    aux2 = randomGen.nextInt(100) + 1;
                    buttonAnswer[3].setText(Integer.toString(aux1 - aux2));
                    break;

                case 1:

                    aux1 = randomGen.nextInt(100) + 1;
                    aux2 = randomGen.nextInt(100) + 1;
                    buttonAnswer[0].setText(Integer.toString(aux1 - aux2));

                    aux1 = randomGen.nextInt(100) + 1;
                    aux2 = randomGen.nextInt(100) + 1;
                    buttonAnswer[2].setText(Integer.toString(aux1 - aux2));

                    aux1 = randomGen.nextInt(100) + 1;
                    aux2 = randomGen.nextInt(100) + 1;
                    buttonAnswer[3].setText(Integer.toString(aux1 - aux2));
                    break;

                case 2:
                    aux1 = randomGen.nextInt(100) + 1;
                    aux2 = randomGen.nextInt(100) + 1;
                    buttonAnswer[0].setText(Integer.toString(aux1 - aux2));

                    aux1 = randomGen.nextInt(100) + 1;
                    aux2 = randomGen.nextInt(100) + 1;
                    buttonAnswer[1].setText(Integer.toString(aux1 - aux2));

                    aux1 = randomGen.nextInt(100) + 1;
                    aux2 = randomGen.nextInt(100) + 1;
                    buttonAnswer[3].setText(Integer.toString(aux1 - aux2));
                    break;

                case 3:
                    aux1 = randomGen.nextInt(100) + 1;
                    aux2 = randomGen.nextInt(100) + 1;
                    buttonAnswer[0].setText(Integer.toString(aux1 - aux2));

                    aux1 = randomGen.nextInt(100) + 1;
                    aux2 = randomGen.nextInt(100) + 1;
                    buttonAnswer[1].setText(Integer.toString(aux1 - aux2));

                    aux1 = randomGen.nextInt(100) + 1;
                    aux2 = randomGen.nextInt(100) + 1;
                    buttonAnswer[2].setText(Integer.toString(aux1 - aux2));
                    break;
            }
        }
        CheckAnswer();
    }


    public void Hard() {


        aux1 = randomGen.nextInt(10) + 1;
        aux2 = randomGen.nextInt(10) + 1;
        aux3 = randomGen.nextInt(2);
        aux4 = randomGen.nextInt(4);


        equation1 = aux1 + " * " + aux2;
        equationView.setText(equation1);

        buttonAnswer[aux4].setText(Integer.toString(aux1 * aux2));

        switch (aux4) {

            case 0:
                aux1 = randomGen.nextInt(10) + 1;
                aux2 = randomGen.nextInt(10) + 1;
                buttonAnswer[1].setText(Integer.toString(aux1 * aux2));

                aux1 = randomGen.nextInt(10) + 1;
                aux2 = randomGen.nextInt(10) + 1;
                buttonAnswer[2].setText(Integer.toString(aux1 * aux2));

                aux1 = randomGen.nextInt(10) + 1;
                aux2 = randomGen.nextInt(10) + 1;
                buttonAnswer[3].setText(Integer.toString(aux1 * aux2));
                break;

            case 1:

                aux1 = randomGen.nextInt(10) + 1;
                aux2 = randomGen.nextInt(10) + 1;
                buttonAnswer[0].setText(Integer.toString(aux1 * aux2));

                aux1 = randomGen.nextInt(10) + 1;
                aux2 = randomGen.nextInt(10) + 1;
                buttonAnswer[2].setText(Integer.toString(aux1 * aux2));

                aux1 = randomGen.nextInt(10) + 1;
                aux2 = randomGen.nextInt(10) + 1;
                buttonAnswer[3].setText(Integer.toString(aux1 * aux2));
                break;

            case 2:
                aux1 = randomGen.nextInt(10) + 1;
                aux2 = randomGen.nextInt(10) + 1;
                buttonAnswer[0].setText(Integer.toString(aux1 * aux2));

                aux1 = randomGen.nextInt(10) + 1;
                aux2 = randomGen.nextInt(10) + 1;
                buttonAnswer[1].setText(Integer.toString(aux1 * aux2));

                aux1 = randomGen.nextInt(10) + 1;
                aux2 = randomGen.nextInt(10) + 1;
                buttonAnswer[3].setText(Integer.toString(aux1 * aux2));
                break;

            case 3:
                aux1 = randomGen.nextInt(10) + 1;
                aux2 = randomGen.nextInt(10) + 1;
                buttonAnswer[0].setText(Integer.toString(aux1 * aux2));

                aux1 = randomGen.nextInt(10) + 1;
                aux2 = randomGen.nextInt(10) + 1;
                buttonAnswer[1].setText(Integer.toString(aux1 * aux2));

                aux1 = randomGen.nextInt(10) + 1;
                aux2 = randomGen.nextInt(10) + 1;
                buttonAnswer[2].setText(Integer.toString(aux1 * aux2));
                break;


        }

        CheckAnswer();

    }

    public void CheckAnswer() {



        preferences = getSharedPreferences("CalcStar", MODE_PRIVATE);
        final Intent intentGameover = new Intent(GameScreen.this, GameOver.class);

        //checking whether the button pressed was correct or not
        switch (aux4) {

            case 0:

                buttonAnswer[0].setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {

                        //correct answer: increase scorecount and display next question
                        scorecount++;
                        scoreView.setText(Integer.toString(scorecount));
                        preferences.edit().putString("score", String.valueOf(scorecount)).apply();
                        onStart();
                    }
                });

                buttonAnswer[1].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {


                        //wrong answer: vibrate and move to GameOver activity
                        vibrator.vibrate(50);
                        startActivity(intentGameover);

                    }
                });

                buttonAnswer[2].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        vibrator.vibrate(50);
                        startActivity(intentGameover);
                    }
                });

                buttonAnswer[3].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        vibrator.vibrate(50);
                        startActivity(intentGameover);
                    }
                });
                break;


            case 1:
                buttonAnswer[0].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        vibrator.vibrate(50);
                        startActivity(intentGameover);
                    }
                });

                buttonAnswer[1].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {


                        scorecount++;
                        preferences.edit().putString("score", String.valueOf(scorecount)).apply();
                        scoreView.setText(Integer.toString(scorecount));
                        onStart();
                    }
                });

                buttonAnswer[2].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        vibrator.vibrate(50);
                        startActivity(intentGameover);
                    }
                });

                buttonAnswer[3].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        vibrator.vibrate(50);
                        startActivity(intentGameover);
                    }
                });

                break;

            case 2:
                buttonAnswer[0].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        vibrator.vibrate(50);
                        startActivity(intentGameover);
                    }
                });

                buttonAnswer[1].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        vibrator.vibrate(50);
                        startActivity(intentGameover);
                    }
                });

                buttonAnswer[2].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        scorecount++;
                        scoreView.setText(Integer.toString(scorecount));
                        preferences.edit().putString("score", String.valueOf(scorecount)).apply();
                        onStart();

                    }
                });

                buttonAnswer[3].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        vibrator.vibrate(50);
                        startActivity(intentGameover);
                    }
                });
                break;

            case 3:
                buttonAnswer[0].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        vibrator.vibrate(50);
                        startActivity(intentGameover);
                    }
                });

                buttonAnswer[1].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        vibrator.vibrate(50);
                        startActivity(intentGameover);
                    }
                });

                buttonAnswer[2].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        vibrator.vibrate(50);
                        startActivity(intentGameover);
                    }
                });

                buttonAnswer[3].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        scorecount++;
                        preferences.edit().putString("score", String.valueOf(scorecount)).apply();
                        scoreView.setText(Integer.toString(scorecount));
                        onStart();
                    }
                });
                break;
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
        if (id == R.id.action_highscore) {
            Intent intentHighscore = new Intent(this, Highscore.class);
            startActivity(intentHighscore);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}
