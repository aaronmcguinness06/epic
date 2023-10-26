package epic;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

	

	public class User {
	    private String username;
	    private String password;
	    private List<Integer> quizScores;  // Scores of quizzes taken by the user

	    public User(String username, String password) {
	        this.username = username;
	        this.password = password;
	        this.quizScores = new ArrayList<>();
	    }

	    public String getUsername() {
	        return username;
	    }

	    public boolean authenticate(String enteredPassword) {
	        return password.equals(enteredPassword);
	    }

	    public void addQuizScore(int score) {
	        quizScores.add(score);
	    }

	    public List<Integer> getQuizScores() {
	        return quizScores;
	    }

	    // Method to calculate mean of quiz scores
	    public double calculateMean() {
	        if (quizScores.isEmpty()) return 0;

	        int sum = 0;
	        for (int score : quizScores) {
	            sum += score;
	        }
	        return (double) sum / quizScores.size();
	    }

	    // Method to calculate median of quiz scores
	    public double calculateMedian() {
	        if (quizScores.isEmpty()) return 0;

	        int n = quizScores.size();
	        quizScores.sort(Integer::compareTo);

	        if (n % 2 == 0) {
	            return (double) (quizScores.get(n / 2 - 1) + quizScores.get(n / 2)) / 2;
	        } else {
	            return quizScores.get(n / 2);
	        }
	    }

	    // Method to calculate standard deviation of quiz scores
	    public double calculateStandardDeviation() {
	        if (quizScores.isEmpty()) return 0;

	        double mean = calculateMean();
	        double sumOfSquares = 0;

	        for (int score : quizScores) {
	            sumOfSquares += Math.pow(score - mean, 2);
	        }

	        return Math.sqrt(sumOfSquares / quizScores.size());
	    }

	    public void displayStatistics() {
	        StringBuilder message = new StringBuilder("Statistics for " + getUsername() + ":\n");
	        message.append("Quiz Scores: ").append(getQuizScores()).append("\n");
	        message.append("Mean: ").append(calculateMean()).append("\n");
	        message.append("Median: ").append(calculateMedian()).append("\n");
	        message.append("Standard Deviation: ").append(calculateStandardDeviation());

	        JOptionPane.showMessageDialog(null, message.toString(), "User Statistics", JOptionPane.INFORMATION_MESSAGE);
	    }
	

	public static void questionsM() {
		List<Question> questions = new ArrayList<>();
        Random random = new Random();
        
		
		
	}
	


}
