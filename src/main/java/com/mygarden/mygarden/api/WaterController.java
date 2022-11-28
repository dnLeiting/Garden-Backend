package com.mygarden.mygarden.api;

import com.mygarden.mygarden.model.Water;
import com.mygarden.mygarden.model.endpoint.DeletePlantBody;
import com.mygarden.mygarden.model.endpoint.WaterWrapper;
import com.mygarden.mygarden.service.WaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RequestMapping("api/v1/water")
@RestController
public class WaterController {

    private final WaterService waterService;

    @Autowired
    public WaterController(WaterService waterService) {
        this.waterService = waterService;
    }

    @GetMapping(path = "{deviceID}")
    public ResponseEntity getWater(@PathVariable("deviceID") @NonNull @Valid UUID plantID){
        List json = waterService.getWater(plantID);
        if(json==null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(json, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity putMoisture( @RequestBody @NonNull @Valid List<Water> waterList){
        boolean json = waterService.putMoisture(waterList);
        if(json==false){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

