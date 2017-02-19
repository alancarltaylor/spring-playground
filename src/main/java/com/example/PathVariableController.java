package com.example;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Created by alantaylor on 2/19/17.
 */
@RestController
@RequestMapping("/dylan")
public class PathVariableController {
    @GetMapping("/albums/{AlbumId}")
    public String getByName(@PathVariable("AlbumId") int AlbumId){
        return String.format("Album ID is %d", AlbumId);
    }

    @GetMapping("/songs/{SongId}")
    public String getByHash(@PathVariable Map pathVariables){
        return pathVariables.toString();
    }

    @GetMapping("/cover-album/{Album}/cover-song/{Cover}")
    public String getByObject(DylanCovers dylanCovers){
        return String.format("Cover Album is %s, Cover song is %s", dylanCovers.getAlbum(), dylanCovers.getCover());
    }


}
