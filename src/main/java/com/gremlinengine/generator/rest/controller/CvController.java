package com.gremlinengine.generator.rest.controller;

import com.gremlinengine.generator.rest.model.Cv;
import com.gremlinengine.generator.rest.service.CvService;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.Optional;

import static com.gremlinengine.generator.rest.utility.Paths.CREATE_CV;
import static com.gremlinengine.generator.rest.utility.Paths.DELETE_CV;
import static com.gremlinengine.generator.rest.utility.Paths.GET_ALL_CV;
import static com.gremlinengine.generator.rest.utility.Paths.GET_CV_BY_ID;

@RestController()
public class CvController {

    private final CvService cvService;

    public CvController(CvService cvService) {
        this.cvService = cvService;
    }

    // CREATE
    @PostMapping(path = CREATE_CV)
    public ResponseEntity<Cv> create(@RequestBody Cv cv){
        Cv result = this.cvService.save(cv);
        return ResponseEntity.created(ServletUriComponentsBuilder.fromCurrentRequest().path("/" +
                result.getId()).buildAndExpand(result).toUri()).body(result);
    }

    // READ
    @GetMapping(path = GET_ALL_CV)
    public ResponseEntity<Iterable<Cv>> getAll(){
        return ResponseEntity.ok(this.cvService.findAll());
    }

    @GetMapping(GET_CV_BY_ID)
    public ResponseEntity<Cv> findById(@PathVariable long id) {
        Optional<Cv> model = this.cvService.findById(id);
        return model.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // UPDATE
//    @PutMapping(path = UPDATE_CV)
//    public ResponseEntity<Cv> updateById(@PathVariable long id, @RequestBody CvDTO pokemonDTO) {
//        Optional<Cv> optionalModel = this.pokeService.update(pokemonDTO, id);
//
//        return optionalModel.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
//    }

    // DELETE
    @DeleteMapping(path = DELETE_CV)
    public ResponseEntity<Cv> delete(@PathVariable long id){
        Optional<Cv> updatedPlant = this.cvService.findById(id);

        if(updatedPlant.isPresent()) {
            this.cvService.deleteById(id);

            return ResponseEntity.noContent().build();
        }
        else { return ResponseEntity.notFound().build(); }
    }

}

