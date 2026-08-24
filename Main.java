import java.io.File;                  // Import the File class
import java.io.FileNotFoundException; // Import this class to handle errors
import java.util.Scanner;             // Import the Scanner class to read text files

import java.util.HashMap;

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
	 * Return: nonBlankLines - the list of JSON lines
	 */

	public static String[] processJSON(String json) {
		json = json.replaceAll("[{},]", "");

		String[] JSONLines = json.split("\n");

		int index = 0;

		// removes blanks by transferring non-blanks into a new list

		String nonBlank = "";

		for (String line : JSONLines) {
			if (line.compareTo("") == 0) {
				continue;
			}
			else {
				nonBlank += line + "\n";
			}
			
			index++;
		}

		String[] nonBlankLines = nonBlank.split("\n");
		
		return nonBlankLines;
	}

	/*
	 * Name: mapCreator()
	 * Purpose: to build out a HashMap of tasks from a list of JSON lines
	 * Parameters: String[] linesList - list of JSON lines
	 * Return: HashMap<String, String> taskMap - the HashMap of tasks
	 */

	public static HashMap<String, String> mapCreator(String[] linesList) {
		HashMap<String, String> taskMap = new HashMap<>();
		
		for (String line : linesList) {
			String[] keyValuePair = line.split(": ");
			
			taskMap.put(keyValuePair[0], keyValuePair[1]);
		}

		return taskMap;
	}

	public static String workflow(HashMap<String, String> taskMap) {
		/* 
		 * Outer loop TODO:
		 * Comments
		 */
		
		Scanner input = new Scanner(System.in);

		print("Do you want to continue your workflow? (yes/no): ");

		String continueStatus = input.nextLine();

		if (continueStatus.compareTo("yes") == 0) {
			// inner loop
			// 15 min break timer
			workflow(taskMap);
		}
		else {
			return "The workflow has stopped."; // error
		}
	}

	public static void main(String[] args) {
		String jsonText = readJSON();
		String[] json = processJSON(jsonText);
		HashMap<String, String> map = mapCreator(json);

		System.out.println(map.get("\"1\""));
  	}

	public static void print(String text) {
		System.out.println(text);
	}
}
