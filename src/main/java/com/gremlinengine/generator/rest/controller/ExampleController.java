package com.gremlinengine.generator.rest.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.gremlinengine.generator.rest.service.CvService;

@RestController()
public class ExampleController {

    private final CvService cvService;

    public ExampleController(CvService cvService) {
        this.cvService = cvService;
    }

    @GetMapping("/api/hello")
    public ResponseEntity<String> sayHello() {
        return ResponseEntity.ok("Hello");
    }

    @GetMapping("/api/admin")
    public ResponseEntity<String> sayHelloToAdmin() {
        return ResponseEntity.ok("Hello Admin");
    }

    @GetMapping("/api/user")
    public ResponseEntity<String> sayHelloToUser() {
        return ResponseEntity.ok("Hello User");
    }

    // EXAMPLE CONTROLLER
    @GetMapping("/")
    public String index(){
        return "Hello Youri!";
    }

}

