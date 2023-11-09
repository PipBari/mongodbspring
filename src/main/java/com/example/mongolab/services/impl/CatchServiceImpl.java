package com.example.mongolab.services.impl;

import com.example.mongolab.dtos.CatchDto;
import com.example.mongolab.models.Catch;
import com.example.mongolab.repository.CatchRepository;
import com.example.mongolab.services.CatchService;
import org.bson.types.ObjectId;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CatchServiceImpl implements CatchService {
    @Autowired
    private CatchRepository catchRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public CatchDto createCatch(CatchDto catchDto) {
        Catch aCatch = modelMapper.map(catchDto, Catch.class);
        return modelMapper.map(catchRepository.save(aCatch), CatchDto.class);
    }
    @Override
    public List<CatchDto> getAll() {
        return catchRepository.findAll().stream().map((b) -> modelMapper.map(b, CatchDto.class)).collect(Collectors.toList());
    }
    @Override
    public Optional<CatchDto> findCatch(ObjectId id) {
        return Optional.ofNullable(modelMapper.map(catchRepository.findById(id.toString()), CatchDto.class));
    }
    @Override
    public void delete(CatchDto catchDto) {
        catchRepository.deleteById(catchDto.getId().toString());
    }
    @Override
    public void delete(ObjectId id) {
        catchRepository.deleteById(id.toString());
    }
}
