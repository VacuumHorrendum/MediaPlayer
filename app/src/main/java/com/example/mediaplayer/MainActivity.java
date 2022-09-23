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
    int paint;
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
                paint = song.getPortretResource();

                intent.putExtra("music", music);
                intent.putExtra("paint", paint);

                startActivity(intent);
            }
        };
        // создаем адаптер
        StateAdapter adapter = new StateAdapter(this, songs, stateClickListener);
        // устанавливаем для списка адаптер
        recyclerView.setAdapter(adapter);

    }
    private void setInitialData(){

        songs.add(new Song ("Шостакович", "Симфония №5", R.drawable.shost));
        songs.add(new Song ("Вивальди", "Осень", R.drawable.viva));
        songs.add(new Song ("Чайковский", "Лебединое озеро", R.drawable.chai));
        songs.add(new Song ("Моцарт", "Реквием по мечте", R.drawable.moc));
        songs.add(new Song ("Верди", "Реквием", R.drawable.verdi));
    }
}