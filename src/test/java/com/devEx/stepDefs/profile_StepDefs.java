package com.devEx.stepDefs;

import com.devEx.request.DevExRequest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import static com.devEx.request.DevExRequest.response;
import static org.junit.Assert.assertEquals;

public class profile_StepDefs {


    @Given("The user sends a GET request and able to see all profiles")
    public void the_user_sends_a_get_request_and_able_to_see_all_profiles() {
//      response= given().accept(ContentType.JSON)
//                .when()
//                .get(ConfigurationReader.get("getAllProfiles"));
//        response.prettyPrint();
       response= DevExRequest.getAllProfiles();

    }
    @Then("Verify that status code is {int}")
    public void verify_that_status_code_is(int expectedStatusCode) {
        assertEquals(expectedStatusCode,response.statusCode());

    }
    @Given("The user sends GET request with id {int}")
    public void the_user_sends_get_request_with_id(int userID) {
        response= DevExRequest.getOneUserWithPathParam(userID);
        response.prettyPrint();
    }
    @Then("Verify that user's info name is {string} and company is {string} and location is {string}")
    public void verify_that_user_s_info_name_is_and_company_is_and_location_is(String expectedName,
                                                                               String expectedCompany, String expectedLocation) {
        String actualName=response.path("user.name");
        String actualCompany=response.path("company");
        String actualLocation=response.path("location");
        assertEquals(expectedName,actualName);
        assertEquals(expectedCompany,actualCompany);
        assertEquals(expectedLocation,actualLocation);
    }
}
