package com.mygarden.mygarden.service;

import com.mygarden.mygarden.dao.WaterDao;
import com.mygarden.mygarden.model.Water;
import com.mygarden.mygarden.model.endpoint.DeletePlantBody;
import com.mygarden.mygarden.model.endpoint.WaterWrapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class WaterService {
    private final WaterDao waterDao;

    public WaterService(@Qualifier("nvmWater") WaterDao waterDao) {
        this.waterDao = waterDao;
    }

    public List getWater(UUID plantID){
        return waterDao.getMoisture(plantID);
    };

    public boolean putMoisture(List<Water> waterList){
        return waterDao.updateMoisture(waterList);
    }
}
