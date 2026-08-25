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
	}

	public void print(String text) {
		System.out.println(text);
	}
}
