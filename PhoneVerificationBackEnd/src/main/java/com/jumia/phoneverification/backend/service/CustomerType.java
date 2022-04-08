package com.jumia.phoneverification.backend.service;

import com.jumia.phoneverification.backend.model.enums.Strategies;
import org.springframework.stereotype.Component;
import javax.annotation.Resource;
import java.util.Map;

@Component
public class CustomerType {

    @Resource(name = "populateStrategies")
    public Map<Enum, CustomerSearch> strategiesMap;

    public CustomerSearch getCustomerType(Boolean state, String country) {
        if (state != null && country != null) {
            return strategiesMap.get(Strategies.COUNTRYANDSTATE);
        } else if (state != null) {
            return strategiesMap.get(Strategies.STATE);
        } else if (country != null) {
            return strategiesMap.get(Strategies.COUNTRY);
        } else {
            return strategiesMap.get(Strategies.ALL);
        }


    }
}

