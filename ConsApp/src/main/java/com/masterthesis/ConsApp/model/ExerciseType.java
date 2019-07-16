package com.masterthesis.ConsApp.model;

import com.fasterxml.jackson.annotation.JsonProperty;


public class ExerciseType {
    private final String title;
    private final String explanation;


    public ExerciseType(@JsonProperty("title") String title, @JsonProperty("explanation") String explanation) {
        this.title = title;
        this.explanation = explanation;
    }

    public String getTitle() {
        return title;
    }

    public String getExplanation() {
        return explanation;
    }
}
