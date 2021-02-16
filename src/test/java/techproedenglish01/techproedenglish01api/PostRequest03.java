package techproedenglish01.techproedenglish01api;

import static io.restassured.RestAssured.*;

import org.json.JSONObject;
import org.junit.Test;

import io.restassured.response.Response;

public class PostRequest03 extends TestBase{
	
	@Test
	public void post01() {
		
		/*
		   {
             "userId": 1,
             "title": "Aliiiiiii",
              "completed": true
           }
		 */
		
		JSONObject reqBody = new JSONObject();
		reqBody.put("userid", 1);
		reqBody.put("title", "Aliiiiiii");
		reqBody.put("completed", true);
		
		
		Response response = given().
				               spec(spec01).
				               body(reqBody.toString()).
				            when().
				               post();
		response.prettyPrint();
		
		response.then().assertThat().statusCode(201);
	}

}
