package com.masterthesis.ConsApp.model;

import com.fasterxml.jackson.annotation.JsonProperty;


public class PatientVideo {
    private final int patient_id;
    private final String video_path;

    public PatientVideo(@JsonProperty("patient_id") int patient_id, @JsonProperty("video_path") String video_path) {
        this.patient_id = patient_id;
        this.video_path = video_path;
    }

    public int getPatient_id() {
        return patient_id;
    }

    public String getVideo_path() {
        return video_path;
    }
}
