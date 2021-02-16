package techproedenglish01.techproedenglish01api;

import org.junit.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class Delete01 extends TestBase {
	
	/*
	  For Delete Request we nedd just Endpoint like Get Request
	*/
	
	@Test
	public void delete01() {
		
		//Get the data before deleting
		Response response = given().spec(spec01).when().get("/198");
		response.prettyPrint();
		
		Response responseDel = given().spec(spec01).when().delete("/198");
		responseDel.prettyPrint();
		
		responseDel.then().assertThat().statusCode(200);
	}

}