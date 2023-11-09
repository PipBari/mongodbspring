package com.example.mongolab.services;

import com.example.mongolab.dtos.CatchDto;
import org.bson.types.ObjectId;

import java.util.List;
import java.util.Optional;

public interface CatchService {
    CatchDto createCatch(CatchDto catchDto);

    List<CatchDto> getAll();

    Optional<CatchDto> findCatch(ObjectId id);

    void delete(CatchDto catchDto);

    void delete(ObjectId id);

}
