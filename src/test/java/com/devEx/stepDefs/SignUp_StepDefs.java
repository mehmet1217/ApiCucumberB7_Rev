package com.devEx.stepDefs;

import com.devEx.request.DevExRequest;
import com.devEx.utilities.ConfigurationReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import static com.devEx.request.DevExRequest.response;
import static org.junit.Assert.assertTrue;

public class SignUp_StepDefs {

    String token;
    @Given("The user sends a POST request  with {string} and {string} and {string} and {string} and {string} and {string}")
    public void the_user_sends_a_post_request_with_and_and_and_and_and(String email, String password, String name,
                                                                       String google, String facebook, String github) {
        response= DevExRequest.registerNewUser(email, password, name, google, facebook, github);
        response.prettyPrint();
    }
    @Then("Verify that body contains {string}")
    public void verify_that_body_contains(String token) {
        assertTrue(response.body().asString().contains(token));
    }

    @And("Compiler gets the token")
    public void compilerGetsTheToken() {
       token  =response.path("token");
        ConfigurationReader.set("newUserToken",token);
    }
}
