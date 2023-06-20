package com.devEx.stepDefs;

import com.devEx.utilities.ConfigurationReader;
import io.cucumber.java.After;
import io.cucumber.java.Before;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.reset;

public class Hooks {

    @Before
    public void setUp(){
        baseURI= ConfigurationReader.get("baseURL");
    }

    @After
    public void tearDown() throws Exception {
        reset();
    }
}
