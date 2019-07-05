package com.masterthesis.ConsApp.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.constraints.NotBlank;


public class Patient {
    private int id;
    @NotBlank
    private String shortname;
    private String gender;

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

    public void setId(int id){
        this.id = id;
    }

    public void setShortname(String shortname) {
        this.shortname = shortname;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
