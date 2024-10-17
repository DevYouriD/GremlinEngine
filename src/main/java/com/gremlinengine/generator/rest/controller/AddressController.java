package com.gremlinengine.generator.rest.controller;

import com.gremlinengine.generator.rest.model.Address;
import com.gremlinengine.generator.rest.service.AddressService;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.Optional;

import static com.gremlinengine.generator.rest.utility.Paths.CREATE_ADDRESS;
import static com.gremlinengine.generator.rest.utility.Paths.DELETE_ADDRESS;
import static com.gremlinengine.generator.rest.utility.Paths.DELETE_CV;
import static com.gremlinengine.generator.rest.utility.Paths.GET_ALL_ADDRESS;
import static com.gremlinengine.generator.rest.utility.Paths.GET_CV_ADDRESS_ID;

@RestController()
public class AddressController {

    private final AddressService addressService;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }
    
    // CREATE
    @PostMapping(path = CREATE_ADDRESS)
    public ResponseEntity<Address> create(@RequestBody Address cv){
        Address result = this.addressService.save(cv);
        return ResponseEntity.created(ServletUriComponentsBuilder.fromCurrentRequest().path("/" +
                result.getId()).buildAndExpand(result).toUri()).body(result);
    }

    // READ
    @GetMapping(path = GET_ALL_ADDRESS)
    public ResponseEntity<Iterable<Address>> getAll(){
        return ResponseEntity.ok(this.addressService.findAll());
    }

    @GetMapping(path = GET_CV_ADDRESS_ID)
    public ResponseEntity<Address> findById(@PathVariable long id) {
        Optional<Address> model = this.addressService.findById(id);
        return model.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // UPDATE
//    @PutMapping(path = UPDATE_ADDRESS)
//    public ResponseEntity<Address> updateById(@PathVariable long id, @RequestBody AddressDTO pokemonDTO) {
//        Optional<Address> optionalModel = this.pokeService.update(pokemonDTO, id);
//
//        return optionalModel.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
//    }

    // DELETE
    @DeleteMapping(path = DELETE_ADDRESS)
    public ResponseEntity<Address> delete(@PathVariable long id){
        Optional<Address> updatedPlant = this.addressService.findById(id);

        if(updatedPlant.isPresent()) {
            this.addressService.deleteById(id);

            return ResponseEntity.noContent().build();
        }
        else { return ResponseEntity.notFound().build(); }
    }

}