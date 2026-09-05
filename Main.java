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

	/*
	 * Name: workflow()
	 * Purpose: manage workflow continuation input and recursive conditional routing
	 * Parameters: HashMap<String, String> taskMap - the tasks the user needs to do
	 * Return: String continueStatus - a string stating if the user wants to continue
	 */

	public static String workflow(HashMap<String, String> taskMap) {
		
		Scanner input = new Scanner(System.in);

		print("\nDo you want to continue your workflow? (yes/no): ");

		String continueStatus = input.nextLine();
		
		Timer timer = new Timer("");

		if (continueStatus.compareTo("yes") == 0) {
			// inner loop
			
			int taskLoopIterations = 2;

			int currentIteration = 0;
			
			String status = taskLoop(taskMap, timer, taskLoopIterations, currentIteration);

			print(status);	

			// 15 min break timer
			
			print("\nPress \"Enter\" to start your break");

			input.nextLine();

			timer.setter("Break");

			timer.timer();
			
			return workflow(taskMap);
		}
		else {
			return "\nThe workflow has stopped.";
		}
	}

	/**
	 * Name: taskLoop()
	 * Purpose: to ask the user for the next task to work on; to run a 15 min work timer
	 * @param map (HashMap<String, String>, the HashMap of tasks)
	 * @param timer (Timer, the Timer class object)
	 * @param loops (int, the number of times to repeat the task loop)
	 * @param currentIteration (int, the number of times the loop has repeated so far)
	 * @return none
	 */

	public static String taskLoop(HashMap<String, String> map, Timer timer, int loops, int currentIteration) {
		Scanner input = new Scanner(System.in);
		
		int id = 1;

		print("\nWhich task do you want to work on? (type the number): \n");

		for (String i : map.keySet()) {
			print("" + id + ": " + map.get("\"" + id + "\"") + "\n");
			
			id++;
		}

		// ask for the task the user wants to work on
		
		System.out.print("Enter input here: ");

		String taskId = input.nextLine();

		String currentTask = map.get("\"" + taskId + "\"");

		timer.setter(currentTask);	

		timer.timer();
		
		// recursive conditional handling
		
		currentIteration++;

		if (currentIteration < loops) {
			return taskLoop(map, timer, loops, currentIteration);
		}
		else {
			return "\ntask loop has been completed";
		}
	}

	public static void main(String[] args) {
		taskInput task = new taskInput();

		task.taskLoop();

		String jsonText = readJSON();
		
		String[] json = processJSON(jsonText);
		
		HashMap<String, String> map = mapCreator(json);
		
		String workStatus = workflow(map);
		
  	}

	public static void print(String text) {
		System.out.println(text);
	}
}
