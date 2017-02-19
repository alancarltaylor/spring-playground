package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by alantaylor on 2/18/17.
 */

@RunWith(SpringRunner.class)
@WebMvcTest(EndPointsController.class)
public class EndPointsControllerTest {
    @Autowired
    MockMvc mvc;

    @Test
    public void getTasks() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.get("/app/tasks");

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string("These are the tasks"));

    }
    @Test
    public void postTasks() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.post("/app/tasks");

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string("You just posted to tasks!"));
    }

}
