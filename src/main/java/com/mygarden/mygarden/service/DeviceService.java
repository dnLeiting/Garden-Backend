package com.mygarden.mygarden.service;

import com.mygarden.mygarden.dao.DeviceDao;
import com.mygarden.mygarden.model.Plant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class DeviceService {

    private final DeviceDao deviceDao;

    @Autowired
    public DeviceService(@Qualifier("nvmDevice") DeviceDao deviceDao) {
        this.deviceDao = deviceDao;
    }

    public UUID postDevice(UUID userID) {
        return deviceDao.registerDevice(userID);
    };

    public List<Plant> getPlants(UUID systemID) {
        return deviceDao.getAllPlants(systemID);
    };



}
