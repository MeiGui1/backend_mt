package com.masterthesis.ConsApp.model;

import com.fasterxml.jackson.annotation.JsonProperty;


public class PsychoSocialBefore {

    private final int patient_id;

    private final int pain_xpos;
    private final int pain_ypos;

    private final int family_xpos;
    private final int family_ypos;

    private final int work_xpos;
    private final int work_ypos;

    private final int finance_xpos;
    private final int finance_ypos;

    private final int event_xpos;
    private final int event_ypos;


    public PsychoSocialBefore(@JsonProperty("patient_id") int patient_id,
                              @JsonProperty("pain_xpos") int pain_xpos, @JsonProperty("pain_ypos") int pain_ypos,
                              @JsonProperty("family_xpos") int family_xpos, @JsonProperty("family_ypos") int family_ypos,
                              @JsonProperty("work_xpos") int work_xpos, @JsonProperty("work_ypos") int work_ypos,
                              @JsonProperty("finance_xpos") int finance_xpos, @JsonProperty("finance_ypos") int finance_ypos,
                              @JsonProperty("event_xpos") int event_xpos, @JsonProperty("event_ypos") int event_ypos){
        this.patient_id = patient_id;
        this.pain_xpos = pain_xpos;
        this.pain_ypos = pain_ypos;
        this.family_xpos = family_xpos;
        this.family_ypos = family_ypos;
        this.work_xpos = work_xpos;
        this.work_ypos = work_ypos;
        this.finance_xpos = finance_xpos;
        this.finance_ypos = finance_ypos;
        this.event_xpos = event_xpos;
        this.event_ypos = event_ypos;
    }


    public int getPatient_id() {
        return patient_id;
    }

    public int getPain_xpos() {
        return pain_xpos;
    }

    public int getPain_ypos() {
        return pain_ypos;
    }

    public int getFamily_xpos() {
        return family_xpos;
    }

    public int getFamily_ypos() {
        return family_ypos;
    }

    public int getWork_xpos() {
        return work_xpos;
    }

    public int getWork_ypos() {
        return work_ypos;
    }

    public int getFinance_xpos() {
        return finance_xpos;
    }

    public int getFinance_ypos() {
        return finance_ypos;
    }

    public int getEvent_xpos() {
        return event_xpos;
    }

    public int getEvent_ypos() {
        return event_ypos;
    }
}
