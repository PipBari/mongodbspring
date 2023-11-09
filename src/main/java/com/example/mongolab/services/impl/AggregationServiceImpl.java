package com.example.mongolab.services.impl;

import com.example.mongolab.dtos.AggregatedCatchInfoDto;
import com.example.mongolab.dtos.CatchDto;
import com.example.mongolab.dtos.FishermenDto;
import com.example.mongolab.dtos.FishingSpotsDto;
import com.example.mongolab.enums.FishType;
import com.example.mongolab.enums.FishermenNames;
import com.example.mongolab.enums.SpotsLocation;
import com.example.mongolab.services.AggregationService;
import com.example.mongolab.services.CatchService;
import com.example.mongolab.services.FishermenService;
import com.example.mongolab.services.FishingSpotsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AggregationServiceImpl implements AggregationService {
    @Autowired
    private CatchService catchService;
    @Autowired
    private FishermenService fishermenService;
    @Autowired
    private FishingSpotsService fishingSpotsService;
    @Override
    public List<AggregatedCatchInfoDto> getAggregatedInfo() {
        List<CatchDto> catchDtos = catchService.getAll();
        List<FishermenDto> fishermenDtos = fishermenService.getAll();
        List<FishingSpotsDto> fishingSpotsDtos = fishingSpotsService.getAll();
        List<AggregatedCatchInfoDto> aggregatedData = new ArrayList<>();
        for (CatchDto catchDto : catchDtos) {
            for (FishermenDto fishermenDto : fishermenDtos) {
                for (FishingSpotsDto fishingSpotsDto : fishingSpotsDtos) {
                    if (fishermenDto.getName().equals(FishermenNames.Artem) &&
                            catchDto.getFishType().equals(FishType.Salmon) &&
                            fishingSpotsDto.getSpotsLocation().equals(SpotsLocation.Baikal)) {
                        AggregatedCatchInfoDto aggregatedCatchInfoDto = new AggregatedCatchInfoDto(
                                fishermenDto.getName(),
                                catchDto.getFishType(),
                                fishingSpotsDto.getSpotsLocation()
                        );
                        aggregatedData.add(aggregatedCatchInfoDto);
                    }
                }
            }
        }
        return aggregatedData;
    }
    @Override
    public int getAggregatedInfoCount() {
        List<CatchDto> catchDtos = catchService.getAll();
        List<FishermenDto> fishermenDtos = fishermenService.getAll();
        List<FishingSpotsDto> fishingSpotsDtos = fishingSpotsService.getAll();

        long catchCount = catchDtos.stream().filter(c -> c.getFishType().equals(FishType.Salmon)).count();
        long fishermenCount = fishermenDtos.stream().filter(f -> f.getName().equals(FishermenNames.Artem)).count();
        long spotsCount = fishingSpotsDtos.stream().filter(s -> s.getSpotsLocation().equals(SpotsLocation.Baikal)).count();
        return (int) Math.min(Math.min(catchCount, fishermenCount), spotsCount);
    }

}
