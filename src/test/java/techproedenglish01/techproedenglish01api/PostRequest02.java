package techproedenglish01.techproedenglish01api;

import org.json.JSONObject;
import org.junit.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class PostRequest02 extends TestBase{
	
	@Test
	public void post01() {
		
		/*
		   {
			    "firstname": "Suleyman",
			    "lastname": "Alptekin",
			    "totalprice": 111,
			    "depositpaid": true,
			    "bookingdates": {
			        "checkin": "2020-05-02",
			        "checkout": "2020-05-05"
			    },
			    "additionalneeds": "Wifi"
		    }
		 */
		
		//2.Way to create Request Body: Use JSONObject Class
		
		JSONObject reqBody = new JSONObject();
		reqBody.put("firstname", "Suleyman");
		reqBody.put("lastname", "Alptekin");
		reqBody.put("totalprice", 111);
		reqBody.put("depositpaid", true);
		
		JSONObject bookingDatesReqBody = new JSONObject();
		bookingDatesReqBody.put("checkin", "2020-05-02");
		bookingDatesReqBody.put("checkout", "2020-05-05");
		
		reqBody.put("bookingdates", bookingDatesReqBody);
		reqBody.put("additionalneeds", "Wifi");
		
		Response response = given().
				              spec(spec02).
				              auth().
				              basic("admin", "password").
				              body(reqBody.toString()).
				            when().
				              post();
		response.prettyPrint();
	}
}
