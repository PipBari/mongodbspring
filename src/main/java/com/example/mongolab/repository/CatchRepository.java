package com.example.mongolab.repository;

import com.example.mongolab.models.Catch;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CatchRepository extends MongoRepository<Catch, String>{
}
