package techproedenglish01.techproedenglish01api;

import static io.restassured.RestAssured.given;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import io.restassured.response.Response;

public class PostRequest01 extends TestBase{
	
	/*
	 To create Post Request in API, you need
	 1)Endpoint ==> Mandatory ==> spec02
	 2)Request Body ==> Mandatory
	 3)Authorization ==> Optional
	 4)Headers ==> Optional
	 */
	
	@Test
	public void post01() {
	
		//1.Way: To create a Request Body ==> Create a String variable and assign the Request Body into the variable
		String reqBody = "{\n" + 
						 "    \"bookingid\": 24,\n" + 
				         "    \"booking\": {\n" + 
				         "    \"firstname\": \"Suleyman\",\n" + 
				         "    \"lastname\": \"Alptekin\",\n" + 
				         "    \"totalprice\": 111,\n" + 
				         "    \"depositpaid\": true,\n" + 
				         "    \"bookingdates\": {\n" + 
				         "            \"checkin\": \"2020-09-14\",\n" + 
				         "            \"checkout\": \"2020-10-04\"\n" + 
				         "    },\n" + 
				         "    \"additionalneeds\": \"Wifi\"\n" + 
				         "    }\n" + 
				         "}";
		
		Response response = given().
				               spec(spec02).
				               auth().
				               basic("admin", "password123").
				               body(reqBody).
				            when().
				               post();
		response.prettyPrint();

	}
	
}
