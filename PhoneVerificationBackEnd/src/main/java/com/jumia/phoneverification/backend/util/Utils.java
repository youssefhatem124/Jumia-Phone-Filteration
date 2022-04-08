package com.jumia.phoneverification.backend.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
@PropertySource(value = "classpath:countries-codes.properties")
public class Utils {

    @Value("#{${countriesMap}}")
    public HashMap<String, String> countriesMap;

    public String getCountryCodeBasedOnCountry(String country){
        String code =countriesMap.get(country);
        code = getCodeConcatenation(code);
        return code;
    }

    public String getCodeConcatenation(String code){
        String codeConcatenation = "("+code+")";
        return codeConcatenation;
    }

    public boolean validateNumber(String phoneNumber) {
        String patterns = "^(\\(237\\)\\ ?[2368]\\d{7,8}$)" + "|^(\\(251\\)\\ ?[1-59]\\d{8}$)"
                + "|^(\\(212\\)\\ ?[5-9]\\d{8}$)" + "|^(\\(258\\)\\ ?[28]\\d{7,8}$)" + "|^(\\(256\\)\\ ?\\d{9}$)";
        Pattern pattern = Pattern.compile(patterns);
        Matcher matcher = pattern.matcher(phoneNumber);
        return matcher.find();
    }


}
