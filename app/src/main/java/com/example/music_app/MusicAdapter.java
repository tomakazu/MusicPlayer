package com.example.music_app;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.io.FileDescriptor;
import java.io.IOException;
import java.util.ArrayList;

public class MusicAdapter extends RecyclerView.Adapter<MusicAdapter.MusicHolder> {

    private ArrayList<Song> songs;
    private MediaPlayer mediaPlayer;
    private Integer curr_song;
    public MusicAdapter(ArrayList<Song> songs) {
        this.songs = songs;
    }

    @NonNull
    @Override
    public MusicHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.music_item_design,parent,false);

        return new MusicHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MusicHolder holder, int position) {
        holder.song.setText(songs.get(position).title);
    }


    @Override
    public int getItemCount() {
        return songs.size();
    }


    class MusicHolder extends RecyclerView.ViewHolder{
        ImageButton play,pause,stop;
        TextView song;

        public MusicHolder(@NonNull View itemView) {
            super(itemView);
            song = (TextView) itemView.findViewById(R.id.song_name);
            itemView.setOnClickListener();
        }
    }

    private void startMusic(Integer pos) {
        if(mediaPlayer==null){
            mediaPlayer = new MediaPlayer();
        }

        try {
             if(pos==curr_song){
                 System.out.println("Hello");
             }
                mediaPlayer.setDataSource(songs.get(pos).song_Url);
                mediaPlayer.prepare();
                mediaPlayer.start();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void pause(){
        if(mediaPlayer!=null){
            mediaPlayer.pause();
        }
    }

    private void Stop(){
        stopPlayer();
    }

    private void stopPlayer(){
        if(mediaPlayer!=null){
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }

}
