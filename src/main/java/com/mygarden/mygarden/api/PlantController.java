package com.mygarden.mygarden.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.mygarden.mygarden.dao.PlantDao;
import com.mygarden.mygarden.model.Plant;
import com.mygarden.mygarden.model.endpoint.DeletePlantBody;
import com.mygarden.mygarden.service.PlantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@RequestMapping("api/v1/plant")
@RestController
public class PlantController {
    private final PlantService plantService;

    @Autowired
    public PlantController(PlantService plantService) {
        this.plantService = plantService;
    }

    @PostMapping(path = "{deviceID}")
    public ResponseEntity postPlant(@Valid @NonNull @RequestBody Plant plant, @PathVariable("deviceID") UUID deviceID){
        UUID json = plantService.postPlant(plant, deviceID);
        if(json==null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(json,HttpStatus.OK);
    }

    @PutMapping(path = "{deviceID}")
    public ResponseEntity putPlant(@RequestBody @NonNull @Valid Plant plant, @PathVariable("deviceID") UUID deviceID){
        boolean json = plantService.putPlant(plant, deviceID);
        if(json==false){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

   @DeleteMapping
    public ResponseEntity deletePlant(@RequestBody @NonNull @Valid DeletePlantBody deleteBody){
       boolean json = plantService.deletePlant(deleteBody);
       if(json==false){
           return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
       }
       return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(path = "{plantID}")
    public ResponseEntity putPlant(@PathVariable("plantID") UUID plantID){
        Plant json = plantService.getPlant(plantID);
        if(json==null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(json, HttpStatus.OK);
    }
}

