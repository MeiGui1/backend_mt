package com.masterthesis.ConsApp.model;

import com.fasterxml.jackson.annotation.JsonProperty;


public class PatientDiagnosis {
    private final int patient_id;
    private final int diagnosistype_id;
    private final String comment;

    public PatientDiagnosis(@JsonProperty("patient_id") int patient_id, @JsonProperty("diagnosistype_id") int diagnosistype_id, @JsonProperty("comment") String comment) {
        this.patient_id = patient_id;
        this.diagnosistype_id = diagnosistype_id;
        this.comment = comment;
    }

    public int getPatient_id() {
        return patient_id;
    }

    public int getDiagnosistype_id() {
        return diagnosistype_id;
    }

    public String getComment() {
        return comment;
    }
}
