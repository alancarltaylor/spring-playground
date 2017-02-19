package com.example;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Created by alantaylor on 2/19/17.
 */
@RestController
@RequestMapping("/dylan")
public class QueryStringEndPoint {



    @GetMapping("/best")
    public String getAsName(
            @RequestParam("best-album") String bestAlbum,
            @RequestParam("best-song") String bestSong){
        return String.format("His best album is %s, his best song is %s", bestAlbum, bestSong);
    }

    @GetMapping("/worst")
    public String getAsHash(@RequestParam Map querystring){
                return querystring.toString();
    }

    @GetMapping("/cover")
    public String getStuff(DylanCovers dylanCovers){
        return String.format("The best cover of Dylan is %s by %s", dylanCovers.getCover(), dylanCovers.getArtist());
    }

}
