package com.masterthesis.ConsApp.model;

import com.fasterxml.jackson.annotation.JsonProperty;


public class DiagnosisType {
    private final int id;
    private final String name;
    private final String type;
    private final String description;


    public DiagnosisType(@JsonProperty("id") int id, @JsonProperty("name") String name, @JsonProperty("type") String type, @JsonProperty("description") String description) {
        this.id = id;
        this.name = name;
        this.type = type;
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

    public String getType() {
        return type;
    }
}
