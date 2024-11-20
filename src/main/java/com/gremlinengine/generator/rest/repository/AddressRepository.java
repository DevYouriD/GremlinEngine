package com.gremlinengine.generator.rest.repository;

import com.gremlinengine.generator.rest.model.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> { }
