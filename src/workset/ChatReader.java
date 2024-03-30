package workset;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;

import participants.Student;
import participants.StudentRecord;
import participants.Teacher;

// ... imports ...

public class ChatReader {
    private final String teacherName;
    private final ChatLogParser parser;   

    public ChatReader(String teacherName) {
        this.teacherName = teacherName;
        this.parser = new ChatLogParser(teacherName);
    }

    // ... other methods ... 

    public Map<String, StudentRecord> processChatLog(File chatLog) throws FileNotFoundException {
        Map<String, StudentRecord> studentRecords = new HashMap<>();

        try (Scanner scan = new Scanner(chatLog)) {
            while (scan.hasNextLine()) {
                String line = scan.nextLine();
                ChatLogParser.ChatLineResult result = parser.parseLine(line, teacherName); 

                if (result.isQuestion()) teach.incrementQuestionsAsked(); 

                if (result.hasStudentResponse()) {
                    StudentRecord record = studentRecords.computeIfAbsent(result.getStudentName(), StudentRecord::new);
                    record.processResponse(result.getAnswerTime(), result.getQuestionContent());
                }
            }
        } 
        // ... Calculate grades 
        return studentRecords;
    }


	

	public boolean isWithinTime(String timeAsked, String timeAnswered){
 
		int asked = Integer.parseInt(timeAsked);
		int answered = Integer.parseInt(timeAnswered);


		int difference = answered - asked;
		
		System.out.println(difference);

		return difference < 5; 
		
	}

	//displays the information to the user
	public void display(LinkedList<Student> students) {
		System.out.println(teach .toString()+"\n");//displays the teacher's name
		System.out.println("\n"+students.toString());//displays the names of the students along with the grades
	}
	
	//checks to see if a question was asked
	public void questionCounter(String line) {
		if(line.contains("?")==true) {
			teach.setQuestionsAsked(teach.getQuestionsAsked()+1);
			answeredQuestionsTracker();
		}
	}

	//resets the status of the student answering the question
	public void answeredQuestionsTracker() {
		int i = 0;
		for (Student LinkedList: students) {
			students.get(i).setAlreadyAnsweredQuestion(false);
			i++;
		}
	}

	//calculates the grades of the students
	public void gradeCalculator() {
		int i = 0;

		for(Student LinkedList : students) {
			students.get(i).setGrade(students.get(i).getQuestionsAnswered()/teach.getQuestionsAsked()*100);
			i++;
		}
	}
}
