package com.example.mediaplayer;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class StateAdapter  extends RecyclerView.Adapter<StateAdapter.ViewHolder>{


   interface OnStateClickListener{
      void onStateClick(Song song, int position);
   }

   private final OnStateClickListener onClickListener;
   private final LayoutInflater inflater;
   private final List<Song> songs;



   StateAdapter(Context context, List<Song> songs, OnStateClickListener onClickListener) {
      this.onClickListener = onClickListener;
      this.songs = songs;
      this.inflater = LayoutInflater.from(context);
   }


   @Override
   public StateAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

      View view = inflater.inflate(R.layout.list_item, parent, false);
      return new ViewHolder(view);
   }

   @Override
   public void onBindViewHolder(StateAdapter.ViewHolder holder, int position) {
      Song song = songs.get(position);
      holder.portretView.setImageResource(song.getPortretResource());
      holder.textNameGroup.setText(song.getNameGroup());
      holder.textNameSong.setText(song.getNameSong());

      holder.itemView.setOnClickListener(new View.OnClickListener(){
         @Override
         public void onClick(View v)
         {
            // вызываем метод слушателя, передавая ему данные
            onClickListener.onStateClick(song, holder.getAdapterPosition());
         }
      });
   }

   @Override
   public int getItemCount() {
      return songs.size();
   }

   public static class ViewHolder extends RecyclerView.ViewHolder {
      final ImageView portretView;
      final TextView textNameGroup, textNameSong;
      ViewHolder(View view){
         super(view);
         textNameGroup = view.findViewById(R.id.textNameGroup);
         textNameSong = view.findViewById(R.id.textNameSong);
         portretView = view.findViewById(R.id.portretImage);
      }
   }
}