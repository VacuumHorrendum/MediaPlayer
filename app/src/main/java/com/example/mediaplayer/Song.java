package com.example.mediaplayer;

public class Song {
    private String nameGroup;
    private String nameSong;

    public Song(String nameGroup, String nameSong){

        this.nameGroup=nameGroup;
        this.nameSong=nameSong;
    }
    public String getNameGroup() {
        return this.nameGroup;
    }
    public void setNameGroup(String nameGroup){
        this.nameGroup=nameGroup;
    }
    public String getNameSong() {
        return this.nameSong;
    }
    public void setNameSong(String nameSong){
        this.nameGroup=nameSong;
    }

}
