package com.asymmetriccat.covid19.controller;

import com.asymmetriccat.covid19.entity.DailyHistoricDataOfStates;
import com.asymmetriccat.covid19.service.CovidDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.net.URISyntaxException;

@RestController
public class CovidDataController {

    @Autowired
    CovidDataService covidDataService;

    @GetMapping(value = "/historicData/{state}/{date}", produces = MediaType.APPLICATION_JSON_VALUE)
    public DailyHistoricDataOfStates getDailyHistoricDataOfState(@PathVariable String state, @PathVariable String date) throws URISyntaxException {
           long lDate = Long.parseLong(date);
           return covidDataService.getDailyHistoricDataOfState(state, lDate);
    }
}
