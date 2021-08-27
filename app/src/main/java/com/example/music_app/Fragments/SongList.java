package com.example.music_app.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.music_app.MainViewModelData;
import com.example.music_app.MusicAdapter;
import com.example.music_app.R;
import com.example.music_app.Song;

public class SongList extends Fragment implements MusicAdapter.OnItemClickListener {

    RecyclerView recyclerView;
    MainViewModelData mainViewModelData;

    public SongList() {
        // Required empty public constructor
    }

    private void checkPlay(){
        if(mainViewModelData.getMediaPlayer()!=null){
            mainViewModelData.getMediaPlayer().release();
            mainViewModelData.setPaused(false);
            mainViewModelData.setMediaPlayer(null);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_song_list, container, false);
        recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mainViewModelData = new ViewModelProvider(getActivity()).get(MainViewModelData.class);
        recyclerView.setAdapter(new MusicAdapter(mainViewModelData.getSongs(),SongList.this::onItemClick));
        return view;
    }

    @Override
    public void onItemClick(int position) {
        mainViewModelData.setSong_index(position);
        checkPlay();
        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.main_layout,new MusicPlay()).addToBackStack(null).commit();
    }
}