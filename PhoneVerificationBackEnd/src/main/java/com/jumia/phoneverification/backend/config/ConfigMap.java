package com.jumia.phoneverification.backend.config;

import com.jumia.phoneverification.backend.model.enums.Strategies;
import com.jumia.phoneverification.backend.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class ConfigMap {

    private Map<Enum, CustomerSearch> strategies;

    @Autowired
    CustomerSearchAll customerSearchAll ;
    @Autowired
    CustomerSearchByCountry CustomerSearchByCountry;
    @Autowired
    CustomerSearchByState customerSearchByState;
    @Autowired
    CustomerSearchByStateAndCountry customerSearchByStateAndCountry;


    @Bean(name = "populateStrategies")
    public Map<Enum, CustomerSearch> populateStrategies(){
        strategies = new HashMap<>();
        strategies.put(Strategies.ALL,  customerSearchAll);
        strategies.put(Strategies.COUNTRY, CustomerSearchByCountry);
        strategies.put(Strategies.STATE, customerSearchByState);
        strategies.put(Strategies.COUNTRYANDSTATE, customerSearchByStateAndCountry);
        return strategies;
    }
}
