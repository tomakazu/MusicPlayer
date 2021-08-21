package com.example.music_app;

import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class MusicAdapter extends RecyclerView.Adapter<MusicAdapter.MusicHolder> {

    private ArrayList<Song> songs;
    private MediaPlayer mediaPlayer;

    public interface OnItemClickListener{
        void onItemClick(int position);
    }
    private OnItemClickListener onItemClickListener;

    public MusicAdapter(ArrayList<Song> songs,OnItemClickListener onItemClickListener) {
        this.songs = songs;
        this.onItemClickListener = onItemClickListener;
    }

    @NonNull
    @Override
    public MusicHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.music_item_design,parent,false);

        return new MusicHolder(view,onItemClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull MusicHolder holder, int position) {
        holder.song.setText(songs.get(position).title);
    }


    @Override
    public int getItemCount() {
        return songs.size();
    }


    class MusicHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        OnItemClickListener onItemClickListener;
        TextView song;

        public MusicHolder(@NonNull View itemView,OnItemClickListener onItemClickListener) {
            super(itemView);
            song = (TextView) itemView.findViewById(R.id.song_name);
            this.onItemClickListener = onItemClickListener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            onItemClickListener.onItemClick(getBindingAdapterPosition());
        }
    }


}
