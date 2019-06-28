package com.masterthesis.ConsApp.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;
import java.util.UUID;

public class Patient {
    private final UUID id;
    @NotBlank
    private final String shortname;
    private final String gender;


    public Patient(@JsonProperty("id") UUID id, @JsonProperty("shortname") String shortname, @JsonProperty("gender") String gender) {
        this.id = id;
        this.shortname = shortname;
        this.gender = gender;
    }

    public UUID getId() {
        return id;
    }

    public String getShortname() {
        return shortname;
    }

    public String getGender() {
        return gender;
    }
}
