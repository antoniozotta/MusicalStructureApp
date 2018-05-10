package com.example.android.musicalstructureapp;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class SongAdapter extends ArrayAdapter<Song>{

    /**custom constructor. Inflates layout file with list of songs
     * @param context Current context used to inflate layout file
     * @param songs A list of Song objects to display in a list
     */
    public SongAdapter(Activity context, ArrayList<Song> songs){
        //Initialise ArrayAdapter internal storage for context and list
        super(context, 0, songs);
    }

     /** Provides a view for an AdapterView
     *
     * @param position    The position in the list of data that should be displayed in the
     *                    list item view.
     * @param convertView The recycled view to populate.
     * @param parent      The parent ViewGroup that is used for inflation.
     * @return The View for the position in the AdapterView.
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Checks if existing view is being reused, otherwise inflate view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        // Get the {@link Word} object located at this position in the list
        Song currentSong = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID songName
        TextView songnameTextView = listItemView.findViewById(R.id.songName);
        // Get the version name from the current Song object and
        // set this text on the name  nameTextView
        songnameTextView.setText(currentSong.getSongName());

        // Find the TextView in the list_item.xml layout with the ID artistName
        TextView artistnameTextView = listItemView.findViewById(R.id.artistName);
        // Get the version number from the current Song object and
        // set this text on the defaultTextView
        artistnameTextView.setText(currentSong.getArtistName());

        // Find the ImageView in the list_item.xml layout with the ID icon
        ImageView iconView = listItemView.findViewById(R.id.icon);
        // Get the image resource ID from the current Song object and
        // set the image to iconView
        iconView.setImageResource(currentSong.getImageResourceId());

        // Return the whole list item layout (containing 2 TextViews)
        // so that it can be shown in the ListView
        return listItemView;
    }
}
