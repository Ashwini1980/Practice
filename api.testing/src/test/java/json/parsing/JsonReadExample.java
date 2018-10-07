package json.parsing;

import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.testng.annotations.Test;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.*; 


public class JsonReadExample {
	
	@SuppressWarnings("unchecked")
	@Test
	public void json_read_test() throws IOException, ParseException {
		
		Object obj = new JSONParser().parse(new FileReader("C:\\Users\\Ashwini\\Desktop\\WriteData.json"));		
		JSONObject jo = (JSONObject) obj; 
		
		String firstName = (String) jo.get("firstname");
		System.out.println("First Name is: "+firstName);
		long ages = (Long) jo.get("age");		
		System.out.println("Age Name is: "+ages);
		
		Map<Object, Object> address = ((Map<Object, Object>) jo.get("Address"));		
		Iterator<Entry<Object, Object>> itr1 = address.entrySet().iterator();
		
		while (itr1.hasNext()) {
			
			Map.Entry<Object, Object> pair = itr1.next();
			System.out.println(pair.getKey() +" : "+pair.getValue());
		}
		
		JSONArray ja = (JSONArray) jo.get("PhoneNumbers");
		Iterator<Object> itr2 = ja.iterator();
		
		while (itr2.hasNext()) {
			
			itr1 = ((Map<Object, Object>)itr2.next()).entrySet().iterator();
			
			while (itr1.hasNext()) {
				
				Map.Entry<Object, Object> pair = itr1.next();
				System.out.println(pair.getKey() +" : "+pair.getValue());
				
			}
			
		}
		
		
		
		
	}

}
