package com.mygarden.mygarden.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import java.util.UUID;


@Embeddable
public class Device {
    @JsonProperty("id")
    private final UUID id;

    public Device(UUID id) {
        this.id = id;
    }
    public UUID getId() {return id;}
}
