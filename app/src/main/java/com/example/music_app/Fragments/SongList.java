package com.example.music_app.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.music_app.MainViewModelData;
import com.example.music_app.MusicAdapter;
import com.example.music_app.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SongList#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SongList extends Fragment {

    RecyclerView recyclerView;
    MainViewModelData mainViewModelData;

    public SongList() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_song_list, container, false);
        recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mainViewModelData = new ViewModelProvider(getActivity()).get(MainViewModelData.class);

        recyclerView.setAdapter(new MusicAdapter(mainViewModelData.getSongs()));


        return view;
    }
}