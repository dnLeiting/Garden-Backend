package com.mygarden.mygarden.dao;

import com.mygarden.mygarden.dao.DeviceDao;
import com.mygarden.mygarden.model.Device;
import com.mygarden.mygarden.model.Plant;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static com.mygarden.mygarden.dao.nvmPlantDataAccessService.plantDB;

@Repository("nvmDevice")
public class nvmDeviceDataAccessService implements DeviceDao {
    public static List<Device> deviceDB = new ArrayList<>();

    @Override
    public UUID registerDevice(UUID userID){
        if(userID.equals(UUID.fromString("9AA21E15-1C5E-4DA3-A073-EB9C2C34B70A"))){
            deviceDB.add(new Device(UUID.randomUUID()));
            return  deviceDB.get(deviceDB.size() - 1).getId();
        }
        return null;
    }

    @Override
    public List<Plant> getAllPlants(UUID systemID){
        if(systemID.equals(UUID.fromString("10A21E15-1C5E-4DA3-A073-EB9C2C34B70E"))){
            return  plantDB;
        }
        return null;
    }
}
