package com.gremlinengine.generator.rest.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "address")
@Getter @Setter
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @Convert(converter = EncryptionConverter.class)
    private String street;

//    @Convert(converter = EncryptionConverter.class)
    private String city;

//    @Convert(converter = EncryptionConverter.class)
    private String state;

//    @Convert(converter = EncryptionConverter.class)
    private String country;

//    @Convert(converter = EncryptionConverter.class)
    @Column(name = "postal_code")
    private String postalCode;

    @OneToOne(fetch = FetchType.LAZY)
    @JsonBackReference
    private Cv cv;

}
