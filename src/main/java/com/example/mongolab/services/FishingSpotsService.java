package com.example.mongolab.services;

import com.example.mongolab.dtos.FishingSpotsDto;
import org.bson.types.ObjectId;

import java.util.List;
import java.util.Optional;

public interface FishingSpotsService {
    FishingSpotsDto createFishingSpots(FishingSpotsDto fishingSpotsDto);

    List<FishingSpotsDto> getAll();

    Optional<FishingSpotsDto> findFishingSpot(ObjectId id);

    void delete(FishingSpotsDto fishingSpotsDto);

    void delete(ObjectId id);
}
