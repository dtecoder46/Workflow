public class Timer {
	private String taskName;

	public Timer(String taskName) {
		this.taskName = taskName;
	}

	public String getter() {
		return taskName;
	}

	public void timer() {
		String task = getter();

		print("Your timer for working on " + task + " starts now!");

		for (int minutes = 15; minutes > 0; minutes--) {
			if (minutes % 5 == 0) {
				System.out.println(minutes + " minutes remaining for the task " + task);
			}
		}
	}

	public void print(String text) {
		System.out.println(text);
	}
}
