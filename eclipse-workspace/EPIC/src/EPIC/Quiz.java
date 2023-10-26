package epic;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
public class Quiz {

    private static List<User> users = new ArrayList<>();

    public static void main(String[] args) {
        while (true) {
            String[] options = {"Create New User", "Display User Statistics", "Exit"};
            int choice = JOptionPane.showOptionDialog(null,
                    "Choose an option:", "Quiz Application", JOptionPane.DEFAULT_OPTION,
                    JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

            switch (choice) {
                case 0:
                    createUser();
                    break;
                case 1:
                    displayUserStatistics();
                    break;
                case 2:
                    return;
            }
        }
    }

    private static void createUser() {
        String username = JOptionPane.showInputDialog(null, "Enter username:");
        String password = JOptionPane.showInputDialog(null, "Enter password:");
        User user = new User(username, password);
        users.add(user);
        JOptionPane.showMessageDialog(null, "User created successfully.", "User Created", JOptionPane.INFORMATION_MESSAGE);
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
}


