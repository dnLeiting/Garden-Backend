package com.mygarden.mygarden.dao;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.mygarden.mygarden.model.Plant;
import com.mygarden.mygarden.model.endpoint.DeletePlantBody;

import java.util.UUID;

public interface PlantDao {
    UUID createPlant(Plant plant, UUID deviceID);

    boolean updatePlant(Plant plant, UUID deviceID);

    boolean removePlant(DeletePlantBody deleteBody);

    Plant requestPlant(UUID plantID);

}
