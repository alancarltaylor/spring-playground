package com.example;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * Created by alantaylor on 2/20/17.
 */
@RestController
@RequestMapping("/json")
public class JsonGetController {
    @GetMapping("/blonde-on-blonde")
    public BlondeOnBlonde getAlbum(){
        BlondeOnBlonde blondeOnBlonde = new BlondeOnBlonde();
        blondeOnBlonde.setTracks();
        return blondeOnBlonde;
    }
}
