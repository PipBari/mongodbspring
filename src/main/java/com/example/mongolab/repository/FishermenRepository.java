package com.example.mongolab.repository;

import com.example.mongolab.models.Fishermen;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FishermenRepository extends MongoRepository<Fishermen, String> {
}
