
/*
 * Author: Hemant Choudhari
 * summary: Test Case 3 Reset Password
 * Date: 09/14/2019
 */

/******************************************************
Test Name: Reset password existing user
URI: http: https://api2.fox.com/v2.0/reset
Request Type: POST
Request Payload(Body):

{
	"email":"hemant10@fox.com",
	"password":"abcdef"
}

********* Validations **********
message  and detail Validation
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

public class TC003_RESET_password extends TestBase{

	RequestSpecification httpRequest;
	Response response;
	String email = "hemant14@fox.com";
	String message = "Reset Email Sent";
	String detail = "Please check your inbox";
		
	@BeforeClass
	void getEmployeeData() throws InterruptedException
	{
		logger.info("********* Started TC003_RESET_password **********");
		
		RestAssured.baseURI = "https://api2.fox.com/v2.0";
		httpRequest = RestAssured.given();
		
		// JSONObject is a class that represents a simple JSON. We can add Key-Value pairs using the put method
		JSONObject requestParams = new JSONObject();
		//add only email for reset password
		requestParams.put("email", email);
		
		// Add a header stating the Request body is a JSON
		httpRequest.header("Cache-Control", "no-cache");
		httpRequest.header("Content-Type", "application/json");
		httpRequest.header("Postman-Token", "748af4cc-40e6-4c03-a601-a604ac0ae966");
		httpRequest.header("x-api-key", "vHeTnXOe984VBvC0ud8lPpSbsxJ0c7kQ");

		// Add the Json to the body of the POST Reset request
		httpRequest.body(requestParams.toJSONString());		
		response = httpRequest.request(Method.POST, "/reset");
		Thread.sleep(7000);
		
		
	}
	
	//Test Case - message  and detail Validation
	@Test
	void checkResposeBody()
	{
		String responseBody = response.getBody().asString();
		System.out.println("Response body as string" + responseBody);
		Assert.assertEquals(responseBody.contains(message), true);
		Assert.assertEquals(responseBody.contains(detail), true);
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
		logger.info("*********  Finished TC003_RESET_password  **********");
	}
	
}
