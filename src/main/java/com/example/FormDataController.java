package com.example;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.Map;

/**
 * Created by alantaylor on 2/19/17.
 */
@RestController
@RequestMapping("/app")
public class FormDataController {
    @PostMapping("/today")
    public String getByString(@RequestParam("content") String Content, @RequestParam("month") String Month){

        return String.format("The month is %s, the day is %s", Month, Content);
    }

    @PostMapping(value = "/yesterday", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String getbyHash(@RequestParam Map<String, String> body){
        return body.toString();
    }

    @PostMapping(value = "/yester-yesterday", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String getByObject(DayBeforeYesterday day){
        return String.format("The month was %s, the day was %s", day.getMonth(), day.getDay());
    }


}
