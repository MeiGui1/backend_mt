package com.masterthesis.ConsApp.model;

import com.fasterxml.jackson.annotation.JsonProperty;


public class ImprovementReason {
    private final int patient_id;
    private final boolean drugs;
    private final boolean exercises;
    private final boolean awareness;
    private final boolean other_reason;
    private final String other_reason_text;


    public ImprovementReason(@JsonProperty("patient_id") int patient_id,
                             @JsonProperty("drugs") boolean drugs,
                             @JsonProperty("exercises") boolean exercises,
                             @JsonProperty("awareness") boolean awareness,
                             @JsonProperty("other_reason") boolean other_reason, @JsonProperty("other_reason_text") String other_reason_text) {
        this.patient_id = patient_id;
        this.drugs = drugs;
        this.exercises = exercises;
        this.awareness = awareness;
        this.other_reason = other_reason;
        this.other_reason_text = other_reason_text;
    }

    public int getPatient_id() {
        return patient_id;
    }

    public boolean isDrugs() {
        return drugs;
    }

    public boolean isExercises() {
        return exercises;
    }

    public boolean isAwareness() {
        return awareness;
    }

    public boolean isOther_reason() {
        return other_reason;
    }

    public String getOther_reason_text() {
        return other_reason_text;
    }
}
