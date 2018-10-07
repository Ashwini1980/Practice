package api.testing;

import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;

public class PutExamples {
	
	private static String base_url = "http://localhost:3000/employees";
	String test_url;
	
	@Test
	public void update_put_test() {
		
		test_url = base_url+"/5";
		
		Response response = given().contentType(ContentType.JSON)
							.accept(ContentType.JSON)
							.body("{\"name\" : \"Sakshi\", \"salary\" : \"393939\"}")
							.when()
							.put(test_url);
		
		System.out.println(response.asString());
		System.out.println(response.getStatusCode());
		
		response.then().body("id", Matchers.is(5));
		response.then().body("salary", Matchers.is("393939"));
		
	}
	
	@Test
	public void update_put_test1 () {
		
		test_url = base_url+"/4";
		
		RequestSpecification request = given();
		request.header("Content-Type", "application/json");
		
		JSONObject body = new JSONObject();
		body.put("name", "Ashwini");
		body.put("salary", "909090");
		
		request.body(body.toString());
		
		Response response = request.put(test_url);
		System.out.println(response.asString());
		System.out.println(response.getStatusCode());
		
		JsonPath path = response.jsonPath();
		String sal = path.get("salary");
		System.out.println(sal);
		Assert.assertEquals(sal, "909090");
		
		
		
		
	}

}
