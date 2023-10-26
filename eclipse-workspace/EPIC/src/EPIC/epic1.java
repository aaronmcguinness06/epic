package epic;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class epic1 {
	 private static List<Question> loadQuestions(String difficulty) {
	        List<Question> loadedQuestions = new ArrayList<>();
	        // Load questions based on the selected difficulty level
	        // Modify this part to load questions from the appropriate lists
	        switch (difficulty) {
	            case "Novice":
	                loadedQuestions.addAll(selectedQ());
	                break;
	            case "Intermediate":
	                loadedQuestions.addAll(selectedQ());
	                break;
	            case "Expert":
	                loadedQuestions.addAll(selectedExpertQuestions());
	                break;
	        }
	        return loadedQuestions;
	    }

	    // Implement methods like selectedNoviceQuestions, selectedIntermediateQuestions, and selectedExpertQuestions
	    // to load questions from your specific categories and difficulties.

	    private static void startQuiz(List<Question> questions) {
	        JFrame quizFrame = new JFrame("Quiz");
	        quizFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        quizFrame.setSize(500, 300);

	        JPanel quizPanel = new JPanel();
	        quizFrame.add(quizPanel);
	        quizPanel.setLayout(new BoxLayout(quizPanel, BoxLayout.Y_AXIS));

	        // Create GUI components to display questions and collect answers
	        JLabel questionLabel = new JLabel();
	        JRadioButton[] answerButtons = new JRadioButton[3];
	        ButtonGroup answerGroup = new ButtonGroup();
	        JButton nextButton = new JButton("Next");

	        for (int i = 0; i < 3; i++) {
	            answerButtons[i] = new JRadioButton();
	            answerGroup.add(answerButtons[i]);
	            quizPanel.add(answerButtons[i]);
	        }

	        quizPanel.add(questionLabel);
	        quizPanel.add(nextButton);

	        int questionIndex = 0;
	        int score = 0;

	        // Load the first question
	        loadQuestion(questions, questionIndex, questionLabel, answerButtons);

	        nextButton.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                if (questionIndex < questions.size() - 1) {
	                    // Check the user's answer and update the score
	                    Question currentQuestion = questions.get(questionIndex);
	                    int selectedAnswer = -1;
	                    for (int i = 0; i < 3; i++) {
	                        if (answerButtons[i].isSelected()) {
	                            selectedAnswer = i;
	                            break;
	                        }
	                    }
	                    if (selectedAnswer == currentQuestion.getCorrectAnswer()) {
	                        score++;
	                    }

	                    // Load the next question
	                    questionIndex++;
	                    loadQuestion(questions, questionIndex, questionLabel, answerButtons);
	                } else {
	                    // Display the final score
	                    JOptionPane.showMessageDialog(quizFrame, "Quiz completed. Your score: " + score);
	                }
	            }
	        });

	        quizFrame.setVisible(true);
	    }

	    

	    private static void loadQuestion(List<Question> questions, int index, JLabel questionLabel, JRadioButton[] answerButtons) {
	        if (index >= 0 && index < questions.size()) {
	            Question currentQuestion = questions.get(index);
	            questionLabel.setText(currentQuestion.getQuestionText());

	            String[] options = currentQuestion.getOptions();
	            for (int i = 0; i < 3; i++) {
	                answerButtons[i].setText(options[i]);
	                answerButtons[i].setSelected(false);
	            }} else {
	                // No more questions to display
	                questionLabel.setText("Quiz completed.");
	                for (int i = 0; i < 3; i++) {
	                    answerButtons[i].setText("");
	                    answerButtons[i].setSelected(false);
	                }
	            }
	        }
	    }
	    









}
