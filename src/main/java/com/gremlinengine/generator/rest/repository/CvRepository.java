package com.gremlinengine.generator.rest.repository;

import com.gremlinengine.generator.rest.model.Cv;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CvRepository extends JpaRepository<Cv, Long> { }
