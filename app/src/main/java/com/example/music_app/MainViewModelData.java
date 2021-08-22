package com.example.music_app;
import android.media.MediaPlayer;

import androidx.lifecycle.ViewModel;
import java.util.ArrayList;

public class MainViewModelData extends ViewModel {

    private Integer song_index;
    private Boolean isPaused;
    private ArrayList<Song> songs;
    private MediaPlayer mediaPlayer;

    public Boolean getPaused() {
        if(isPaused==null){
            isPaused = new Boolean(false);
        }
        return isPaused;
    }

    public void setPaused(Boolean paused) {
        isPaused = paused;
    }

    public ArrayList<Song> getSongs() {
        if(songs==null){
            songs = new ArrayList<>();
        }
        return songs;
    }

    public void setMediaPlayer(MediaPlayer mediaPlayer) {
        this.mediaPlayer = mediaPlayer;
    }

    public void setSong_index(Integer song_index) {
        if(song_index==null){
            song_index = new Integer(-1);
        }
        this.song_index = song_index;
    }

    public Integer getSong_index() {
        return song_index;
    }

    public MediaPlayer getMediaPlayer() {
        if(mediaPlayer==null){
            mediaPlayer = new MediaPlayer();
        }
        return mediaPlayer;
    }
}
