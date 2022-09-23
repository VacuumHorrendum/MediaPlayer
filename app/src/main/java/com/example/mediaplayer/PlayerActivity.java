package com.example.mediaplayer;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class PlayerActivity extends AppCompatActivity {
   MediaPlayer mPlayer;
   ImageView playButton, pauseButton, stopButton;
   ImageView paint;
   String music;
   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.player);
      Bundle arguments = getIntent().getExtras();
      paint = findViewById(R.id.imageView);
      music = arguments.get("music").toString();
      switch (music){
         case "Симфония №5":
            mPlayer = MediaPlayer.create(this, R.raw.allegro);
            paint.setImageResource(R.drawable.shost);
            break;
         case "Осень":
            mPlayer = MediaPlayer.create(this, R.raw.autumn);
            paint.setImageResource(R.drawable.viva);
            break;
         case "Лебединое озеро":
            mPlayer = MediaPlayer.create(this, R.raw.lebed);
            paint.setImageResource(R.drawable.chai);
            break;
         case "Реквием по мечте":
            mPlayer = MediaPlayer.create(this, R.raw.rekviem);
            paint.setImageResource(R.drawable.moc);
            break;
         default:
            mPlayer = MediaPlayer.create(this, R.raw.rekviem_die_seno);
            paint.setImageResource(R.drawable.verdi);
      }


      mPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
         @Override
         public void onCompletion(MediaPlayer mp) {
            stopPlay();
         }
      });
      playButton = findViewById(R.id.imageViewPlay);
      pauseButton = findViewById(R.id.imageViewPause);
      stopButton = findViewById(R.id.imageViewStop);

      pauseButton.setEnabled(false);
      stopButton.setEnabled(false);
   }
   private void stopPlay(){
      mPlayer.stop();
      pauseButton.setEnabled(false);
      stopButton.setEnabled(false);
      try {
         mPlayer.prepare();
         mPlayer.seekTo(0);
         playButton.setEnabled(true);
      }
      catch (Throwable t) {
         Toast.makeText(this, t.getMessage(), Toast.LENGTH_SHORT).show();
      }
   }
   public void play(View view){

      mPlayer.start();
      playButton.setEnabled(false);
      pauseButton.setEnabled(true);
      stopButton.setEnabled(true);
   }
   public void pause(View view){

      mPlayer.pause();
      playButton.setEnabled(true);
      pauseButton.setEnabled(false);
      stopButton.setEnabled(true);
   }
   public void stop(View view){
      stopPlay();
   }
   @Override
   public void onDestroy() {
      super.onDestroy();
      if (mPlayer.isPlaying()) {
         stopPlay();
      }
   }
}
