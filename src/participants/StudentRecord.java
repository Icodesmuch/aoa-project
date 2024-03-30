package participants;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

public class StudentRecord {
    private String name;
    private int questionsAnswered = 0;
    private double grade; // You'll likely calculate this later
    private Set<String> answeredQuestions = new HashSet<>();
    private LocalTime recentAnswerTime = null;

    public StudentRecord(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getQuestionsAnswered() {
        return questionsAnswered;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    public void processResponse(LocalTime answerTime, String questionContent) {
        if (!answeredQuestions.add(questionContent) || !isWithinTimeWindow(answerTime)) { 
            return; // Student already answered this (or a similar) question recently
        }

        this.recentAnswerTime = answerTime;
        this.questionsAnswered++;
    }

    private boolean isWithinTimeWindow(LocalTime answerTime) {
        if (recentAnswerTime == null) return true; // First answer

        long minutesBetween = java.time.Duration.between(recentAnswerTime, answerTime).toMinutes();
        return minutesBetween >= 5; // Adjust the '5' if you have a different time window
    }
}
