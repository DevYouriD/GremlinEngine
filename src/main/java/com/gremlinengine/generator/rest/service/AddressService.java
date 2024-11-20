package com.gremlinengine.generator.rest.service;

import com.gremlinengine.generator.rest.model.entity.Address;
import com.gremlinengine.generator.rest.repository.AddressRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class AddressService {

    private final AddressRepository addressRepository;

    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    // CREATE
    @Transactional
    public Address save(Address address) { return addressRepository.save(address); }

    // READ
    public List<Address> findAll() {
        return addressRepository.findAll();
    }

    public Optional<Address> findById(long id) {
        return addressRepository.findById(id);
    }

    // UPDATE
//    @PutMapping
//    public Optional<ExampleModel> update(ExampleModelDTO exampleModelDTO, long id) {
//        Optional<ExampleModel> optionalModel = findById(id);
//
//        if (optionalModel.isPresent()) {
//            ExampleModel target = optionalModel.get();
//            target.setFirstName(exampleModelDTO.firstName());
//            target.setLastName(exampleModelDTO.lastName());
//            target.setAge(exampleModelDTO.age());
//            return Optional.of(exampleRepository.save(target));
//        }
//        return Optional.empty();
//    }

    // DELETE
    public boolean deleteById(long id) {
        Optional<Address> address = findById(id);

        if (address.isPresent()) {
            addressRepository.deleteById(id);
            return true;
        }
        return false;
    }

}
