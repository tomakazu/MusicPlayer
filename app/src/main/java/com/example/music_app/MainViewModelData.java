package com.example.music_app;
import androidx.lifecycle.ViewModel;
import java.util.ArrayList;

public class MainViewModelData extends ViewModel {

    private ArrayList<Song> songs;

    public ArrayList<Song> getSongs() {
        if(songs==null){
            songs = new ArrayList<>();
        }
        return songs;
    }
}
