package com.example.mongolab.services.impl;

import com.example.mongolab.dtos.FishingSpotsDto;
import com.example.mongolab.models.FishingSpots;
import com.example.mongolab.repository.FishingSpotsRepository;
import com.example.mongolab.services.FishingSpotsService;
import org.bson.types.ObjectId;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FishingSpotsServiceImpl implements FishingSpotsService {
    @Autowired
    private FishingSpotsRepository fishingSpotsRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public FishingSpotsDto createFishingSpots(FishingSpotsDto fishingSpotsDto) {
        FishingSpots fishingSpots = modelMapper.map(fishingSpotsDto, FishingSpots.class);
        return modelMapper.map(fishingSpotsRepository.save(fishingSpots), FishingSpotsDto.class);
    }
    @Override
    public List<FishingSpotsDto> getAll() {
        return fishingSpotsRepository.findAll().stream().map((b) -> modelMapper.map(b, FishingSpotsDto.class)).collect(Collectors.toList());
    }
    @Override
    public Optional<FishingSpotsDto> findFishingSpot(ObjectId id) {
        return Optional.ofNullable(modelMapper.map(fishingSpotsRepository.findById(id.toString()), FishingSpotsDto.class));
    }
    @Override
    public void delete(FishingSpotsDto fishingSpotsDto) {
        fishingSpotsRepository.deleteById(fishingSpotsDto.getId().toString());
    }
    @Override
    public void delete(ObjectId id) {
        fishingSpotsRepository.deleteById(id.toString());
    }
}
