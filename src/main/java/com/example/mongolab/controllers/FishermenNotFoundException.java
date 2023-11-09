package com.example.mongolab.controllers;

public class FishermenNotFoundException extends RuntimeException{
    FishermenNotFoundException(String id) {
        super("Could not find fisherman " + id);
    }
}
