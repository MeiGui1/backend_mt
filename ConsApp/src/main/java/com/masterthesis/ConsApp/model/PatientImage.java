package com.masterthesis.ConsApp.model;

import com.fasterxml.jackson.annotation.JsonProperty;


public class PatientImage {
    private final int patient_id;
    private final String image_path;

    public PatientImage(@JsonProperty("patient_id") int patient_id, @JsonProperty("image_path") String image_path) {
        this.patient_id = patient_id;
        this.image_path = image_path;
    }

    public int getPatient_id() {
        return patient_id;
    }

    public String getImage_path() {
        return image_path;
    }
}
