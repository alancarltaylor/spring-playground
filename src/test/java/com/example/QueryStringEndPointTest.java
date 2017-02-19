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
@WebMvcTest(QueryStringEndPoint.class)
public class QueryStringEndPointTest {
    @Autowired
    MockMvc mvc;

    @Test
    public void AcceptsByName() throws Exception {
            this.mvc.perform(get("/dylan/best?best-album=Tempest&best-song=Joey"))
                    .andExpect(status().isOk())
                    .andExpect(content().string("His best album is Tempest, his best song is Joey"));
    }

    @Test
    public void AcceptsAsHashmap() throws Exception {
            this.mvc.perform(get("/dylan/worst?worst-album=Dylan&worst-song=Wiggle"))
                    .andExpect(status().isOk())
                    .andExpect(content().string("{worst-album=Dylan, worst-song=Wiggle}"));

    }

    @Test
    public void AcceptsAsCustomObject() throws Exception {
            this.mvc.perform(get("/dylan/cover?artist=Aufray&cover=Heartland"))
                    .andExpect(status().isOk())
                    .andExpect(content().string("The best cover of Dylan is Heartland by Aufray"));

    }

}
