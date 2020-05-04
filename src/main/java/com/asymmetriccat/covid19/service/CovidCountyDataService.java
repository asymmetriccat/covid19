package com.asymmetriccat.covid19.service;

import com.asymmetriccat.covid19.entity.CountyCovidData;
import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.HeaderColumnNameTranslateMappingStrategy;
import org.springframework.stereotype.Service;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CovidCountyDataService {

    public CountyCovidData getCountyCovidDataByDate(String county, String state, String date) throws IOException {  //date yyyy-mm-dd

        Map mapping = new HashMap();
        mapping.put("date", "date");
        mapping.put("county", "county");
        mapping.put("state", "state");
        mapping.put("fips", "fips");
        mapping.put("cases", "cases");
        mapping.put("deaths", "deaths");

        HeaderColumnNameTranslateMappingStrategy strategy =
                new HeaderColumnNameTranslateMappingStrategy();
        strategy.setType(CountyCovidData.class);
        strategy.setColumnMapping(mapping);

        URL stockURL = new URL("https://raw.githubusercontent.com/nytimes/covid-19-data/master/us-counties.csv");
        BufferedReader in = new BufferedReader(new InputStreamReader(stockURL.openStream()));
        CSVReader reader = new CSVReader(in);

    //    String csvFilename = "https://raw.githubusercontent.com/nytimes/covid-19-data/master/us-counties.csv";
     //   CSVReader csvReader = new CSVReader(new FileReader(csvFilename));
        CsvToBean csvToBean = new CsvToBean();
        csvToBean.setCsvReader(reader);
        csvToBean.setMappingStrategy(strategy);
        List <CountyCovidData> list = csvToBean.parse();
       return  list.stream()
                .filter(cd->cd.getCounty().equalsIgnoreCase(county))
                .filter(cd->cd.getState().equalsIgnoreCase(state))
                .filter(cd->cd.getDate().equalsIgnoreCase(date))
                .findFirst().orElse(null);

    }
}
