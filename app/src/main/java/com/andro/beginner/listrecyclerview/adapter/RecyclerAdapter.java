package com.andro.beginner.listrecyclerview.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.andro.beginner.listrecyclerview.R;
import com.andro.beginner.listrecyclerview.model.Music;

import java.util.ArrayList;

/**
 * Created by amaliaqis on 3/9/2018.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.RecyclerHolder> {

    private Context context;
    private ArrayList<Music> musicList;

    public RecyclerAdapter(ArrayList<Music> list, Context context){
            this.musicList = list;
            this.context = context;
            }



    @Override
    public RecyclerHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_music, parent, false);
            return new RecyclerHolder(view);
            }

    @Override
    public void onBindViewHolder(RecyclerHolder holder, int position) {
    final Music music = musicList.get(position);

            holder.tvArtist.setText(music.getMusicArtist());
            holder.tvTitle.setText(music.getMusicTitle());

    }

    @Override
    public int getItemCount() {
            return musicList.size();
            }

    public class RecyclerHolder extends RecyclerView.ViewHolder {

        TextView tvTitle, tvArtist;
        CardView cvContainer;

        public RecyclerHolder(View itemView){
            super(itemView);

            cvContainer = (CardView)itemView.findViewById(R.id.cv_item_music);
            tvTitle = (TextView)itemView.findViewById(R.id.tv_music_title);
            tvArtist = (TextView)itemView.findViewById(R.id.tv_music_singer);

        }
    }

}
