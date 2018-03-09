package com.andro.beginner.listrecyclerview.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.andro.beginner.listrecyclerview.R;
import com.andro.beginner.listrecyclerview.adapter.RecyclerAdapter;
import com.andro.beginner.listrecyclerview.model.Music;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;


public class RecyclerFragment extends Fragment {

    private static String[][] music= new String[][] {
            {("Open Arms" ), ("PrettyMuch")},
            {("Needed Me" ), ("Rihanna")},
            {("Champagne and Sunshine" ), ("Tarro x PLVTINUM")},
            {("Would You Mind" ), ("PrettyMuch")},
            {("Hold On, We're Going Home" ), ("Pia Mia")}

    };

    ArrayList<Music> listMusic;

    RecyclerView rvMusic;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_recycler, container, false);

        rvMusic = (RecyclerView) rootView.findViewById(R.id.rv_music);
        rvMusic.setHasFixedSize(true);

        listMusic = new ArrayList<>();
        listMusic.addAll(getMusicData());

        RecyclerAdapter adapter = new RecyclerAdapter(listMusic, getActivity().getApplicationContext());
        rvMusic.setAdapter(adapter);
        rvMusic.setLayoutManager(new LinearLayoutManager(getActivity().getApplicationContext()));

        return rootView;
    }


    public static ArrayList<Music> getMusicData() {

        Music musicList = null;
        ArrayList<Music> musicArrayList = new ArrayList<>();

        for (int i=0; i < music.length; i++){
            musicList = new Music();

            musicList.setMusicTitle(music[i][0]);
            musicList.setMusicArtist(music[i][1]);

            musicArrayList.add(musicList);
        }

        return musicArrayList;
    }



}