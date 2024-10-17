package com.gremlinengine.generator.rest.service;

import com.gremlinengine.generator.rest.model.entity.Theme;
import com.gremlinengine.generator.rest.repository.ThemeRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ThemeService {

    private final ThemeRepository themeRepository;

    public ThemeService(ThemeRepository themeRepository) {
        this.themeRepository = themeRepository;
    }

    // CREATE
    @Transactional
    public Theme save(Theme theme) { return themeRepository.save(theme); }

    // READ
    public List<Theme> findAll() {
        return themeRepository.findAll();
    }

    public Optional<Theme> findById(long id) {
        return themeRepository.findById(id);
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
    public boolean deleteThemeById(long id) {
        Optional<Theme> theme = findById(id);

        if (theme.isPresent()) {
            themeRepository.deleteById(id);
            return true;
        }
        return false;
    }

}
