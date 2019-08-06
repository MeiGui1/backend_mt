package com.masterthesis.ConsApp.model;

import com.fasterxml.jackson.annotation.JsonProperty;


public class WebsiteType {
    private final int id;
    private final String name;
    private final String url;
    private final String description;


    public WebsiteType(@JsonProperty("id") int id, @JsonProperty("name") String name, @JsonProperty("url") String url, @JsonProperty("description") String description) {
        this.id = id;
        this.url = url;
        this.name = name;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public String getUrl() {
        return url;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
