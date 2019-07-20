package com.masterthesis.ConsApp.model;

import com.fasterxml.jackson.annotation.JsonProperty;


public class Note {
    private final int id;
    private final int patient_id;
    private final byte[] note_bytes;
    private final boolean selected;


    public Note(@JsonProperty("id") int id, @JsonProperty("patient_id") int patient_id, @JsonProperty("note_bytes") byte[] note_bytes, @JsonProperty("selected") boolean selected) {
        this.id = id;
        this.patient_id = patient_id;
        this.note_bytes = note_bytes;
        this.selected = selected;
    }

    public int getId() {
        return id;
    }

    public int getPatient_id() {
        return patient_id;
    }

    public byte[] getNote_bytes() {
        return note_bytes;
    }

    public boolean isSelected() {
        return selected;
    }
}
