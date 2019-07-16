package com.masterthesis.ConsApp.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;


public class ExercisePhoto {
    private int id;
    @NotBlank
    private int patient_id;
    private byte[] photo;

    public ExercisePhoto(@JsonProperty("id") int id, @JsonProperty("patient_id") int patient_id, @JsonProperty("photo") byte[] photo) {
        this.id = id;
        this.patient_id = patient_id;
        this.photo = photo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPatient_id() {
        return patient_id;
    }

    public void setPatient_id(int patient_id) {
        this.patient_id = patient_id;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }
}
