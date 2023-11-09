package com.example.mongolab.services;

import com.example.mongolab.dtos.AggregatedCatchInfoDto;

import java.util.List;

public interface AggregationService {
    List<AggregatedCatchInfoDto> getAggregatedInfo();

    /* @Override
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
         }*/
    int getAggregatedInfoCount();
}
