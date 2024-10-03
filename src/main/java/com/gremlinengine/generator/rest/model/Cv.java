package com.gremlinengine.generator.rest.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Blob;
import java.util.List;

@Entity
public class Cv {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private @Getter @Setter Long id;
    private @Getter @Setter String firstName;
    private @Getter @Setter String lastName;

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private @Getter @Setter Long id;
//    private @Getter @Setter String firstName;
//    private @Getter @Setter String lastName;
//    private @Getter @Setter String phoneNumber;
//    private @Getter @Setter String emailAddress;
//    private @Getter @Setter String title;
//
//    @ElementCollection
//    private @Getter @Setter List<String> links;
//
//    @Lob
//    private @Getter @Setter Blob picture;
//    private @Getter @Setter String aboutMe;
//    private @Getter @Setter String skills;
//    private @Getter @Setter String education;
//    private @Getter @Setter String employmentHistory;
//    private @Getter @Setter String languages;
//    private @Getter @Setter String certificates;
//    private @Getter @Setter String hobbies;
//    private @Getter @Setter String projects;
//    private @Getter @Setter String publications;
//    private @Getter @Setter String awards;
//    private @Getter @Setter String references;
//
//    @OneToOne
//    private @Getter @Setter Address address;
//
//    @OneToOne
//    private @Getter @Setter Theme theme;

}