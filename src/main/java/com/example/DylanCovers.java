package com.example;

/**
 * Created by alantaylor on 2/19/17.
 */
public class DylanCovers {
    private String Artist;
    private String Cover;
    private String Album;

    public String getAlbum(){
        return Album;
    }

    public void setAlbum(String Album){
        this.Album = Album;
    }

    public String getArtist(){
        return Artist;
    }

    public void setArtist(String Artist) {
        this.Artist = Artist;
    }

    public String getCover(){
        return Cover;
    }

    public void setCover(String Cover) {
        this.Cover = Cover;
    }
}
