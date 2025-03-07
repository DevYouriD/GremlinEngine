package com.gremlinengine.generator.rest.controller;

import com.gremlinengine.generator.rest.model.dto.CvDto;
import com.gremlinengine.generator.rest.model.entity.Cv;
import com.gremlinengine.generator.rest.service.CvService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.Optional;

import static com.gremlinengine.generator.rest.utility.Paths.CREATE_CV;
import static com.gremlinengine.generator.rest.utility.Paths.DELETE_CV;
import static com.gremlinengine.generator.rest.utility.Paths.GET_ALL_CVS;
import static com.gremlinengine.generator.rest.utility.Paths.GET_CV_BY_ID;
import static com.gremlinengine.generator.rest.utility.Paths.UPDATE_CV;

//TODO Replace with more secure solution like dedicated corse config class (see CorsConfig.java)
@CrossOrigin(origins = "*", allowedHeaders = "*")

@RestController()
public class CvController {

    private final CvService cvService;

    public CvController(CvService cvService) {
        this.cvService = cvService;
    }

    // CREATE
    @PostMapping(path = CREATE_CV,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE )
    public ResponseEntity<Cv> create(@RequestBody Cv cv){
        Cv result = cvService.save(cv);
        return ResponseEntity.created(ServletUriComponentsBuilder.fromCurrentRequest().path("/" +
                result.getId()).buildAndExpand(result).toUri()).body(result);
    }

    // READ
    @GetMapping(path = GET_ALL_CVS)
    public ResponseEntity<Iterable<Cv>> getAll(){
        return ResponseEntity.ok(cvService.findAll());
    }

    @GetMapping(path = GET_CV_BY_ID)
    public ResponseEntity<Cv> findById(@PathVariable long id) {
        Optional<Cv> model = cvService.findById(id);
        return model.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // UPDATE
    @PutMapping(path = UPDATE_CV)
    public ResponseEntity<Cv> updateById(@PathVariable long id, @RequestBody CvDto cvDto) {
        Optional<Cv> optionalModel = cvService.update(cvDto, id);

        return optionalModel.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // DELETE
    @DeleteMapping(path = DELETE_CV)
    public ResponseEntity<Cv> delete(@PathVariable long id) {

        return cvService.deleteById(id) ?
                ResponseEntity.noContent().build() :
                ResponseEntity.notFound().build();

    }
}

