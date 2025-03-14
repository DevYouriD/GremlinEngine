package com.gremlinengine.generator.rest.controller;

import com.gremlinengine.generator.rest.model.entity.Theme;
import com.gremlinengine.generator.rest.service.ThemeService;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.Optional;

import static com.gremlinengine.generator.rest.utility.Paths.CREATE_THEME;
import static com.gremlinengine.generator.rest.utility.Paths.DELETE_THEME;
import static com.gremlinengine.generator.rest.utility.Paths.GET_ALL_THEMES;
import static com.gremlinengine.generator.rest.utility.Paths.GET_THEME_BY_ID;

@RestController()
public class ThemeController {

    private final ThemeService themeService;

    public ThemeController(ThemeService themeService) {
        this.themeService = themeService;
    }
    
    // CREATE
    @PostMapping(path = CREATE_THEME)
    public ResponseEntity<Theme> create(@RequestBody Theme theme){
        Theme result = themeService.save(theme);
        return ResponseEntity.created(ServletUriComponentsBuilder.fromCurrentRequest().path("/" +
                result.getId()).buildAndExpand(result).toUri()).body(result);
    }

    // READ
    @GetMapping(path = GET_ALL_THEMES)
    public ResponseEntity<Iterable<Theme>> getAll(){
        return ResponseEntity.ok(themeService.findAll());
    }

    @GetMapping(path = GET_THEME_BY_ID)
    public ResponseEntity<Theme> findById(@PathVariable long id) {
        Optional<Theme> model = themeService.findById(id);
        return model.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // UPDATE
//    @PutMapping(path = UPDATE_THEME)
//    public ResponseEntity<Theme> updateById(@PathVariable long id, @RequestBody ThemeDTO pokemonDTO) {
//        Optional<Theme> optionalModel = pokeService.update(pokemonDTO, id);
//
//        return optionalModel.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
//    }

    // DELETE
    @DeleteMapping(path = DELETE_THEME)
    public ResponseEntity<Theme> delete(@PathVariable long id){

        return themeService.deleteThemeById(id) ?
                ResponseEntity.noContent().build() :
                ResponseEntity.notFound().build();
        }

}

