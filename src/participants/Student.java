package participants;

public class Student {
	private String name;
	private double questionsAnswered;
	private double grade;
	private boolean alreadyAnsweredQuestion;
	
	public Student() {
		name = "";
		questionsAnswered = 0;
		grade = 0.0;
		alreadyAnsweredQuestion = false;
	}
	
	public Student(String name, double questionsAnswered, double grade,boolean alreadyAnsweredQuestion) {
		this.name = name;
		this.questionsAnswered = questionsAnswered;
		this.grade = grade;
		this.alreadyAnsweredQuestion = alreadyAnsweredQuestion;
	}

	//getters and setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getQuestionsAnswered() {
		return questionsAnswered;
	}

	public void setQuestionsAnswered(double questionsAnswered) {
		this.questionsAnswered = questionsAnswered;
	}

	public double getGrade() {
		return grade;
	}

	public void setGrade(double grade) {
		this.grade = grade;
	}

	public boolean isAlreadyAnsweredQuestion() {
		return alreadyAnsweredQuestion;
	}

	public void setAlreadyAnsweredQuestion(boolean alreadyAnsweredQuestion) {
		this.alreadyAnsweredQuestion = alreadyAnsweredQuestion;
	}

	//private HashSet<Integer> answeredQuestion = new HashSet<>();

	@Override
	public String toString() {
		return "\nName:" + name +
				"\nQuestions Answered: " + questionsAnswered + 
				"\nGrade: " +grade+"\n";
	}
	;
	
}
