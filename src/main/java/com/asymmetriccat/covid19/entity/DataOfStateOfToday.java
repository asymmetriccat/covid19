package com.asymmetriccat.covid19.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class DataOfStateOfToday {
    private String state;
    private int positive;
    private int positiveScore;
    private int negativeScore;
    private int negativeRegularScore;
    private int commercialScore;
    private String grade;
    private int score;
    private String notes;
    private String dataQualityGrade;
    private int negative;
    private int  pending;
    private int  hospitalizedCurrently;
    private int   hospitalizedCumulative;
    private int  inIcuCurrently;
    private int   inIcuCumulative;
    private int   onVentilatorCurrently;
    private int   onVentilatorCumulative;
    private int   recovered;
    private String  lastUpdateEt;
    private String  checkTimeEt;
    private int   death;
    private int  hospitalized;
    private int  total;
    private int  totalTestResults;
    private int  posNeg;
    private String  fips;
    private String  dateModified;
    private String  dateChecked;
    private String  hash;
}
