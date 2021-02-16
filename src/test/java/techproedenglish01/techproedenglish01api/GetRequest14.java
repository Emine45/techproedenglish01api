package techproedenglish01.techproedenglish01api;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class GetRequest14 extends TestBase{
	
	/*
	    When I send a GET Request to the URL https://restful-booker.herokuapp.com/booking/3
	 Then 
	 HTTP Status code should be 200
	 And Content type should be Json
	 And Status Line should be HTTP/1.1 200 OK
	 */
	
	@Test
	public void get01() {
		
		spec02.pathParam("bookingid", 3);
		Response response = given().spec(spec02).
				            when().
				              get("/{bookingid}");
		
		response.prettyPrint();
		
		Map<String, Object> map = new HashMap<>();
		map.put("firstname", "Mary");
		map.put("totalPrice", 288);
		map.put("depositpaid", false);
		map.put("checkin", "2019-07-10");
		
		response.then().
		         assertThat().
		         statusCode(200).
		         contentType(ContentType.JSON).
		         statusLine("HTTP/1.1 200 OK").
		         body("firstname",equalTo(map.get("firstname")),
		    	      "totalPrice", equalTo(map.get("totalPrice")),
			          "depositpaid", equalTo(map.get("depositpaid")),
			          "bookingdates.checkin", equalTo(map.get("checkin")));
		
		
	}

}
