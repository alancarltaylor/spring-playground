package com.example;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by alantaylor on 2/18/17.
 */

@RestController
@RequestMapping("/app")
public class EndPointsController {
    @GetMapping("/")
    public String getIndex(){
        return "Welcome to the home route";
    }

    @GetMapping("/tasks")
    public String getTasks(){
        return "These are the tasks";
    }

    @PostMapping("/tasks")
    public String postTasks(){
        return "You just posted to tasks!";
    }
}
