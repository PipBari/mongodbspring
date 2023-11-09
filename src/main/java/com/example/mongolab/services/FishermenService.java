package com.example.mongolab.services;

import com.example.mongolab.dtos.FishermenDto;
import org.bson.types.ObjectId;

import java.util.List;
import java.util.Optional;

public interface FishermenService {
    FishermenDto createFishermen(FishermenDto fishermenDto);

    List<FishermenDto> getAll();

    Optional<FishermenDto> findFishermen(ObjectId id);

    void delete(FishermenDto fishermenDto);

    void delete(ObjectId id);
}
