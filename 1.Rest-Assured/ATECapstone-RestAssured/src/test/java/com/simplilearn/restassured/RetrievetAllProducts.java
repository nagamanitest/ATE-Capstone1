package com.simplilearn.restassured;

import static org.hamcrest.CoreMatchers.equalTo;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class RetrievetAllProducts {

	private static final String BASE_URL = "http://localhost:9010";
	private static final Logger logger = Logger.getLogger(RetrievetAllProducts.class);
	String response=null;
	
	@Test(description= "Test to Get all product from the store")
	public void testGetAllProducts() {
		try {
			logger.info("Start :: Test to Get all products from the store");
			RestAssured.given().baseUri(BASE_URL)
			.when().get("/get-shoes").then().statusCode(200).and()
			.body("message", equalTo("13 Shoes Fetched Successfully."));
			
		
			response = RestAssured.given().baseUri(BASE_URL)
			.when().get("/get-shoes").getBody().asString();
		}catch (Exception e) {
			logger.error("Exception object :: " +e.toString());
			logger.error("End Exception :: " +e.getLocalizedMessage());
		}
		logger.info("Response ::" +response);
		logger.info("End  :: Test to Get all products from the store");
	}
}

