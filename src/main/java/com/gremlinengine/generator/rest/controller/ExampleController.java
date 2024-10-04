package com.gremlinengine.generator.rest.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import com.gremlinengine.generator.rest.model.Cv;
import com.gremlinengine.generator.rest.service.CvService;

import java.util.Optional;

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

    // CREATE
    @PostMapping("/create")
    public ResponseEntity<Cv> create(@RequestBody Cv cv){
        Cv result = this.cvService.save(cv);
        return ResponseEntity.created(ServletUriComponentsBuilder.fromCurrentRequest().path("/" +
                result.getId()).buildAndExpand(result).toUri()).body(result);
    }

    // READ
    @GetMapping("/get-all")
    public ResponseEntity<Iterable<Cv>> getAll(){
        return ResponseEntity.ok(this.cvService.findAll());
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Cv> findById(@PathVariable long id) {
        Optional<Cv> model = this.cvService.findById(id);
        return model.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // UPDATE
//    @PutMapping("update/{id}")
//    public ResponseEntity<Cv> updateById(@PathVariable long id, @RequestBody CvDTO pokemonDTO) {
//        Optional<Cv> optionalModel = this.pokeService.update(pokemonDTO, id);
//
//        return optionalModel.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
//    }

    // DELETE
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Cv> delete(@PathVariable long id){
        Optional<Cv> updatedPlant = this.cvService.findById(id);

        if(updatedPlant.isPresent()) {
            this.cvService.deleteById(id);

            return ResponseEntity.noContent().build();
        }
        else { return ResponseEntity.notFound().build(); }
    }

}

