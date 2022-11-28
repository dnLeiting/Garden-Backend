package com.mygarden.mygarden.model.endpoint;

import com.mygarden.mygarden.model.Water;

import javax.persistence.Embedded;
import java.util.List;

public class WaterWrapper {
    @Embedded
    private List<Water> waterList;

    public WaterWrapper(List<Water> waterList) {
        this.waterList = waterList;
    }

    public List<Water> getWaterList() {
        return waterList;
    }

    public void setWaterList(List<Water> waterList) {
        this.waterList = waterList;
    }
}
