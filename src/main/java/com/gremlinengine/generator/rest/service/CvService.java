package com.gremlinengine.generator.rest.service;

import com.gremlinengine.generator.rest.model.dto.CvDto;
import com.gremlinengine.generator.rest.model.entity.Cv;
import com.gremlinengine.generator.rest.repository.CvRepository;
import com.gremlinengine.generator.rest.utility.CvUtil;
import com.gremlinengine.generator.security.keycloak.AuthenticatedUserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CvService {

    private final CvRepository cvRepository;
    private final AuthenticatedUserService authenticatedUserService;

    public CvService(CvRepository cvRepository, AuthenticatedUserService authenticatedUserService) {
        this.cvRepository = cvRepository;
        this.authenticatedUserService = authenticatedUserService;
    }

    // CREATE
    @Transactional
    public Cv save(Cv cv) {
        String keycloakUserId = authenticatedUserService.getUserId();
//        String firstName = authenticatedUserService.getFirstName();
//        String lastName = authenticatedUserService.getLastName();
//        String email = authenticatedUserService.getEmail();
        cv.setKeycloakUserId(keycloakUserId);
        return cvRepository.save(cv); }

    // READ
    public List<Cv> findAll() {
        return cvRepository.findAll();
    }

    public Optional<Cv> findById(long id) {
        return cvRepository.findById(id);
    }

    // UPDATE
    @Transactional
    public Optional<Cv> update(CvDto cvDto, long id) {
        Optional<Cv> updatedCv = findById(id);

        if (updatedCv.isPresent()) {
            Cv target = updatedCv.get();

            target.setFirstName(cvDto.firstName());
            target.setLastName(cvDto.lastName());
            target.setPhoneNumber(cvDto.phoneNumber());
            target.setEmailAddress(cvDto.emailAddress());
            target.setTitle(cvDto.title());
            target.setPicture(cvDto.picture());
            target.setAboutMe(cvDto.aboutMe());
            target.setSkills(cvDto.skills());
            target.setEducation(cvDto.education());
            target.setEmploymentHistory(cvDto.employmentHistory());
            target.setLanguages(cvDto.languages());
            target.setCertificates(cvDto.certificates());
            target.setHobbies(cvDto.hobbies());
            target.setProjects(cvDto.projects());
            target.setPublications(cvDto.publications());
            target.setAwards(cvDto.awards());
            target.setReferences(cvDto.references());
            CvUtil.handleLinks(cvDto, target);
            CvUtil.handleAddress(cvDto, target);
            CvUtil.handleTheme(cvDto, target);

            return Optional.of(cvRepository.save(target));
        }
        return Optional.empty();
    }

    // DELETE
    public boolean deleteById(long id) {
        Optional<Cv> cv = findById(id);

        if (cv.isPresent()) {
            cvRepository.deleteById(id);
            return true;
        }
        return false;
    }

}
