package com.masterthesis.ConsApp.model;

import com.fasterxml.jackson.annotation.JsonProperty;


public class PatientWebsite {
    private final int patient_id;
    private final int website_id;

    public PatientWebsite(@JsonProperty("patient_id") int patient_id, @JsonProperty("website_id") int website_id) {
        this.patient_id = patient_id;
        this.website_id = website_id;
    }

    public int getPatient_id() {
        return patient_id;
    }

    public int getWebsite_id() {
        return website_id;
    }
}
