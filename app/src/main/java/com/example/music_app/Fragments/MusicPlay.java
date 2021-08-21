package com.example.music_app.Fragments;

import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.music_app.R;
import com.example.music_app.Song;

import java.io.IOException;

public class MusicPlay extends Fragment {

    private TextView song_name;
    private ImageButton pause_play,stop;
    private ImageView song_image;
    private MediaPlayer mediaPlayer;
    private Boolean isPaused = new Boolean(false);

    public MusicPlay() {
        // Required empty public constructor
    }

    private Song song;

    public MusicPlay(Song song) {
        this.song = song;
    }

    private void startMusic() {
        if(mediaPlayer==null){
            mediaPlayer = new MediaPlayer();
        }

        try {
                if(!isPaused){
                    mediaPlayer.setDataSource(song.getSong_Url());
                    mediaPlayer.prepare();
                    isPaused = true;
                }
                mediaPlayer.start();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void pause(){
        if(mediaPlayer!=null){
            mediaPlayer.pause();
            isPaused = true;
        }
    }

    private void Stop(){
        stopPlayer();
    }

    private void stopPlayer(){
        if(mediaPlayer!=null){
            mediaPlayer.release();
            mediaPlayer = null;
            isPaused = false;
        }
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_music_play, container, false);
        song_name = view.findViewById(R.id.playing_song_name);
        stop = view.findViewById(R.id.stop_button);
        pause_play = view.findViewById(R.id.play_pause_button);
        startMusic();
        Toast.makeText(getContext(),"Playing "+song.getTitle()+"...",Toast.LENGTH_SHORT).show();

        song_name.setText(song.getTitle());
        pause_play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mediaPlayer==null){
                    mediaPlayer = new MediaPlayer();
                }

                if(mediaPlayer.isPlaying()){
                    pause_play.setImageResource(R.drawable.play_circle);
                    pause();
                }else{
                    pause_play.setImageResource(R.drawable.pause_circle);
                    startMusic();
                }
            }
        });

        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopPlayer();
                pause_play.setImageResource(R.drawable.play_circle);
            }
        });

        return view;
    }
}