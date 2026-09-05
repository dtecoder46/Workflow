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

	public void taskLoop() {

		boolean continueInput = true;

		do {
			// get input

			Scanner input = new Scanner(System.in);
			
			print("\nEnter a task you need to work on (type \"STOP\" when you've put in all your tasks): ");

			String task = input.nextLine();

			// check if user is done entering tasks

                        String taskUpperCase = task.toUpperCase();

                        int taskIsSTOP = taskUpperCase.compareTo("STOP");

                        if (taskIsSTOP == 0) {

                                continueInput = false;

                                print("\nTask input loop has stopped, proceeding to startup the workflow timer...");

				break;
                        }

			// add task as JSON key-value

			this.json += "\t\"" + id + "\": \"" + task + "\",\n";
		
			this.id += 1; // increase id number for each task

		} while (continueInput == true);

		this.json += "}";

		writeTasks();
	}

	/**
	 * Name: writeTasks()
	 * Purpose: overwrite contents of tasks.jsonc and add new set of tasks
	 * @param none
	 * @return none
	 */

	public void writeTasks() {
		writeFile fileWriter = new writeFile(this.json);

		fileWriter.write();
	}

	public static void print(String text) {
		System.out.println(text);
	}

}
