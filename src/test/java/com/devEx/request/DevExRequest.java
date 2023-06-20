package com.devEx.request;

import com.devEx.common.DataForApi;
import com.devEx.utilities.ConfigurationReader;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class DevExRequest {
   public static Response response;

    public static Response getAllProfiles(){
        response= given().accept(ContentType.JSON)
                .when().log().all()
                .get(ConfigurationReader.get("getAllProfiles"));
        return response;
    }

    public static Response getOneUserWithPathParam(int id){
       response =given().accept(ContentType.JSON)
                .pathParam("userID", id)
                .when()
                .get(ConfigurationReader.get("getOneUserWithPathParam"));
        return response;
    }
    public static Response registerNewUser(String email, String password, String name, String google, String facebook, String github){
        response=given().accept(ContentType.JSON)
                .and()
                .contentType(ContentType.JSON)
                .and()
                .body(DataForApi.registerUserBody(email, password, name, google, facebook, github))
                .when()
                .post(ConfigurationReader.get("postRegisterUser"));
        return response;
    }
}
