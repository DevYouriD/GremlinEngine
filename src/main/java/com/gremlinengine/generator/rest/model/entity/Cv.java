package com.gremlinengine.generator.rest.model.entity;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.sql.Blob;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "cv")
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class Cv {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "email_address")
    private String emailAddress;

    private String title;

    @Lob
    private Blob picture;

    @Column(name = "about_me")
    private String aboutMe;

    private String skills;

    private String education;

    @Column(name = "employment_history")
    private String employmentHistory;

    private String languages;

    private String certificates;

    private String hobbies;

    private String projects;

    private String publications;

    private String awards;

    private String references;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "cv_id")
    private List<Link> links = new ArrayList<>();

    @OneToOne(mappedBy = "cv", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference
    private Address address;

    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    private Theme theme;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cv cv = (Cv) o;
        return Objects.equals(id, cv.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}