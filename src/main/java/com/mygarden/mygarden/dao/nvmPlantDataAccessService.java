package com.mygarden.mygarden.dao;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mygarden.mygarden.model.Device;
import com.mygarden.mygarden.model.Plant;
import com.mygarden.mygarden.model.endpoint.DeletePlantBody;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import static com.mygarden.mygarden.dao.nvmDeviceDataAccessService.deviceDB;

@Repository("nvmPlant")
public class nvmPlantDataAccessService implements PlantDao {
    public static List<Plant> plantDB = new ArrayList<>();

    @Override
    public UUID createPlant(Plant plant, UUID deviceID){
        boolean a = deviceDB.stream()
                .anyMatch(device -> device.getId().equals(deviceID));
        if(a==true){
            Plant newPlant = new Plant(UUID.randomUUID(), plant.getPlantName(), plant.getPlantType(), plant.getWateringHour(), plant.getWateringAmount(), new Device(deviceID));
            plantDB.add(newPlant);
            return newPlant.getPlantId();
        }
        return null;
    }

    @Override
    public boolean updatePlant(Plant plant, UUID deviceID) {

        plantDB.stream()
                .filter(item -> item.getPlantId().equals(plant.getPlantId()) && item.getDevice().getId().equals(deviceID))
                .forEach(item -> {
                    if(plant.getPlantName()!= null) {
                        item.setPlantName(plant.getPlantName());
                    }
                    if(plant.getPlantType()!= null) {
                        item.setPlantType(plant.getPlantType());
                    }
                    if(plant.getWateringAmount()!= 0) {
                        item.setWateringAmount(plant.getWateringAmount());
                    }
                    if(plant.getWateringHour() != 0) {
                        item.setWateringAmount(plant.getWateringHour());
                    }
                });

        return true;

    }

    @Override
    public boolean removePlant(DeletePlantBody deleteBody){
        plantDB.removeIf(x -> (x.getDevice().getId().equals(deleteBody.getDeviceID()) && x.getPlantId().equals(deleteBody.getPlantID())));
        return true;
    }

    @Override
    public Plant requestPlant(UUID plantID){

        List<Plant> resultPlantList = plantDB.stream()
                .filter(plant1 -> plant1.getPlantId().equals(plantID))
                .collect(Collectors.toList());
        if (resultPlantList.size() != 1) {
            throw new IllegalStateException();
        }
        Plant resultPlant = resultPlantList.get(0);
        return resultPlant;
    }
}
