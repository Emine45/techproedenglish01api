package techproedenglish01.techproedenglish01api;

import org.hamcrest.Matchers;
import org.junit.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.HashMap;
import java.util.Map;

public class Delete02 extends TestBase{
	
	@Test
	public void delete01() {
		/*              WARM UP (10 minutes)
		When 
		I send DELETE Request to http://dummy.restapiexample.com/api/v1/delete/719
		Then 
		Status code should be 200
		The value of "status" key in response body should be "success"  
		The value of "message" key in response body should be "Successfully! Record has been deleted"
		Note: Use hard assertion
		*/
		
		spec04.pathParams("delParam", "delete",
				           "idParam", 719);
		
		Response response = given().
				               contentType(ContentType.JSON).
				               spec(spec04).
				            when().
				               delete("/{delParam}/{idParam}");
		
		response.prettyPrint();
		
		Map<String, String> responseMap = response.as(HashMap.class);
		System.out.println(responseMap);
		
		response.
		       then().
		       assertThat().
		       statusCode(200).
		       body("status", Matchers.equalTo(responseMap.get("success")),
		            "message", Matchers.equalTo(responseMap.get("Successfully! Record has been deleted")));
	}

}
