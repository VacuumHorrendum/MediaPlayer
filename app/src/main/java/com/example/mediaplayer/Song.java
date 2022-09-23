package com.example.mediaplayer;

public class Song {
    private String nameGroup;
    private String nameSong;
    private  int portretResourse;

    public Song(String nameGroup, String nameSong, int portret){

        this.nameGroup=nameGroup;
        this.nameSong=nameSong;
        portretResourse = portret;
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
    public int getPortretResource() {
        return this.portretResourse;
    }

    public void setPortretResource(int portretResource) {
        this.portretResourse = portretResource;
    }

}
