/*
 * Author: Hemant Choudhari
 * summary: Test Case 1 Register User
 * Date: 09/14/2019
 */

/******************************************************
Test Register new record in database 
URI:   https://api2.fox.com/v2.0/register 
Request Type: POST
Request Payload(Body): 
{
"email":"hemant17@fox.com", //Please update this email id when you run each time
"password":"aaaaaa",
"gender": "M",
"firstName": "Hemant",
"lastName": "Test"
}

********* Validations **********
Response Payload(Body) : 
{
"email":"hemantc091@fox.com",
"password":"aaaaaa",
"gender": "M",
"firstName": "Hemant",
"lastName": "Test"
}

Status Code : 200
Status Line : HTTP/1.1 200 OK
Content Type : application/json
Content Encoding : gzip

**********************************************************/

package com.foxapi.testCases;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.*;
import com.foxapi.base.TestBase;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC001_REG_user extends TestBase{

	RequestSpecification httpRequest;
	Response response;
	
	String email = "hemant18@fox.com";
	String password = "abcdef";
	String gender = "M";
	String firstName = "Hemanta";
	String lastName = "Testa";
			

	@BeforeClass
	void createEmployee() throws InterruptedException
	{
		logger.info("********* Started TC001_REG_user  **********");
		
		RestAssured.baseURI = "https://api2.fox.com/v2.0";
		httpRequest = RestAssured.given();

		// JSONObject is a class that represents a simple JSON. We can add Key-Value pairs using the put method
		
		JSONObject requestParams = new JSONObject();
		requestParams.put("email", email); // Cast
		requestParams.put("password", password);
		requestParams.put("gender", gender);
		requestParams.put("firstName", firstName);
		requestParams.put("lastName", lastName);
		
		// Add a header stating the Request body is a JSON
		httpRequest.header("Content-Type", "application/json");
		httpRequest.header("Cache-Control", "no-cache");
		httpRequest.header("Postman-Token", "a74249b3-97f1-45c0-999c-66d7841bed8a");
		httpRequest.header("x-api-key", "62d64c84d8a1242ed4483cad7d316be0");

		// Add the Json to the body of the request
		httpRequest.body(requestParams.toJSONString());

		response = httpRequest.request(Method.POST, "/register");
		
		Thread.sleep(5000);

	}
	
	@Test
	void checkResposeBody()
	{
		String responseBody = response.getBody().asString();
		System.out.println("responseBody is :" + responseBody);
		Assert.assertEquals(responseBody.contains(email), true);
		Assert.assertEquals(responseBody.contains(gender), true);
		Assert.assertEquals(responseBody.contains(firstName), true);
		Assert.assertEquals(responseBody.contains(lastName), true);
	}
		
	@Test
	void checkStatusCode()
	{
		int statusCode = response.getStatusCode(); // Gettng status code
		Assert.assertEquals(statusCode, 200);
	}
		
	@Test
	void checkstatusLine()
	{
		String statusLine = response.getStatusLine(); // get the  status Line
		Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");
		
	}
	
	@Test
	void checkContentType()
	{
		String contentType = response.header("Content-Type");
		Assert.assertEquals(contentType, "application/json");
	}

	@Test
	void checkcontentEncoding()
	{
		String contentEncoding = response.header("Content-Encoding");
		Assert.assertEquals(contentEncoding, "gzip");

	}
	
	@AfterClass
	void tearDown()
	{
		logger.info("*********  Finished C001_REG_user **********");
	}

}
