

import io.restassured.RestAssured;

import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;

import static io.restassured.RestAssured.*;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class WebServices {

    File file = new File("src/main/resources/rq.js");

    @BeforeTest
    public static void setup(){
        RestAssured.baseURI = "https://petstore.swagger.io/";
    }

    @Test
    public void getPet(){
        when().get("v2/pet/1").then().assertThat().statusCode(200);
        get("/v2/pet/1").then().assertThat().body(matchesJsonSchemaInClasspath("rs.json"));
    }

    @Test
    public void postPet(){
        given().header("Content-type", "application/json").body(file).post("v2/pet").then().assertThat().statusCode(200).and().assertThat().body(matchesJsonSchemaInClasspath("rs.json"));
    }

    @Test
    public void putPet(){
        given().header("Content-type","application/json").body(file).put("v2/pet").then().assertThat().statusCode(200).and().assertThat().body(matchesJsonSchemaInClasspath("rs.json"));
    }

}
