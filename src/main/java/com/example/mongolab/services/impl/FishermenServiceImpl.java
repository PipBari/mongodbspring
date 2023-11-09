package com.example.mongolab.services.impl;

import com.example.mongolab.dtos.FishermenDto;
import com.example.mongolab.models.Fishermen;
import com.example.mongolab.repository.FishermenRepository;
import com.example.mongolab.services.FishermenService;
import org.bson.types.ObjectId;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FishermenServiceImpl implements FishermenService {
    @Autowired
    private FishermenRepository fishermenRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public FishermenDto createFishermen(FishermenDto fishermenDto) {
        Fishermen fishermen = modelMapper.map(fishermenDto, Fishermen.class);
        return modelMapper.map(fishermenRepository.save(fishermen), FishermenDto.class);
    }
    @Override
    public List<FishermenDto> getAll() {
        return fishermenRepository.findAll().stream().map((b) -> modelMapper.map(b, FishermenDto.class)).collect(Collectors.toList());
    }
    @Override
    public Optional<FishermenDto> findFishermen(ObjectId id) {
        return Optional.ofNullable(modelMapper.map(fishermenRepository.findById(id.toString()), FishermenDto.class));
    }
    @Override
    public void delete(FishermenDto fishermenDto) {
        fishermenRepository.deleteById(fishermenDto.getId().toString());
    }
    @Override
    public void delete(ObjectId id) {
        fishermenRepository.deleteById(id.toString());
    }
}
