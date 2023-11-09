package com.example.mongolab.repository;

import com.example.mongolab.models.FishingSpots;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FishingSpotsRepository extends MongoRepository<FishingSpots, String> {
}
