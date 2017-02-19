package com.example;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class PagesController{

  @GetMapping("/hello")
  public String hello(){
    return "Hello World";
  }
}
