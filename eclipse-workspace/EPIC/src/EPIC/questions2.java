package epic;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Random;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

public class questions2 {
	public static List<Question> display(String subject, String difficulty) {
	    List<Question> selectedQ = new ArrayList<>();

	    switch (subject) {
	        case "Computer Organization":
	            if (difficulty.equals("Novice")) {
	                selectedQ.addAll(EpicQuestions.compOrgNoviceQuestions);
	            } else if (difficulty.equals("Intermediate")) {
	                selectedQ.addAll(EpicQuestions.compOrgIntermediateQuestions);
	            } else if (difficulty.equals("Expert")) {
	                selectedQ.addAll(EpicQuestions.compOrgExpertQuestions);
	            }
	            break;

	        case "Computer Science":
	            if (difficulty.equals("Novice")) {
	                selectedQ.addAll(EpicQuestions.csFoundationsNoviceQuestions);
	            } else if (difficulty.equals("Intermediate")) {
	                selectedQ.addAll(EpicQuestions.csFoundationsIntermediateQuestions);
	            } else if (difficulty.equals("Expert")) {
	                selectedQ.addAll(EpicQuestions.csFoundationsExpertQuestions);
	            }
	            break;

	        case "Discrete Mathematics":
	            if (difficulty.equals("Novice")) {
	                selectedQ.addAll(EpicQuestions.mathNoviceQuestions);
	            } else if (difficulty.equals("Intermediate")) {
	                selectedQ.addAll(EpicQuestions.mathIntermediateQuestions);
	            } else if (difficulty.equals("Expert")) {
	                selectedQ.addAll(EpicQuestions.mathExpertQuestions);
	            }
	            break;

	        default:
	            break;
	    }

	    return selectedQ;
	}


}
