package com.example.mediaplayer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    String music;
    ArrayList<Song> songs = new ArrayList<Song>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // начальная инициализация списка
        setInitialData();
        RecyclerView recyclerView = findViewById(R.id.list);
        Intent intent = new Intent(this, PlayerActivity.class);
        StateAdapter.OnStateClickListener stateClickListener = new StateAdapter.OnStateClickListener() {
            @Override
            public void onStateClick(Song song, int position) {


                Toast.makeText(getApplicationContext(), "Был выбран пункт " + song.getNameSong(),
                        Toast.LENGTH_SHORT).show();
                music = song.getNameSong();

                intent.putExtra("music", music);

                startActivity(intent);
            }
        };
        // создаем адаптер
        StateAdapter adapter = new StateAdapter(this, songs, stateClickListener);
        // устанавливаем для списка адаптер
        recyclerView.setAdapter(adapter);

    }
    private void setInitialData(){

        songs.add(new Song ("Шостакович", "Симфония №5"));
        songs.add(new Song ("Вивальди", "Осень"));
        songs.add(new Song ("Чайковский", "Лебединое озеро"));
        songs.add(new Song ("Моцарт", "Реквием по мечте"));
        songs.add(new Song ("Верди", "Реквием"));
//        states.add(new State ("Колумбия", "Богота", R.drawable.columbia));
//        states.add(new State ("Уругвай", "Монтевидео", R.drawable.uruguai));
//        states.add(new State ("Чили", "Сантьяго", R.drawable.chile));
    }
}