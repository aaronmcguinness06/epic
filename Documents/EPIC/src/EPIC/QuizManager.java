package EPIC;

import java.awt.GridLayout;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class QuizManager {
    private List<Question> questions = new ArrayList<>();
    private User selectedUser; // Add selectedUser field

    public QuizManager() {
        // Read and parse the JSON file to load questions
        try {
            String jsonFilePath = "res/questions.json";  // Replace with the actual file path
            FileReader fileReader = new FileReader(jsonFilePath);
            Gson gson = new Gson();
            JsonArray jsonArray = gson.fromJson(fileReader, JsonArray.class);

            for (int i = 0; i < jsonArray.size(); i++) {
                JsonObject questionObject = jsonArray.get(i).getAsJsonObject();
                // Create Question objects from questionObject and add them to the questions list
                Question question = new Question(
                	    questionObject.get("category").getAsString(),
                	    questionObject.get("difficulty").getAsString(),
                	    questionObject.get("question").getAsString(),
                	    parseOptions(questionObject.getAsJsonArray("options")),
                	    questionObject.get("correctOption").getAsString()
                	);
                questions.add(question);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private String[] parseOptions(JsonArray optionsArray) {
        String[] options = new String[optionsArray.size()];
        for (int i = 0; i < optionsArray.size(); i++) {
            options[i] = optionsArray.get(i).getAsString();
        }
        return options;
    }

   
    public void startQuiz(User user) {
        selectedUser = user;
        
        String[] options = { "Random Draw", "Increasing Difficulty" };
        
        int choice = JOptionPane.showOptionDialog(null,
                "Select the quiz format:", "Quiz Format", JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

        if (choice == 0) {
            // Start the quiz using the random draw format
            startRandomDrawQuiz();
        } else if (choice == 1) {
            // Start the quiz using the increasing difficulty format
            startIncreasingDifficultyQuiz();
        }
    }
    
    private void startRandomDrawQuiz() {
        List<Question> allQuestions = new ArrayList<>(questions);
        List<Question> selectedQuestions = new ArrayList<>();

        // Shuffle the list of all questions
        Collections.shuffle(allQuestions);

        // Select 6 questions (2 from each category)
        int questionsPerCategory = 2;
        for (String category : new String[] { "COMP SCIENCE", "COMP ORG", "DISCRETE MATHS" }) {
            List<Question> categoryQuestions = new ArrayList<>(allQuestions);
            categoryQuestions.removeIf(question -> !question.getCategory().equals(category));
            Collections.shuffle(categoryQuestions);
            selectedQuestions.addAll(categoryQuestions.subList(0, questionsPerCategory));
        }

        // Ask selected questions
        for (Question question : selectedQuestions) {
            askQuestion(question);
        }
    }

    private void startIncreasingDifficultyQuiz() {
        List<Question> allQuestions = new ArrayList<>(questions);
        List<Question> selectedQuestions = new ArrayList<>();

        // Sort all questions by difficulty (NOVICE, INTERMEDIATE, EXPERT)
        Collections.sort(allQuestions, (q1, q2) -> q1.getDifficulty().compareTo(q2.getDifficulty()));

        // Select 6 questions (2 from each category, increasing difficulty)
        int questionsPerCategory = 2;
        for (String category : new String[] { "COMP SCIENCE", "COMP ORG", "DISCRETE MATHS" }) {
            List<Question> categoryQuestions = new ArrayList<>(allQuestions);
            categoryQuestions.removeIf(question -> !question.getCategory().equals(category));
            selectedQuestions.addAll(categoryQuestions.subList(0, questionsPerCategory));
        }

        // Ask selected questions
        for (Question question : selectedQuestions) {
            askQuestion(question);
        }
    }
    
    private void askQuestion(Question question) {
        // Create an array of options with labels A, B, and C
        String[] optionLabels = { "A", "B", "C" };

        // Create an array of radio buttons for options
        JRadioButton[] radioButtons = new JRadioButton[3];

        // Create a button group to ensure only one option can be selected
        ButtonGroup buttonGroup = new ButtonGroup();

        // Create a panel to hold the radio buttons and options
        JPanel panel = new JPanel(new GridLayout(4, 1));

        // Create a label to display the question
        JLabel questionLabel = new JLabel(question.getQuestionText());
        panel.add(questionLabel);

        // Add radio buttons and options to the panel
        for (int i = 0; i < 3; i++) {
            radioButtons[i] = new JRadioButton(optionLabels[i] + ": " + question.getOptions()[i]);
            panel.add(radioButtons[i]);
            buttonGroup.add(radioButtons[i]);
        }

        int option = JOptionPane.showConfirmDialog(null, panel, "Input", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);

        if (option == JOptionPane.OK_OPTION) {
            for (int i = 0; i < 3; i++) {
                if (radioButtons[i].isSelected()) {
                    if (optionLabels[i].equalsIgnoreCase(question.getCorrectAnswer())) {
                        // Correct answer
                        JOptionPane.showMessageDialog(null, "Correct!", "Result", JOptionPane.INFORMATION_MESSAGE);
                        selectedUser.addQuizScore(1); // Update user's score
                        question.setAnsweredCorrectly(true); // Mark the question as answered correctly
                    } else {
                        // Incorrect answer
                        JOptionPane.showMessageDialog(null, "Incorrect. The correct answer is: " + question.getCorrectAnswer(), "Result", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        }
    }
    
    public double calculatePercentageCorrect() {
        int totalQuestions = questions.size();
        int correctQuestions = 0;

        for (Question question : questions) {
            if (question.isAnsweredCorrectly()) {
                correctQuestions++;
            }
        }

        if (totalQuestions > 0) {
            return (double) correctQuestions / totalQuestions * 100.0;
        } else {
            return 0.0;
        }
    }
}