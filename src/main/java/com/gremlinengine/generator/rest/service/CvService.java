package com.gremlinengine.generator.rest.service;

import com.gremlinengine.generator.rest.model.Cv;
import com.gremlinengine.generator.rest.repository.CvRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;
import java.util.Optional;

@Service
public class CvService {

    private final CvRepository cvRepository;

    public CvService(CvRepository cvRepository) {
        this.cvRepository = cvRepository;
    }

    // CREATE
    @Transactional
    public Cv save(Cv cv) { return cvRepository.save(cv); }

    // READ
    public List<Cv> findAll() {
        return cvRepository.findAll();
    }

    public Optional<Cv> findById(long id) {
        return cvRepository.findById(id);
    }

    // UPDATE
//    @PutMapping
//    public Optional<ExampleModel> update(ExampleModelDTO exampleModelDTO, long id) {
//        Optional<ExampleModel> optionalModel = this.findById(id);
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
    public void deleteById(long id) {
        cvRepository.deleteById(id);
    }

}
