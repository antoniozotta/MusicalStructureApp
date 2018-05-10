package com.example.android.musicalstructureapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import java.util.ArrayList;

public class T80sActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.song_list);

        //Create up button for backward navigation
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // ArrayList of 80s songs
        final ArrayList<Song> songs = new ArrayList<Song>();
        songs.add(new Song("Take On Me", "a-ha", R.drawable.aha));
        songs.add(new Song("You Spin Me Round", "Dead or Alive", R.drawable.dead));
        songs.add(new Song("Beat It", "Michael Jackson", R.drawable.mj));
        songs.add(new Song("Eye of the Tiger", "Survivor", R.drawable.survivor));

        //Create SongAdapter using data source of Songs. The adapter knows how to create list items in list
        SongAdapter adapter = new SongAdapter(this, songs);

        // Find the ListView object in Link Activity. ListView should have ID called list declared in song_list file
        ListView listView = findViewById(R.id.list);

        //Make ListView use SongAdapter so that ListView displays list of items for each Song in the list
        listView.setAdapter(adapter);

        //When a song is clicked, open NowplayingActivity
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(T80sActivity.this, NowplayingActivity.class);
                intent.putExtra("Song Playing", songs.get(position));
                startActivity(intent);
            }
        });

    }
}