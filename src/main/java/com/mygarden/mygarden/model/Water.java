package com.mygarden.mygarden.model;

import java.util.UUID;

public class Water {
    private int moisture;
    private UUID plantID;

    public Water(int moisture, UUID plantID) {
        this.moisture = moisture;
        this.plantID = plantID;
    }

    public UUID getPlantID() {
        return plantID;
    }

    public void setPlantID(UUID deviceID) {
        this.plantID = deviceID;
    }

    public int getMoisture() {
        return moisture;
    }

    public void setMoisture(int moisture) {
        this.moisture = moisture;
    }
}
