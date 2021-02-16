package techproedenglish01.techproedenglish01api;

import static io.restassured.RestAssured.given;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.testng.asserts.SoftAssert;

import io.restassured.response.Response;
import utilities.JsonUtil;

public class ObjectMapperPractice extends TestBase{
	
	/*
	  1) Use spec01 and get method to get json response
	  2) Convert Json to Java by using ObjectMapper
	  3)Type hard assertion for status code
      4)Type soft assertions for response body details
	 */
	
	@Test
	public void practice() {
		
		spec01.pathParam("id", 11);
		Response response = given().spec(spec01).when().get("/{id}");
		response.prettyPrint();
		
		Map<String, Object> actualMap = JsonUtil.convertJsonToJava(response.asString(), Map.class);
		System.out.println(actualMap);
		
		Map<String, Object> expectedMap = new HashMap<>();
		expectedMap.put("title", "vero rerum temporibus dolor");
		expectedMap.put("completed", true);
		
		response.then().assertThat().statusCode(200);
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(actualMap.get("title"), expectedMap.get("title"));
		softAssert.assertEquals(actualMap.get("completed"), expectedMap.get("completed"));
		
		
		softAssert.assertAll();
	}

}
