
/*
 * Author: Hemant Choudhari
 * summary: Test Case 2 Login user
 * Date: 09/14/2019
 */

/******************************************************
Test Name: Login Using existing user
URI: http:  https://api2.fox.com/v2.0/login
Request Type: POST
Request Payload(Body):

{
	"email":"hemant10@fox.com",
	"password":"abcdef"
}

********* Validations **********
isVerified : true
Status Code : 200
Response Time Validation
Status Line : HTTP/1.1 200 OK
Content Type : application/json

*********************************************************/



package com.foxapi.testCases;
import org.json.simple.JSONObject;

import org.testng.Assert;
import org.testng.annotations.*;

import com.foxapi.base.TestBase;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC002_LOGIN_user extends TestBase{

	RequestSpecification httpRequest;
	Response response;
	String email = "hemant12@fox.com";
	String password = "abcdef";
		
	@BeforeClass
	void getEmployeeData() throws InterruptedException
	{
		logger.info("********* Started TC002_LOGIN_user **********");
		
		RestAssured.baseURI = "https://api2.fox.com/v2.0";
		httpRequest = RestAssured.given();
		
		// JSONObject is a class that represents a simple JSON. We can add Key-Value pairs using the put method
		JSONObject requestParams = new JSONObject();
		requestParams.put("email", email); // Cast
		requestParams.put("password", password);
		
		// Add a header stating the Request body is a JSON
		httpRequest.header("Content-Type", "application/json");
		httpRequest.header("Cache-Control", "no-cache");
		httpRequest.header("Postman-Token", "dd063a04-d4fa-4ed4-aa6f-363a887f94e3");
		httpRequest.header("x-api-key", "c7d8fa9220f040358f64e472e850458e");

		// Add the Json to the body of the POST LOGIN request
		httpRequest.body(requestParams.toJSONString());		
		response = httpRequest.request(Method.POST, "/login");
		Thread.sleep(7000);
		
		
	}
	
	//Test Case - isVerified Validation
	@Test
	void checkResposeBody()
	{
		String responseBody = response.getBody().asString();
		Assert.assertEquals(responseBody.contains("isVerified"), true);
	}
		
	//Test Case - Status code validation
	@Test
	void checkStatusCode()
	{
		int statusCode = response.getStatusCode(); 
		Assert.assertEquals(statusCode, 200);
	}
	
	//Test Case - Response Time check
	@Test
	void checkResponseTime()
	{
		long responseTime = response.getTime(); 
		Assert.assertTrue(responseTime<7000);
		
	}
		
	//Test Case - Check status Line
	@Test
	void checkstatusLine()
	{
		String statusLine = response.getStatusLine(); 
		Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");
		
	}
	
	//Test Case - Check Content-Type
	@Test
	void checkContentType()
	{
		String contentType = response.header("Content-Type");
		Assert.assertEquals(contentType, "application/json");
	}

	
	@AfterClass
	void tearDown()
	{
		logger.info("*********  Finished TC002_LOGIN_user  **********");
	}
	
}
