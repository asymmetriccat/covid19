package com.asymmetriccat.covid19.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class DailyHistoricDataOfStates {
    private Long date;
    private String state;
    private int positive;
    private int negative;
    private int pending;
    private int  hospitalizedCurrently;
    private int hospitalizedCumulative;
    private int  inIcuCurrently;
    private int  inIcuCumulative;
    private int  onVentilatorCurrently;
    private int   onVentilatorCumulative;
    private int   recovered;
    private String   hash;
    private String   dateChecked;
    private int    death;
    private int  hospitalized;
    private int  total;
    private int  totalTestResults;
    private int   posNeg;
          private String  fips;
    private int   deathIncrease;
    private int  hospitalizedIncrease;
    private int  negativeIncrease;
    private int   positiveIncrease;
    private int   totalTestResultsIncrease;
}
