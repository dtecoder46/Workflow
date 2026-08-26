public class Timer {
	private String taskName;

	public Timer(String taskName) { // for initially setting the value
		this.taskName = taskName;
	}

	public String getter() {
		return taskName;
	}

	public void setter(String taskName) { // used for changing the value after the object is instantiated
		this.taskName = taskName;
	}

	public void timer() {
		String task = getter();

		print("Your timer for working on " + task + " starts now!");

		for (int minutes = 15; minutes > 0; minutes--) {
			if (minutes % 5 == 0) {
				System.out.println(minutes + " minutes remaining for the task " + task);
			}

			int seconds = 60;
			Thread.sleep(60 * 1000);
		}

		print("Time's up!");
	}

	public void print(String text) {
		System.out.println(text);
	}
}
