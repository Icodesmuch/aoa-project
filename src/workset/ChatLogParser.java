package workset;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class ChatLogParser {
    private static final String TIME_FORMAT = "HHmm";  // Assuming 24-hour time
    private final DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern(TIME_FORMAT);
    private final String teacherName;

    public ChatLogParser(String teacherName) {
        this.teacherName = teacherName;
    }

    public ParsedLineResult parseLine(String line, String teacherName) { 
        ParsedLineResult result = new ParsedLineResult();

        if (line.contains("From")) {
            result.setFrom(extractParticipantName(line));

            if (result.getFrom().equals(teacherName)) {
                result.setQuestion(isQuestion(line));
            } else {
                result.setStudentResponse(true);
                result.setAnswerTime(extractAnswerTime(line));
            }
        }
        return result; 
    } 


    // ... other fields and methods ...

    public String extractQuestionContent(String line) {
        if (line.startsWith("From " + teacherName + " To Everyone:")) { 
            return line.substring(("From " + teacherName + " To Everyone:").length()).trim(); 
        } 
        return null; 
    }

    // ... other ChatLogParser methods ...



    private String extractParticipantName(String line) {
        return line.substring(line.indexOf("From ") + 5, line.indexOf(" To"));
    }

    private LocalTime extractAnswerTime(String line) {
        try {
            String timeString = line.substring(0, TIME_FORMAT.length()); 
            return LocalTime.parse(timeString, timeFormatter);
        } catch (DateTimeParseException e) {
            // Handle the case where the time format is incorrect
            return null; 
        }
    }

    public boolean isQuestion(String line) {
        return line.contains("From " + teacherName) && line.contains("?"); 
    }

    // Inner class to store the parsed results from a line
    static class ParsedLineResult {
        private String from;
        private boolean isQuestion;
        private boolean studentResponse;
        private LocalTime answerTime; 

        // Getters and setters 
        // ...
    }
}
