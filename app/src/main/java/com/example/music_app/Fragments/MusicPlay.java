package com.example.music_app.Fragments;

import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.OrientationEventListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.music_app.MainViewModelData;
import com.example.music_app.R;
import com.example.music_app.Song;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.io.IOException;

public class MusicPlay extends Fragment {

    private MainViewModelData mainViewModelData;
    private TextView song_name;
    private ImageButton pause_play,stop;
    private ImageView song_image;
    private FloatingActionButton edit_name;

    public MusicPlay() {
        // Required empty public constructor
    }

    private void startMusic() {

        try {
                if(!mainViewModelData.getPaused()){
                    mainViewModelData.getMediaPlayer().setDataSource(mainViewModelData.getSongs().get(mainViewModelData.getSong_index()).getSong_Url());
                    mainViewModelData.getMediaPlayer().prepare();
                    mainViewModelData.setPaused(true);
                }else{
                    return;
                }
                mainViewModelData.getMediaPlayer().start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void pause(){
        if(mainViewModelData.getMediaPlayer()!=null){
            mainViewModelData.getMediaPlayer().pause();
            mainViewModelData.setPaused(true);
        }
    }

    private void Stop(){
        stopPlayer();
    }

    private void  stopPlayer(){
        if(mainViewModelData.getMediaPlayer()!=null){
            mainViewModelData.getMediaPlayer().release();
            mainViewModelData.setMediaPlayer(null);
            mainViewModelData.setPaused(false);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_music_play, container, false);
        song_name = view.findViewById(R.id.playing_song_name);
        stop = view.findViewById(R.id.stop_button);
        pause_play = view.findViewById(R.id.play_pause_button);
        mainViewModelData = new ViewModelProvider(getActivity()).get(MainViewModelData.class);

    //    checkPlay();
        startMusic();


        edit_name = view.findViewById(R.id.edit_name);

        Toast.makeText(getContext(),mainViewModelData.getPaused().toString(),Toast.LENGTH_SHORT).show();

        edit_name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


        song_name.setText(mainViewModelData.getSongs().get(mainViewModelData.getSong_index()).getTitle());
        pause_play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(mainViewModelData.getMediaPlayer().isPlaying()){
                    pause_play.setBackgroundResource(R.drawable.play_circle);
                    pause();
                }else{
                    pause_play.setBackgroundResource(R.drawable.pause_circle);
                    startMusic();
                }
            }
        });

        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Stop();
                pause_play.setBackgroundResource(R.drawable.play_circle);
            }
        });



        return view;
    }
}