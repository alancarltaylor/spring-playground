package com.example;

/**
 * Created by alantaylor on 2/21/17.
 */
public class Tracks {
    private String Title;
    private String Length;

    public Tracks (String Title, String Length){
        this.Title = Title;
        this.Length = Length;
    }

    public String getTitle(){
        return Title;
    }
    public String getLength(){
        return Length;
    }

    public void setTitle(String Title){
        this.Title = Title;
    }

    public void setLength(String Length){
        this.Length = Length;
    }
}
