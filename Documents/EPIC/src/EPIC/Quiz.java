package EPIC;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class Quiz {

	private static List<User> users = new ArrayList<>();

    public static void main(String[] args) {
        while (true) {
            String[] options = {"Create New User", "Display User Statistics", "Start Quiz", "Exit"};
            int choice = JOptionPane.showOptionDialog(null,
                    "Choose an option:", "Quiz Application", JOptionPane.DEFAULT_OPTION,
                    JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

            switch (choice) {
                case 0:
                    createUser();
                    break;
                case 1:
                    if (users.size() != 0) {
                        displayUserStatistics();
                    } else {
                        JOptionPane.showMessageDialog(null, "Error: There are no users logged into the system",
                                "Error", JOptionPane.ERROR_MESSAGE);
                    }
                    break;
                case 2:
                    if (users.size() != 0) {
                        User selectedUser = selectUser(); // Get the selected user
                        if (selectedUser != null) {
                            QuizManager quizManager = new QuizManager();
                            quizManager.startQuiz(selectedUser);
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Error: There are no users logged into the system",
                                "Error", JOptionPane.ERROR_MESSAGE);
                    }
                    break;
                case 3:
                    return;
            }
        }
    }

    private static User selectUser() {
        String[] usernames = new String[users.size()];
        for (int i = 0; i < users.size(); i++) {
            usernames[i] = users.get(i).getUsername();
        }

        String selectedUsername = (String) JOptionPane.showInputDialog(null,
                "Select a user to start the quiz:", "Select User",
                JOptionPane.QUESTION_MESSAGE, null, usernames, usernames[0]);

        if (selectedUsername != null) {
            for (User user : users) {
                if (user.getUsername().equals(selectedUsername)) {
                    return user;
                }
            }
        }
        return null; // User not found
    }

    private static void createUser() {
    	
        String username = JOptionPane.showInputDialog(null, "Enter username:");

    	if (isUsernameTaken(username)) {
            JOptionPane.showMessageDialog(null, "Username is already taken. Please choose a different username.", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            User user = new User(username);
            users.add(user);
            JOptionPane.showMessageDialog(null, "User created successfully.", "User Created", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private static void displayUserStatistics() {
        String[] usernames = new String[users.size()];
        for (int i = 0; i < users.size(); i++) {
            usernames[i] = users.get(i).getUsername();
        }

        String selectedUsername = (String) JOptionPane.showInputDialog(null,
                "Select a user to display statistics:", "Select User",
                JOptionPane.QUESTION_MESSAGE, null, usernames, usernames[0]);

        if (selectedUsername != null) {
            User selectedUser = null;
            for (User user : users) {
                if (user.getUsername().equals(selectedUsername)) {
                    selectedUser = user;
                    break;
                }
            }

            if (selectedUser != null) {
                selectedUser.displayStatistics();
            }
        }
    }
    
    private static boolean isUsernameTaken(String username) {
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                return true; // Username is already taken
            }
        }
        return false; // Username is available
    }
}