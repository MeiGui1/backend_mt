package com.masterthesis.ConsApp.model;

import com.fasterxml.jackson.annotation.JsonProperty;


public class PatientDrug {
    private final int patient_id;
    private final int drugtype_id;

    private final String amount;
    private final String dosis;


    public PatientDrug(@JsonProperty("patient_id") int patient_id, @JsonProperty("drugtype_id") int drugtype_id, @JsonProperty("amount") String amount, @JsonProperty("dosis") String dosis) {
        this.patient_id = patient_id;
        this.drugtype_id = drugtype_id;
        this.amount = amount;
        this.dosis = dosis;
    }

    public int getPatient_id() {
        return patient_id;
    }

    public int getDrugtype_id() {
        return drugtype_id;
    }

    public String getAmount() {
        return amount;
    }

    public String getDosis() {
        return dosis;
    }
}
