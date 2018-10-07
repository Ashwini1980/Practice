package api.testing;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.hasItems;

import org.hamcrest.Matchers;

public class GetExamples {
	
	private static String base_url = "http://localhost:3000/employees";
	String test_url;
	
	@Test
	public void simple_getTest() {
		
		test_url = base_url;		
		Response response = get(test_url);
		System.out.println("The response is: \n"+response.asString());		
		Assert.assertEquals(response.getStatusCode(), 200);
		
		//test
        response.then().body("id", hasItems(1,2,3));
		response.then().body("name", hasItems("David", "Pankaj", "Lisa Patt"));	
		response.then().body("salary", hasItems("10000"));	
		
	}
	
	@Test
	public void simple_getTest1() {
		
		test_url = base_url+"/1";		
		Response response = get(test_url);
		System.out.println("The response is: \n"+response.asString());	
		System.out.println("Response Code is: "+response.getStatusCode());
		Assert.assertEquals(response.getStatusCode(), 200);
		
		//test
		response.then().body("id", Matchers.any(Integer.class));
		response.then().body("name", Matchers.is("Pankaj"));	
		
		JsonPath path = response.jsonPath();
		System.out.println("The ID is: "+path.get("id"));
		int val = path.get("id");
		System.out.println("int value is: "+val);
		Assert.assertEquals(val, 1);
			
	}

}
