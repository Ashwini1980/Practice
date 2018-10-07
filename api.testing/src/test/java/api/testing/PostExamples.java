package api.testing;

import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PostExamples {
	
	private static String base_url = "http://localhost:3000/employees";
	String test_url;
	
	@Test
	public void create_posttest() {
		
		test_url = base_url;
		RequestSpecification request = given();
		
		request.header("Content-Type", "application/json");
		
		JSONObject content = new JSONObject();
		content.put("id", 4);
		content.put("name", "Ashwini");
		content.put("salary", "9999");
		
		request.body(content.toString());
		
		Response response = request.post(test_url);
		System.out.println(response.asString());
		System.out.println(response.getStatusCode());
		Assert.assertEquals(response.getStatusCode(), 201|200);
		
		JsonPath path = response.jsonPath();
		String name = path.get("name");
		Assert.assertEquals(name, "Ashwini");

	}
	
	@Test
	public void create_posttest1() {
		
		test_url = base_url;
		
		Response response = given().contentType(ContentType.JSON)
							.accept(ContentType.JSON)
							.body("{\"id\":5, \"name\" : \"Sakshi\", \"salary\" : \"33333\" }")
							.when()
							.post(test_url);
		
		System.out.println(response.asString());
		System.out.println(response.getStatusCode());
		
		//tests
		response.then().body("id", Matchers.any(Integer.class));
		response.then().body("name", Matchers.is("Sakshi"));
		response.then().body("salary", Matchers.is("33333"));
		
	}

}
