package com.mygarden.mygarden.dao;

import com.mygarden.mygarden.model.Plant;

import java.util.List;
import java.util.UUID;

public interface DeviceDao {

    UUID registerDevice(UUID userID);

    List<Plant> getAllPlants(UUID systemID);
}
