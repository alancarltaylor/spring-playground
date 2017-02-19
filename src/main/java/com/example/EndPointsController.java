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

    @GetMapping("/shoppinglist")
    public String getShoppingList(){
        return "eggs, bananas, beer";
    }

    @PostMapping("/shoppinglist")
    public String postShoppingList(){
        return "You just posted to shoppinglist!";
    }
}
