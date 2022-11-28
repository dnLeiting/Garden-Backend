package com.mygarden.mygarden.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mygarden.mygarden.model.Plant;
import com.mygarden.mygarden.service.DeviceService;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;
import org.json.JSONObject;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RequestMapping("api/v1/device")
@RestController
public class DeviceController {
    private final DeviceService deviceService;

    @Autowired //?
    public DeviceController(DeviceService deviceService){
        this.deviceService = deviceService;
    }

    @PostMapping(path = "{userID}")
    public ResponseEntity  postDevice(@PathVariable("userID") UUID userID) {
        UUID json = deviceService.postDevice(userID);
        if(json==null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(json,HttpStatus.OK);
    }


    @GetMapping(path = "{systemID}")
    public ResponseEntity  getSystem(@PathVariable("systemID") UUID systemID) {
        List<Plant> json = deviceService.getPlants(systemID);
        if(json==null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(json,HttpStatus.OK);
    }

}
