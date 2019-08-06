package com.masterthesis.ConsApp.model;

import com.fasterxml.jackson.annotation.JsonProperty;


public class PatientDocument {
    private final int patient_id;
    private final String document_path;

    public PatientDocument(@JsonProperty("patient_id") int patient_id, @JsonProperty("document_path") String document_path) {
        this.patient_id = patient_id;
        this.document_path = document_path;
    }

    public int getPatient_id() {
        return patient_id;
    }

    public String getDocument_path() {
        return document_path;
    }
}
