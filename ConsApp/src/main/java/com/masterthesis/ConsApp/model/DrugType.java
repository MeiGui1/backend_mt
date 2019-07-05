package com.masterthesis.ConsApp.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;


public class DrugType {
    private final int id;
    private final String name;
    private final String description;


    public DrugType(@JsonProperty("id") int id, @JsonProperty("name") String name, @JsonProperty("description") String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
