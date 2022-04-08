package com.aptech.android_exam.adapter;

import androidx.recyclerview.widget.RecyclerView;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.aptech.android_exam.R;
import com.aptech.android_exam.entity.Song;
//import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class ListElementAdapter extends RecyclerView.Adapter<ListElementAdapter.ViewHolder>{
    Context currentContext;
    List<Song> songs;

    public ListElementAdapter(Context currentContext, List<Song> songs) {
        this.currentContext = currentContext;
        this.songs = songs;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(currentContext).inflate(R.layout.recycleitem, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Song currentSong = songs.get(position);
//        Glide.with(currentContext).load(currentSong.getThumbnail()).into(holder.imageView);
        holder.songTxtView.setText(currentSong.getSongId());
        holder.authorTxtView.setText(currentSong.getAuthor());
        holder.singerTxtView.setText(currentSong.getSinger());
//        holder.songWrapper.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(currentContext, SongDetailActivity.class);
//                intent.putExtra("songs", (ArrayList<Song>) songs);
//                int mLastPosition = holder.getAdapterPosition();
//                intent.putExtra("position", mLastPosition);
//                currentContext.startActivity(intent);
//            }
//        });
    }

    @Override
    public int getItemCount() {
        return songs.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        RelativeLayout songWrapper;
        ImageView imageView;
        TextView songTxtView;
        TextView authorTxtView;
        TextView singerTxtView;

        public ViewHolder(View itemView) {
            super(itemView);
            songWrapper = itemView.findViewById(R.id.song_wrapper);
            imageView = itemView.findViewById(R.id.image_thumbnail);
            songTxtView = itemView.findViewById(R.id.song_name);
            authorTxtView = itemView.findViewById(R.id.song_author);
            singerTxtView = itemView.findViewById(R.id.song_singer);
        }
    }
}
