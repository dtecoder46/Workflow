import java.util.Scanner;

public class taskInput {
	private int id;
	private String json;

	/**
	 * Name: taskInput
	 * Purpose: assign initial values to json and id
	 * @param none
	 * @return none
	 */

	public taskInput() {
		json = "{\n";
		id = 1;
	}

	/**
	 * Name: getJSON
	 * Purpose: access the json attribute
	 * @param none
	 * @return json
	 */

	public String getJSON() {
		return this.json;
	}

	/**
	 * Name: getId()
	 * Purpose: access the id attribute
	 * @param none
	 * @return id
	 */

	public int getId() {
		return this.id;
	}

	/**
	 * Name: taskLoop()
	 * Purpose: repeatedly ask for the user's task to build the content of tasks.jsonc
	 * @param none
	 * @return none
	 */

	public static void taskLoop() {

		boolean continueInput = true;

		do {
			Scanner input = new Scanner(System.in);
			
			print("\nEnter a task you need to work on (type \"STOP\" when you've put in all your tasks): ");

			String task = input.nextLine();

			String taskUpperCase = task.toUpperCase();

			int taskIsSTOP = taskUpperCase.compareTo("STOP");

			if (taskIsSTOP == 0) {
				continueInput = false;

				print("\nTask input loop has stopped, proceeding to startup the workflow timer...");
			}

		} while (continueInput == true);
	}

	public static void print(String text) {
		System.out.println(text);
	}

}
