package api.testing;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import io.restassured.response.Response;

public class DeleteExamples {
	
	private static String base_url = "http://localhost:3000/employees";
	String test_url;
	
	@Test
	public void delete_test() {
		
		test_url = base_url+"/5";
		
		Response response = delete(test_url);
		System.out.println(response.asString());
		System.out.println(response.getStatusCode());
		
		//test if record id present is present or not
		response.then().body("id", Matchers.not(5));
		
		
	}
	
	@Test
	public void delete_test1() {
		
		test_url = base_url+"/4";
		
		Response response = delete(test_url);
		System.out.println(response.asString());
		System.out.println(response.getStatusCode());
		
		//test if record id present is present or not
		response.then().body("id", Matchers.not(5));
		
		
	}


}
