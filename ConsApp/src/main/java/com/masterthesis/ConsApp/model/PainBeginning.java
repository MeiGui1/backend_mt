package com.masterthesis.ConsApp.model;

import com.fasterxml.jackson.annotation.JsonProperty;


public class PainBeginning {
    private final int patient_id;
    private final int intensity;
    private final byte[] location_teeth;
    private final byte[] location_face_left;
    private final byte[] location_face_right;
    private final String pain_pattern;
    private final boolean dull;
    private final boolean pulling;
    private final boolean stinging;
    private final boolean pulsating;
    private final boolean burning;
    private final boolean pinsneedles;
    private final boolean tingling;
    private final boolean numb;

    public PainBeginning(@JsonProperty("patient_id") int patient_id,
                         @JsonProperty("intensity") int intensity,
                         @JsonProperty("location_teeth") byte[] location_teeth, @JsonProperty("location_face_left") byte[] location_face_left, @JsonProperty("location_face_right") byte[] location_face_right,
                         @JsonProperty("pain_pattern") String pain_pattern,
                         @JsonProperty("dull") boolean dull, @JsonProperty("pulling") boolean pulling, @JsonProperty("stinging") boolean stinging,
                         @JsonProperty("pulsating") boolean pulsating, @JsonProperty("burning") boolean burning, @JsonProperty("pinsneedles") boolean pinsneedles,
                         @JsonProperty("tingling") boolean tingling, @JsonProperty("numb") boolean numb) {
        this.patient_id = patient_id;
        this.intensity = intensity;
        this.location_teeth = location_teeth;
        this.location_face_left = location_face_left;
        this.location_face_right = location_face_right;
        this.pain_pattern = pain_pattern;
        this.dull = dull;
        this.pulling = pulling;
        this.stinging = stinging;
        this.pulsating = pulsating;
        this.burning = burning;
        this.pinsneedles = pinsneedles;
        this.tingling = tingling;
        this.numb = numb;
    }

    public int getPatient_id() {
        return patient_id;
    }

    public int getIntensity() {
        return intensity;
    }

    public byte[] getLocation_teeth() {
        return location_teeth;
    }

    public byte[] getLocation_face_left() {
        return location_face_left;
    }

    public byte[] getLocation_face_right() {
        return location_face_right;
    }

    public String getPain_pattern() {
        return pain_pattern;
    }

    public boolean isDull() {
        return dull;
    }

    public boolean isPulling() {
        return pulling;
    }

    public boolean isStinging() {
        return stinging;
    }

    public boolean isPulsating() {
        return pulsating;
    }

    public boolean isBurning() {
        return burning;
    }

    public boolean isPinsneedles() {
        return pinsneedles;
    }

    public boolean isTingling() {
        return tingling;
    }

    public boolean isNumb() {
        return numb;
    }
}
