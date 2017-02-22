package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;


//import static java.lang.CharacterName.get;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by alantaylor on 2/20/17.
 */
@RunWith(SpringRunner.class)
@WebMvcTest(JsonGetController.class)
public class JsonGetControllerTest {
    @Autowired
    private
    MockMvc mvc;

    @Test
    public void getJsonObject() throws Exception {
        this.mvc.perform(get("/json/blonde-on-blonde")
                    .accept(MediaType.APPLICATION_JSON_UTF8)
                    .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.year", is ("1965")))
                .andExpect(jsonPath("$.numberOfTracks", is ("14")))
                .andExpect(jsonPath("$.tracks[4].title", is ("I want you")))
                .andExpect(jsonPath("$.tracks[2].length", is ("7:33")))
                .andExpect(jsonPath("$.tracks[5].length", is ("3:07")))
                .andExpect(jsonPath("$.tracks[0].title", is ("Rainy Day Women #12 & 35")))
                .andExpect(jsonPath("$.tracks[1].title", is ("Pledging My Time")));
    }


}
