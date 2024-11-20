package com.gremlinengine.generator.rest.model.dto;

import com.gremlinengine.generator.rest.model.entity.Address;
import com.gremlinengine.generator.rest.model.entity.Link;
import com.gremlinengine.generator.rest.model.entity.Theme;

import java.sql.Blob;
import java.util.List;

public record CvDto(
        Long id,
        String firstName,
        String lastName,
        String phoneNumber,
        String emailAddress,
        String title,
        Blob picture,
        String aboutMe,
        String skills,
        String education,
        String employmentHistory,
        String languages,
        String certificates,
        String hobbies,
        String projects,
        String publications,
        String awards,
        String references,
        List<Link> links,
        Address address,
        Theme theme
) {}

