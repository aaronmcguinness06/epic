package epic;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class startQ {
    // Define your question lists here (math, compOrg, csFoundations)
    // ...

    private static List<Question> selectedQuestions;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            createGUI();
        });
    }

    private static void createGUI() {
        JFrame frame = new JFrame("Epic Quiz");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);

        JPanel panel = new JPanel();
        frame.add(panel);

        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JComboBox<String> difficultyComboBox = new JComboBox<>(new String[]{"Novice", "Intermediate", "Expert", "All questions"});
        JButton startButton = new JButton("Start Quiz");

        panel.add(difficultyComboBox);
        panel.add(startButton);

        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedDifficulty = (String) difficultyComboBox.getSelectedItem();
                //selectedQuestions = loadQuestions(selectedDifficulty);

                //if (selectedQuestions != null && !selectedQuestions.isEmpty()) {
                 //   startQuiz(selectedQuestions);
               // } else {
                    JOptionPane.showMessageDialog(frame, "No questions available for the selected difficulty.");
               // }
            }
        });

        frame.setVisible(true);
   }
}
   