package com.jcuapp.alexanderschink.calcstar;

import android.content.Context;
import android.media.MediaPlayer;

public class SoundManager {

    //public SoundPool pool;
    public MediaPlayer mediaPlayer;
    private Context context;



    public SoundManager(Context context){

        this.context = context;
        //SoundPool.Builder builder = new SoundPool.Builder();

       // builder.setMaxStreams(10);
       // pool = builder.build();

        mediaPlayer = new MediaPlayer();




    }

    public void play() {

        mediaPlayer = MediaPlayer.create(context, R.raw.bgdmusic);
        mediaPlayer.start();
    }
    public void stop() {

            mediaPlayer.stop();

    }

   /* public int addSound(int resourceID){
        return pool.load(context, resourceID, 1);


    }

   public void play(int soundID){
        pool.play(soundID, 1,1,1, 30, 1);

    }*/

}
