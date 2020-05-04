package com.asymmetriccat.covid19.controller;

import com.asymmetriccat.covid19.entity.CountyCovidData;
import com.asymmetriccat.covid19.entity.DailyHistoricDataOfStates;
import com.asymmetriccat.covid19.service.CovidCountyDataService;
import com.asymmetriccat.covid19.service.CovidDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;

@RestController(value = "/v0")
public class CovidDataController {

    @Autowired
    CovidDataService covidDataService;
    @Autowired
    CovidCountyDataService covidCountyDataService;

    @GetMapping(value = "/historicData/{state}/{date}", produces = MediaType.APPLICATION_JSON_VALUE)
    public DailyHistoricDataOfStates getDailyHistoricDataOfState(@PathVariable String state, @PathVariable String date) throws URISyntaxException {
           long lDate = Long.parseLong(date);
           return covidDataService.getDailyHistoricDataOfState(state, lDate);
    }

    @GetMapping(value = "/covid/{county}/{state}/{date}",produces = MediaType.APPLICATION_JSON_VALUE )
    public CountyCovidData getCountyCovidDataByDate(@PathVariable String county, @PathVariable String state,@PathVariable String date) throws IOException {
        return covidCountyDataService.getCountyCovidDataByDate( county,  state,  date);
    }
}
