package com.reqres.tests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.hamcrest.Matchers.equalTo;

public class CreateUserTests {

    // simple test to create a user and validate json response fields directly
    @Test
    public void testCreateUser() {
        // defining base urI from api
        RestAssured.baseURI = "https://reqres.in/api/";

        // creating a user with post request
        Response response = RestAssured.given()
                .contentType(ContentType.JSON)
                .body("{ \"name\": \"Lucas\", \"job\": \"QA\" }") // requisition body
                .post("users");

        // validating code status
        response.then().statusCode(201); // 201 indicates resource was created

        // validating response body
        response.then().body("name", equalTo("Lucas")); //verify if the returned name is "Lucas"
        response.then().body("job", equalTo("QA")); // verify if returned profession is "QA"
    }

    //  validating fields and status code
    @Test
    public void testCreateUserValidateFields() {
        // defining base urI from api
        RestAssured.baseURI = "https://reqres.in/api/";

        // send post requisition to create a user
        Response response = RestAssured.given()
                .contentType(ContentType.JSON)
                .body("{ \"name\": \"Lucas\", \"job\": \"QA\" }") // requisition body
                .post("users");

        // validating status code (201 created)
        response.then().statusCode(201);

        // validating obligatory fields in response (name and job)
        response.then().body("name", equalTo("Lucas"));
        response.then().body("job", equalTo("QA"));
    }

    // pojo class to map api response
    // static to avoid instantiation errors
    public static class UserResponse {
        private String name;
        private String job;
        private String id;
        private String createdAt;

        // getters and setters
        public String getName() { return name; }
        public void setName(String name) { this.name = name; }

        public String getJob() { return job; }
        public void setJob(String job) { this.job = job; }

        public String getId() { return id; }
        public void setId(String id) { this.id = id; }

        public String getCreatedAt() { return createdAt; }
        public void setCreatedAt(String createdAt) { this.createdAt = createdAt; }
    }

    // test with pojo to extract and validate response
    @Test
    public void testCreateUserWithPOJO() {
        // defining base urI from api
        RestAssured.baseURI = "https://reqres.in/api/";

        // sending post request to create a user
        UserResponse user = RestAssured.given()
                .contentType(ContentType.JSON)
                .body("{ \"name\": \"Lucas\", \"job\": \"QA\" }") // requisition body
                .post("users")
                .then()
                .statusCode(201)  // status code validation
                .extract().as(UserResponse.class); // extract response to a UserResponse object

        // validate pojo fields
        assertEquals("Lucas", user.getName());
        assertEquals("QA", user.getJob());
        assertNotNull(user.getId());  // the field id must not be null
        assertNotNull(user.getCreatedAt());
    }
}
