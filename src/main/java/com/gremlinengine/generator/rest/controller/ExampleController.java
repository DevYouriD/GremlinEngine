package com.gremlinengine.generator.rest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExampleController {

    // EXAMPLE CONTROLLER
    @GetMapping("/")
    public String index(){
        return "Hello Youri!";
    }

}
