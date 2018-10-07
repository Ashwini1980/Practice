package api.testing;

import static io.restassured.RestAssured.*;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class OptionsExamples {
	
	private static String base_url = "http://localhost:3000/employees";
	String test_url;
	
	@Test
	public void options_test() {
		
		test_url = base_url+"/3";
		
		Response response = options(test_url);
		System.out.println(response.asString());
		System.out.println(response.getStatusCode());
		System.out.println(response.headers());
		
		//test
		response.headers().getValue("Access-Control-Allow-Methods").isEmpty();
		System.out.println(response.headers().size());
		System.out.println(response.headers().getValue("Access-Control-Allow-Methods").contains("POST"));
		
		
		
	}
	

}
