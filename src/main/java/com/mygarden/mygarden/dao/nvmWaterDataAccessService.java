package com.mygarden.mygarden.dao;

import com.mygarden.mygarden.model.Plant;
import com.mygarden.mygarden.model.Water;
import com.mygarden.mygarden.model.endpoint.WaterWrapper;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Repository("nvmWater")
public class nvmWaterDataAccessService implements WaterDao{

    public static List<Water> waterDB = new ArrayList<>();

    @Override
    public List getMoisture(UUID plantID) {
        List<Water> relevantPlants = waterDB.stream()
                .filter(water -> water.getPlantID().equals(plantID))
                .collect(Collectors.toList());
        return relevantPlants;
    }

    @Override
    public boolean updateMoisture(List<Water> waterList) {
        for(Water water : waterList){
            waterDB.add(water);
        }
        return true;
    }
}
