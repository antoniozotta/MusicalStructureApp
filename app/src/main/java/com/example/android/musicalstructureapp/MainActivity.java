package com.example.android.musicalstructureapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set content of this activity to use activity_main.xml file
        setContentView(R.layout.activity_main);

        // Find View that shows Pop playlist
        TextView pop = findViewById(R.id.pop);

        // Set click listener on pop View
        pop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Create intent to open PopActivity
                Intent popIntent = new Intent(MainActivity.this, PopActivity.class);

                // Start new pop activity
                startActivity(popIntent);
            }
        });

        // Find View that shows Pop playlist
        TextView rap = findViewById(R.id.rap);

        // Set click listener on rap View
        rap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Create intent to open RapActivity
                Intent rapIntent = new Intent(MainActivity.this, RapActivity.class);

                // Start new rap activity
                startActivity(rapIntent);
            }
        });

        // Find View that shows 80s playlist
        TextView t80s = findViewById(R.id.t80s);

        // Set click listener on 80s View
        t80s.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Create intent to open T80sActivity
                Intent t80sIntent = new Intent(MainActivity.this, T80sActivity.class);

                // Start new 80s activity
                startActivity(t80sIntent);
            }
        });
    }
}
