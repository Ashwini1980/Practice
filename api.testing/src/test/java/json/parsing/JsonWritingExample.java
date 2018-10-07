package json.parsing;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedHashMap;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.annotations.Test;

public class JsonWritingExample {
	
	@Test
	public void json_write_test() throws IOException {
		
		JSONObject jo = new JSONObject();
		jo.put("firstname", "Ashwini");
		jo.put("age", 35);
		jo.put("location", "Hyderabad");
		
		Map<Object, Object>  hm = new LinkedHashMap<Object, Object> (3);
		hm.put("Village", "Bebartamunda");
		hm.put("Postoffice", "Talcher");
		hm.put("Dist", "Angul");
		
		jo.put("Address", hm);
		
		JSONArray ja = new JSONArray();
		
		hm = new LinkedHashMap <Object, Object> (2);
		hm.put("type", "home");
		hm.put("number", "9922001093");		
		ja.put(hm);
		
		hm = new LinkedHashMap <Object, Object> (2);
		hm.put("type", "office");
		hm.put("number", "9028730201");		
		ja.put(hm);
		
		jo.put("PhoneNumbers", ja);
		
		PrintWriter pw = new PrintWriter(new FileWriter("C:\\Users\\Ashwini\\Desktop\\WriteData.json"));
		pw.write(jo.toString());
		pw.flush();
		pw.close();
		
		
		
		
		
		
	}

}
