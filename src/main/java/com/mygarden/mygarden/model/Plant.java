package com.mygarden.mygarden.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Embedded;
import java.util.UUID;

public class Plant {
    private UUID plantId;
    private String plantName;
    private String plantType;
    private int wateringHour;
    private int wateringAmount;
    @Embedded
    @JsonProperty("device")
    private Device device;


    public Plant(UUID plantId, String plantName, String plantType, int wateringHour, int wateringAmount, Device device) {
        this.plantId = plantId;
        this.plantName = plantName;
        this.plantType = plantType;
        this.wateringHour = wateringHour;
        this.wateringAmount = wateringAmount;
        this.device = device;
    }

    public String getPlantType() {
        return plantType;
    }

    public void setPlantType(String plantType) {
        this.plantType = plantType;
    }

    public int getWateringHour() {
        return wateringHour;
    }

    public void setWateringHour(int wateringHour) {
        this.wateringHour = wateringHour;
    }

    public int getWateringAmount() {
        return wateringAmount;
    }

    public void setWateringAmount(int wateringAmount) {
        this.wateringAmount = wateringAmount;
    }

    public String getPlantName() {
        return plantName;
    }

    public void setPlantName(String plantName) {
        this.plantName = plantName;
    }

    public UUID getPlantId() {
        return plantId;
    }

    public void setPlantId(UUID plantId) {
        this.plantId = plantId;
    }

    public Device getDevice() {
        return device;
    }

    public void setDevice(Device device) {
        this.device = device;
    }
}