package com.mygarden.mygarden.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.mygarden.mygarden.dao.PlantDao;
import com.mygarden.mygarden.model.Plant;
import com.mygarden.mygarden.model.endpoint.DeletePlantBody;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class PlantService {
    private final PlantDao plantDao;

    public PlantService(@Qualifier("nvmPlant") PlantDao plantDao) {
        this.plantDao = plantDao;
    }

    public UUID postPlant(Plant plant, UUID d){
       return plantDao.createPlant(plant, d);
    }

    public boolean putPlant(Plant plant, UUID deviceID){
        return plantDao.updatePlant(plant, deviceID);
    }

    public Plant getPlant(UUID plantID){
        return plantDao.requestPlant(plantID);
    }

    public boolean deletePlant(DeletePlantBody deleteBody){
        return plantDao.removePlant(deleteBody);
    }
}
