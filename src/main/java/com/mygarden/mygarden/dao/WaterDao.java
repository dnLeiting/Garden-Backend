package com.mygarden.mygarden.dao;

import com.mygarden.mygarden.model.Water;
import com.mygarden.mygarden.model.endpoint.DeletePlantBody;
import com.mygarden.mygarden.model.endpoint.WaterWrapper;

import java.util.List;
import java.util.UUID;

public interface WaterDao {

    List getMoisture(UUID plantID);

    boolean updateMoisture(List<Water> waterList);

}
