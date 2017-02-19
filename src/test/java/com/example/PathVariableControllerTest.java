package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;


/**
 * Created by alantaylor on 2/19/17.
 */
@RunWith(SpringRunner.class)
@WebMvcTest(PathVariableController.class)
public class PathVariableControllerTest {
    @Autowired
    MockMvc mvc;

    @Test
    public void getByName() throws Exception {
        int AlbumId = 16;
        this.mvc.perform(get(String.format("/dylan/albums/%d", AlbumId)))
                .andExpect(status().isOk())
                .andExpect(content().string("Album ID is 16"));

    }
    @Test
    public void getByHash() throws Exception {
        int SongId = 55;
        this.mvc.perform(get(String.format("/dylan/songs/%d", SongId)))
                .andExpect(status().isOk())
                .andExpect(content().string("{SongId=55}"));

    }
    @Test
    public void getByObject() throws Exception {
        String Album = "I'm not There";
        String Song = "Going to Alcapulco";

        this.mvc.perform(get(String.format("/dylan/cover-album/%s/cover-song/%s", Album, Song)))
                .andExpect(status().isOk())
                .andExpect(content().string("Cover Album is I'm not There, Cover song is Going to Alcapulco"));

    }




}
