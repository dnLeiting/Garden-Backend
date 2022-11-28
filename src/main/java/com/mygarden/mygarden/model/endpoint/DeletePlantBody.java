package com.mygarden.mygarden.model.endpoint;

import java.util.UUID;

public class DeletePlantBody {
    private UUID deviceID;
    private UUID plantID;

    public DeletePlantBody(UUID deviceID, UUID plantID) {
        this.deviceID = deviceID;
        this.plantID = plantID;
    }

    public UUID getDeviceID() {
        return deviceID;
    }

    public void setDeviceID(UUID deviceID) {
        this.deviceID = deviceID;
    }

    public UUID getPlantID() {
        return plantID;
    }

    public void setPlantID(UUID plantID) {
        this.plantID = plantID;
    }
}
