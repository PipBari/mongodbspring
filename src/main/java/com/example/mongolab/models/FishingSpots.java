package com.example.mongolab.models;

import com.example.mongolab.enums.SpotsLocation;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;

@Document(collection = "fishing_spots")
public class FishingSpots extends ModelBase{
    @Field(targetType = FieldType.STRING)
    private SpotsLocation spotsLocation;
    private String feedback;

    public FishingSpots(){}

    public FishingSpots(SpotsLocation spotsLocation, String feedback){
        this.spotsLocation=spotsLocation;
        this.feedback=feedback;
    }
    public SpotsLocation getSpotsLocation(){return spotsLocation;}
    public void setSpotsLocation(SpotsLocation spotsLocation){this.spotsLocation=spotsLocation;}
    public String getFeedback(){return feedback;}
    public void setFeedback(String feedback){this.feedback=feedback;}
}
