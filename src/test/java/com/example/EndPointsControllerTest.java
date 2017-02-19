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
    public void getShoppingList() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.get("/app/shoppinglist");

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string("eggs, bananas, beer"));

    }
    @Test
    public void postShoppingList() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.post("/app/shoppinglist");

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string("You just posted to shoppinglist!"));
    }

}
