package epic;

import java.util.List;

public class Question {
    private String questionText;
    private String[] answers;
    private int score;
	private String correctAnswer;
	private List<String> correctAnswers; // For multiple-choice questions

    // for multiple-choice questions
    public Question(String questionText, String[] answers, int correctAnswerIndex, int score) {
        this.questionText = questionText;
        this.answers = answers;
        this.correctAnswer = answers[correctAnswerIndex]; // Store the correct answer
        this.score = score;
    }
    
    //for one answer
    public Question(String questionText, String correctAnswer, int score) {
        this.questionText = questionText;
        this.correctAnswer = correctAnswer;
        this.score = score;
    }
    
 // for multiple-answer questions
    public Question(String questionText, String[] answerChoices, List<String> correctAnswers, int score) {
        this.questionText = questionText;
        this.answers = answerChoices;
        this.correctAnswers = correctAnswers;
        this.score = score;
    }
    
    //for correct answer and score 
    public boolean isCorrect(String userAnswer) {
        if (correctAnswer != null) {
            return userAnswer.equalsIgnoreCase(correctAnswer);
        } else if (correctAnswers != null) {
            return correctAnswers.contains(userAnswer);
        } else {
            return false; 
        }
    }

    
}
