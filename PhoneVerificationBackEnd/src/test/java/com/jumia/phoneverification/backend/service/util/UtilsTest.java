package com.jumia.phoneverification.backend.service.util;

import com.jumia.phoneverification.backend.util.Utils;
import org.junit.jupiter.api.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.HashMap;
import static org.junit.Assert.assertEquals;


@SpringBootTest
public class UtilsTest {

    @InjectMocks
    private Utils utils;

    @Mock
    @Value("#{${countriesMap}}")
    public HashMap<String, String> countriesMap;

    @BeforeEach
    @DisplayName("Inject Mocks Before EveryMethod")
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    @DisplayName("get Country Code")
    public void getCountryCodeBasedOnCountryTest() {

        Mockito.when(countriesMap.get("Cameroon")).thenReturn("237");

        String code = utils.getCountryCodeBasedOnCountry("Cameroon");

        Assertions.assertEquals("(237)", code, "Should Map To The Correct Code");

    }

    @Test
    @DisplayName("get Code Concatenation")
    public void getCodeConcatenationTest() {

        String code = utils.getCodeConcatenation("237");

        Assertions.assertEquals("(237)", code, "Should Concatenate correctly");

    }


    @Test
    @DisplayName("Phone Numbers Matcher Test")
    public void validateNumberTest() {

         boolean check = true;

         String[] validPhoneNumbers  = {"(212) 6007989253","(258) 84330678235",
                "(212) 633963130","(237) 699209115","(237) 6622284920","(237) 677046616"};

         for ( String phoneNumber : validPhoneNumbers ) {
             check = utils.validateNumber(phoneNumber);
             if(check == false){
                 assertEquals("Un Valid Number Passed The Validation", false ,check);
             }
             else{
                assertEquals("A Valid Number DidNot Pass The Validation", true, check);
             }

        }
    }


}

