package com.gremlinengine.generator.rest.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.gremlinengine.generator.rest.service.CvService;

@RestController()
public class TestController {

    private final CvService cvService;

    public TestController(CvService cvService) {
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

    // TEST ENDPOINT
    @GetMapping("/")
    public ResponseEntity<String> index(){
        return ResponseEntity.ok("Hello Youri!");
    }

}

