package com.masterthesis.ConsApp.model;

import com.fasterxml.jackson.annotation.JsonProperty;


public class PatientExercise {
    private final int patient_id;
    private final String exercisetype_title;

    public PatientExercise(@JsonProperty("patient_id") int patient_id, @JsonProperty("exercisetype_title") String exercisetype_title) {
        this.patient_id = patient_id;
        this.exercisetype_title = exercisetype_title;
    }

    public int getPatient_id() {
        return patient_id;
    }

    public String getExercisetype_title() {
        return exercisetype_title;
    }
}
