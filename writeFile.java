import java.io.FileWriter;   // Import the FileWriter class
import java.io.IOException;  // Import the IOException class

public class writeFile {
	
	private String fileContents;

	public writeFile(String fileContents) {
		this.fileContents = fileContents;
	}

	public String getFileContents() {
		return fileContents;	
	}

       	public void write() {
    	
		try {
			// use FileWriter

      			FileWriter myWriter = new FileWriter("tasks.jsonc");
			
			// write the file contents

			String fileContents = getFileContents();

      			myWriter.write(fileContents);

     			myWriter.close();  // must close manually

      			System.out.println("Successfully wrote to the file.")
				;
    		} catch (IOException e) {
      			System.out.println("An error occurred.");
      			e.printStackTrace();
    		}
  	}
}
