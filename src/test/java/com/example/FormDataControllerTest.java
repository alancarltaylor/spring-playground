package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by alantaylor on 2/19/17.
 */

@RunWith(SpringRunner.class)
@WebMvcTest(FormDataController.class)
public class FormDataControllerTest {
    @Autowired
    MockMvc mvc;

    @Test
    public void getByString() throws Exception {
        String Content = "Sunday";

        MockHttpServletRequestBuilder request1 = post("/app/today")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("content", Content)
                .param("month", "February");

        this.mvc.perform(request1)
                .andExpect(status().isOk())
                .andExpect(content().string(String.format("The month is February, the day is %s", Content)));

    }

    @Test
    public void getByHash() throws Exception {
        MockHttpServletRequestBuilder request2 = post("/app/yesterday")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("content", "Saturday")
                .param("month", "February");

        this.mvc.perform(request2)
                .andExpect(status().isOk())
                .andExpect(content().string(String.format("{content=Saturday, month=February}")));


    }
    @Test
    public void getByObject() throws Exception {
        MockHttpServletRequestBuilder request3 = post("/app/yester-yesterday")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("day", "Friday")
                .param("month", "February");

        this.mvc.perform(request3)
                .andExpect(status().isOk())
                .andExpect(content().string(String.format("The month was February, the day was Friday")));


    }

}
