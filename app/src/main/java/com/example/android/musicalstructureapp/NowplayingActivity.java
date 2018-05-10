package com.example.android.musicalstructureapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

public class NowplayingActivity extends AppCompatActivity {

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Return to previous Activity using back button
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nowplaying);

        //Create up button for backward navigation
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        Intent intent = getIntent();

        Song song = intent.getParcelableExtra("Song Playing");

        String songName = song.getSongName();
        String artistName = song.getArtistName();
        int songArt = song.getImageResourceId();

        TextView textViewSong = findViewById(R.id.songNamePlaying);
        textViewSong.setText(songName);

        TextView textViewArtist = findViewById(R.id.artistNamePlaying);
        textViewArtist.setText(artistName);

        ImageView imageView = findViewById(R.id.songArtwork);
        imageView.setImageResource(songArt);
    }
}