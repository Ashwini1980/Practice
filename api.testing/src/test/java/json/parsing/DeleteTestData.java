package json.parsing;

import java.io.File;

import org.testng.annotations.Test;

public class DeleteTestData {
	
	@Test
	public void delete_file_test() {
		
		File file = new File ("C:\\Users\\Ashwini\\Desktop\\WriteData.json");
		
		if (file.exists()) {
			
			file.delete();
			System.out.println("Deleted the file successfully.");
			System.out.println("Check if Deleted the file successfully.");
			
		} else {
			System.out.println("File does not exist.");
		}
		
		
	}

}
