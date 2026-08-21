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

	

	public static void main(String[] args) {
		String jsonText = readJSON();

		print(jsonText);
  	}

	public static void print(String text) {
		System.out.println(text);
	}
}
