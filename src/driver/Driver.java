package driver;
import java.io.FileNotFoundException;
import java.util.LinkedList;

import participants.Student;
import workset.ChatReader;

public class Driver {

	public static void main(String[] args) throws FileNotFoundException {
		ChatReader read = new ChatReader();
		
		String file = read.getTeacherName();
		LinkedList<Student> students = read.parseChatLog(file);
		read.display(students);

	}

}
