package com.gremlinengine.generator.rest.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "theme")
@NoArgsConstructor
@Getter @Setter
public class Theme {

    public Theme(String name, String fileName) {
        this.name = name;
        this.fileName = fileName;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(name = "file_name")
    private String fileName;

    @OneToMany(mappedBy = "theme", cascade = CascadeType.ALL,  orphanRemoval = true)
    @JsonIgnore
    private Set<Cv> cvs;

    public void addCv(Cv cv) {
        cvs.add(cv);
        cv.setTheme(this);
    }

    public void deleteCv(Cv cv) {
        cvs.remove(cv);
        cv.setTheme(null);
    }
}
