package com.asymmetriccat.covid19.service;

import com.asymmetriccat.covid19.entity.DailyHistoricDataOfStates;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

@Service
public class CovidDataService {
    @Autowired
    private RestTemplate restTemplate;

    public DailyHistoricDataOfStates getDailyHistoricDataOfState(String state, long date) throws URISyntaxException {   // date should be in formate: yyyymmdd; state should be in uppercase like "FL"
        final String uri = "https://covidtracking.com/api/v1/states/daily.json";
        HttpEntity<?> httpEntity = new HttpEntity<>(null, new HttpHeaders());

        ResponseEntity<DailyHistoricDataOfStates[]> resp = restTemplate.exchange(
                new URI(uri), HttpMethod.GET,
                httpEntity, DailyHistoricDataOfStates[].class);

        DailyHistoricDataOfStates[] dailyDataList = resp.getBody();
        return Arrays.stream(dailyDataList).filter(ds->ds.getDate()==date).filter(ds->ds.getState().equalsIgnoreCase(state)).findFirst().orElse(null);
    }

}
