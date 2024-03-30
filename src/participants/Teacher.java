package participants;

public class Teacher {
	private String name;
	private double questionsAsked;
	
	public Teacher() {
		name = "";
		questionsAsked = 0;
	}
	
	public Teacher(String name, double questionsAsked) {
		this.name = name;
		this.questionsAsked = questionsAsked;
	}

	//getters and setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getQuestionsAsked() {
		return questionsAsked;
	}

	public void setQuestionsAsked(double questionsAsked) {
		this.questionsAsked = questionsAsked;
	}

	@Override
	public String toString() {
		return "\nTeacher's Name: " + name + 
				"\nNumber of Questions Asked: " + questionsAsked ;
	}
	
	
}
