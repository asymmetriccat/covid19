package com.asymmetriccat.covid19.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CountyCovidData {
    private String date,county,state,fips,cases,deaths;
}
