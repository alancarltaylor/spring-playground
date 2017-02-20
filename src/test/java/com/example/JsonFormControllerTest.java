package com.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

import org.json.JSONString;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by alantaylor on 2/19/17.
 */
@RunWith(SpringRunner.class)
@WebMvcTest(JsonFormController.class)
public class JsonFormControllerTest {
    @Autowired
    private MockMvc mvc;

    private Gson gson = new GsonBuilder().create();

    static class SearchRequestParams {
        final String hometown;
        final String homestate;
        SearchRequestParams(String hometown, String homestate) {
            this.hometown = hometown;
            this.homestate = homestate;
        }
    }




    @Test
    public void testObjectParams() throws Exception {
        JsonObject Dylan = new JsonObject();
        Dylan.addProperty("type", "Folk R&B");
        Gson build = new GsonBuilder().create();
        String jsonString = build.toJson(Dylan);

        MockHttpServletRequestBuilder request = post("/dylan/genres")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonString);


        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string("Folk R&B"));
    }

    @Test
    public void testSerializedParams() throws Exception {
        SearchRequestParams params = new SearchRequestParams("Hibbing", "Minnesota");
        MockHttpServletRequestBuilder request2 = post("/dylan/hometown")
                .contentType(MediaType.APPLICATION_JSON)
                .content(gson.toJson(params));

        this.mvc.perform(request2)
                .andExpect(status().isOk())
                .andExpect(content().string("Hibbing, Minnesota"));
    }

    @Test
    public void testFromFixtures() throws Exception {

        String json = getJSON("/data.json");

        MockHttpServletRequestBuilder request3 = post("dylan/fashion")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json);

        this.mvc.perform(request3)
                .andExpect(status().isOk())
                .andExpect(content().string(""));



    }

    private String getJSON(String path) throws Exception {
        URL url = this.getClass().getResource(path);
        return new String(Files.readAllBytes(Paths.get(url.getFile())));
    }

}

