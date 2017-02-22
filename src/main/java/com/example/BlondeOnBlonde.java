package com.example;


import java.util.ArrayList;
import java.util.Map;

/**
 * Created by alantaylor on 2/20/17.
 */
public class BlondeOnBlonde {
    private String Year = "1965";
    private String NumberOfTracks = "14";
    private Tracks[] tracks = new Tracks[14];

    //setTracks();



    public String getYear(){
        return Year;
    }

    public String getNumberOfTracks(){
        return NumberOfTracks;
    }

    public Tracks[] getTracks(){
        return tracks;
    }

    public void setTracks(){
        tracks[0]  = new Tracks("Rainy Day Women #12 & 35", "4:36");
        tracks[1] = new Tracks("Pledging My Time", "3:50");
        tracks[2] = new Tracks("Visions of Johanna", "7:33");
        tracks[3] = new Tracks("One of Us Must Know (Sooner or Later)", "4:54");
        tracks[4] = new Tracks("I want you", "3:50");
        tracks[5] = new Tracks("Pledging My Time", "3:07");
        tracks[6] = new Tracks("Pledging My Time", "3:50");
        tracks[7] = new Tracks("Pledging My Time", "3:50");
        tracks[8] = new Tracks("Pledging My Time", "3:50");
        tracks[9] = new Tracks("Pledging My Time", "3:50");
        tracks[10] = new Tracks("Pledging My Time", "3:50");
        tracks[11] = new Tracks("Pledging My Time", "3:50");
        tracks[12] = new Tracks("Pledging My Time", "3:50");
        tracks[13] = new Tracks("Pledging My Time", "3:50");
    }


}
