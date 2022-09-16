package com.adolfo.microcloud.newlimitsservice.controller;

import com.adolfo.microcloud.newlimitsservice.configuration.LimitsConfiguration;
import com.adolfo.microcloud.newlimitsservice.entity.Limits;
import com.adolfo.microcloud.newlimitsservice.service.LimitsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class LimitsController {

    @Autowired
    private LimitsService limitsService;
    @Autowired
    private LimitsConfiguration limitsConfiguration;


    /*@GetMapping("/limits")
    public ResponseEntity<List<Limits>> getAllLimits(){
        return new ResponseEntity<>(limitsService.getAll(), HttpStatus.OK);
    }*/

    @GetMapping("/limits")
    public List<Limits> getAllLimits(){
        List<Limits> resultLimitsList = new ArrayList<Limits>();
        resultLimitsList.add(new Limits(limitsConfiguration.getMinimum(),limitsConfiguration.getMaximum()));
        return resultLimitsList;
    }
}
