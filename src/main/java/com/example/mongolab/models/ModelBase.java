package com.example.mongolab.models;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

public abstract  class  ModelBase {
    @Id
    private ObjectId id;

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }
}
