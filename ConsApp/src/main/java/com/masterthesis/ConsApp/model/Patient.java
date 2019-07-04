package com.masterthesis.ConsApp.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotBlank;


public class Patient {
    private final int id;
    @NotBlank
    private final String shortname;
    private final String gender;


    public Patient(@JsonProperty("id") int id, @JsonProperty("shortname") String shortname, @JsonProperty("gender") String gender) {
        this.id = id;
        this.shortname = shortname;
        this.gender = gender;
    }

    public int getId() {
        return id;
    }

    public String getShortname() {
        return shortname;
    }

    public String getGender() {
        return gender;
    }
}
