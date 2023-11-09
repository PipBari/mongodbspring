package com.example.mongolab.dtos;

import com.example.mongolab.enums.SpotsLocation;
import com.example.mongolab.models.FishingSpots;
import org.bson.types.ObjectId;

public class FishingSpotsDto {
    private ObjectId id;
    private SpotsLocation spotsLocation;
    private String feedback;

    public FishingSpotsDto(){}

    public FishingSpotsDto(ObjectId id, SpotsLocation spotsLocation, String feedback){
        this.id=id;
        this.spotsLocation=spotsLocation;
        this.feedback=feedback;
    }
    public ObjectId getId(){return id;}
    public void setId(ObjectId id){this.id=id;}
    public SpotsLocation getSpotsLocation(){return spotsLocation;}
    public void setSpotsLocation(SpotsLocation spotsLocation){this.spotsLocation=spotsLocation;}
    public String getFeedback(){return feedback;}
    public void setFeedback(String feedback){this.feedback=feedback;}
}
