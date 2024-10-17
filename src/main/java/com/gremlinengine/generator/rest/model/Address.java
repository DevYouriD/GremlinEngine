package com.gremlinengine.generator.rest.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private @Getter @Setter Long id;
    private @Getter @Setter String street;
    private @Getter @Setter String city;
    private @Getter @Setter String state;
    private @Getter @Setter String country;
    private @Getter @Setter String postalCode;

}
