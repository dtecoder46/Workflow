import java.io.File;                  // Import the File class
import java.io.FileNotFoundException; // Import this class to handle errors
import java.util.Scanner;             // Import the Scanner class to read text files

public class Main {

	public static String readJSON() {
		File myObj = new File("tasks.jsonc");

                String text = "";

                // read the file

                try (Scanner myReader = new Scanner(myObj)) {
                        while (myReader.hasNextLine()) {
                                String data = myReader.nextLine();
                                text += data.trim() + "\n";
                        }
                } catch (FileNotFoundException e) {
                        System.out.println("An error occurred.");
                        e.printStackTrace();
                }

		return text;
	}

	/*
	 * Name: processJSON
	 * Purpose: remove unnecessary characters and split JSON contents into a list of lines
	 * Parameters: json - the JSON file contents
	 * Return: JSONLines - the list of JSON lines
	 */

	public static String[] processJSON(String json) {
		json = json.replaceAll("[{},]", "");

		String[] JSONLines = json.split("\n");
		
		return JSONLines;
	}	

	public static void main(String[] args) {
		String jsonText = readJSON();
		String[] json = processJSON(jsonText);
		
		print(json[1]);
  	}

	public static void print(String text) {
		System.out.println(text);
	}
}
