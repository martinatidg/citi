package com.citi.reghub.rds.simulator.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.citi.reghub.rds.simulator.domain.Entity;

@Repository
public interface EntityRepository extends MongoRepository<Entity, String>{
}
