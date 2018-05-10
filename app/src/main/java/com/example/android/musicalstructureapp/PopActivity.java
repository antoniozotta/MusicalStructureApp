package com.example.android.musicalstructureapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import java.util.ArrayList;

public class PopActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.song_list);

        //Create up button for backward navigation
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // ArrayList of pop songs
        final ArrayList<Song> songs = new ArrayList<Song>();
        songs.add(new Song("Perfect", "Ed Sheeran", R.drawable.perfect));
        songs.add(new Song("Flames", "Sia", R.drawable.sia));
        songs.add(new Song("Havana", "Camila Cabello", R.drawable.havana));
        songs.add(new Song("Friends", "Anne-Marie", R.drawable.friends));

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
                Intent intent = new Intent(PopActivity.this, NowplayingActivity.class);
                intent.putExtra("Song Playing", songs.get(position));
                startActivity(intent);
            }
        });

    }
}