package com.simplilearn.restassured;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;
import static org.hamcrest.CoreMatchers.equalTo;
import io.restassured.RestAssured;

public class DeleteProduct {
	
	private static final String BASE_URL = "ttp://localhost:9010";
	private static final Logger logger = Logger.getLogger(DeleteProduct.class);
	String response=null;
	
	@Test(description= "Test to delete product from the store")
	public void testDeleteProduct() {
		try {
			logger.info("Start :: Test to delete the product from the store");
			int id = 101;
			RestAssured.given().baseUri(BASE_URL)
			.when().delete("/delete-shoe?id="+id).then().statusCode(200).and()
			.body("message", equalTo("Shoe with ID 101 Deleted Successfully."));
			
		
			response = RestAssured.given().baseUri(BASE_URL)
			.when().delete("/delete-shoe?id="+id).getBody().asString();
		}catch (Exception e) {
			logger.error("Exception object :: " +e.toString());
			logger.error("End Exception :: " +e.getLocalizedMessage());
		}
		logger.info("Response ::" +response);
		logger.info("End  :: Test to delete product from the store");
	}

}
