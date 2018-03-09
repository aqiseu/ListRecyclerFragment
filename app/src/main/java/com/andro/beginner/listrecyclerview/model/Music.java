package com.andro.beginner.listrecyclerview.model;

/**
 * Created by amaliaqis on 3/9/2018.
 */

public class Music {

    String musicTitle;
    String musicArtist;

    public Music(String musicArtist, String musicTitle) {
        this.musicArtist = musicArtist;
        this.musicTitle = musicTitle;
    }

    public Music(){

    }

    public String getMusicTitle() {
        return musicTitle;
    }

    public void setMusicTitle(String musicTitle) {
        this.musicTitle = musicTitle;
    }

    public String getMusicArtist() {
        return musicArtist;
    }

    public void setMusicArtist(String musicArtist) {
        this.musicArtist = musicArtist;
    }

}
