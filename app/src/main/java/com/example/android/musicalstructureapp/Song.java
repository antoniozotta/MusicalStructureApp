package com.example.android.musicalstructureapp;

import android.os.Parcel;
import android.os.Parcelable;

/**Song has a song name artist name and artwork
*/
public class Song implements Parcelable{

    /** Song name of song */
    private String mSongName;
    /** Artist name of song */
    private String mArtistName;
    // Drawable resource ID
    private int mImageResourceId;

    /*
     * Create a new Song object.
     *
     * @param songName is title of song
     * @param artistName is artist of song
     * @param imageResourceId is drawable reference ID of song artwork
     * */
    public Song(String songName, String artistName, int imageResourceId) {
        mSongName = songName;
        mArtistName = artistName;
        mImageResourceId = imageResourceId;
    }

    protected Song(Parcel in) {
        mSongName = in.readString();
        mArtistName = in.readString();
        mImageResourceId = in.readInt();
    }

    public static final Creator<Song> CREATOR = new Creator<Song>() {
        @Override
        public Song createFromParcel(Parcel in) {
            return new Song(in);
        }

        @Override
        public Song[] newArray(int size) {
            return new Song[size];
        }
    };

    /**
     * Get the song name.
     */
    public String getSongName() {
        return mSongName;
    }

    /**
     * Get the artist name.
     */
    public String getArtistName() {
        return mArtistName;
    }

    /**
     * Get the image resource ID
     */
    public int getImageResourceId() {
        return mImageResourceId;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(mSongName);
        parcel.writeString(mArtistName);
        parcel.writeInt(mImageResourceId);
    }
}