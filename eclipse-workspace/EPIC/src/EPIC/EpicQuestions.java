package epic;

import java.util.ArrayList;


import java.util.Collections;
import java.util.List;
import java.util.Random;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

public class EpicQuestions{
	 static List<Question> mathNoviceQuestions;
	 static List<Question> mathIntermediateQuestions;
	 static List<Question> mathExpertQuestions;
	 static List<Question> compOrgNoviceQuestions;
	 static List<Question> compOrgIntermediateQuestions;
	 static List<Question> compOrgExpertQuestions;
	 static List<Question> csFoundationsNoviceQuestions;
	 static List<Question> csFoundationsIntermediateQuestions;
	 static List<Question> csFoundationsExpertQuestions;
	 
	public static void main (String[] args) {
		
		display(null);
		
		
	}

		
	
	// defining questions in difficulty categories for each subject
	public static void questionsM() {
		mathNoviceQuestions = new ArrayList<>();
		mathNoviceQuestions.add(new Question("What is this operation called? p ∨ q?", new String[] { "Conjunction", "Disjunction", "Induction" }, 1, 1));
		mathNoviceQuestions.add(new Question("What is this example for? ¬(𝒑 ∨ 𝒒) ≡ ¬𝒑 ∧ ¬𝒒", new String[] { "idk", "something", "De Morgan's law" }, 2, 1));
        
		mathIntermediateQuestions = new ArrayList<>();
        mathIntermediateQuestions.add(new Question("To be bijective, function must be:?", new String[] { "Bijective", "'One to one' and 'Onto'", "'One to one' or 'Onto'" }, 2, 2));
        mathIntermediateQuestions.add(new Question("What are the dimensions of an identity matrix??", new String[] { "n*n", "n*(n-1)", "n^2" }, 1, 2));
		
        mathExpertQuestions = new ArrayList<>();
        mathExpertQuestions.add(new Question("In the knights and knaves land;  A says “I am a knave or B is a knight” and B says nothing? \nPlease enter in this format; A:knight/knave, B:knight/knave","A: knight, B: knight", 3));
        mathExpertQuestions.add(new Question("Find the sum of the first 7 terms of the geometric sequence 7,14,28,.. ","899", 3));
	}
	
	public static void questionsCO() {
		compOrgNoviceQuestions = new ArrayList<>();
		compOrgNoviceQuestions.add(new Question("What is Level 1 called in the Contemporary Multilevel Machine?", new String[] {"The ISA Level", "Digital logic level", "No level", "The Micro architecture level"}, 3,1));
		compOrgNoviceQuestions.add(new Question("Which levels are numeric in the Contemporary Multilevel Machine?", new String[] {"1-3", "0-3", "4-5"}, 1,1));
		
		compOrgIntermediateQuestions = new ArrayList<>();
		compOrgIntermediateQuestions.add(new Question("In two’s complement, what do positive numbers have in common?", new String[] {"They are negative in decimal system", "They begin with 0", "They begin with 1"}, 1, 2));
		compOrgIntermediateQuestions.add(new Question("Convert 23,14 (base 10) to binary","10111.001", 2));
		
		compOrgExpertQuestions = new ArrayList<>();
		compOrgExpertQuestions.add(new Question("Convert 2B6 (hexadecimal) to ocal","1266",3));
		compOrgExpertQuestions.add(new Question("something","yehaw",3));
		
		
	}
	public static void questionsCS() {
		csFoundationsNoviceQuestions = new ArrayList<>();
		csFoundationsNoviceQuestions.add(new Question("What does NT stand for?", new String[] {"Non-Terminals", "Not-Treated","Non-Tangable"},0,1));
		csFoundationsNoviceQuestions.add(new Question("In decision nodes, what does hi pointer represent?", new String[] {"False", "True"}, 1,1));
		
		csFoundationsIntermediateQuestions = new ArrayList<>();
		csFoundationsIntermediateQuestions.add(new Question("In BDDs, if you have n variables, how many decision nodes do you have?", new String[] {"2^n","2^(n-1)","2^n-1"},2,2));
		csFoundationsIntermediateQuestions.add(new Question("What does Equivalence relation hold?", new String[] {"Reflexivity, Symmetry and Equality", "Reflexivity, Symmetry and Transitivity", "Reflexivity, Antisymmetry and Transitivity"},1,2));
		
		csFoundationsExpertQuestions = new ArrayList<>();
		csFoundationsExpertQuestions.add(new Question("How would you represent binary integers using <integer> and <digit> (you define it as <integer>?",
				"(<integer> ::= <digit><integer> | <digit>\r\n <digit> ::= 0 | 1)", 3));
		csFoundationsExpertQuestions.add(new Question("nene", "dada", 3));
		
		
		
		
		}
	
	//method for displaying the questions
	public static List<Question> display(String difficulty){
		
		String[] howHard = {"Novice", "Intermediate", "Expert", "All questions"};
        //String selected = (String) JOptionPane.showInputDialog(null, "Choose the difficulty level:", "Difficulty Level", JOptionPane.QUESTION_MESSAGE, null, howHard, howHard[0]);
		//if (howHard.equals("Novice")) 
		String selectedD = (String) JOptionPane.showInputDialog(
		        null, "Choose the difficulty level:", "Difficulty Level",
		        JOptionPane.QUESTION_MESSAGE, null, howHard, howHard[0]);
        
        List<Question> selectedQ = new ArrayList<>();
        //while (howHard != null) {
            // Load questions based on selected difficulty level
            //List<Question> questions = loadQuestions(howHard);
            
            //if (questions == null || questions.isEmpty()) {
                //System.out.println("No questions available for the selected difficulty.");
                //return;
            //}
            
           
        //}
        
        //questions separated in cases based on difficulty option 
        switch (difficulty) {
        case "Novice":
        	selectedQ.addAll(csFoundationsNoviceQuestions);
        	selectedQ.addAll(compOrgNoviceQuestions);
        	selectedQ.addAll(mathNoviceQuestions);
        	break;
        
        case "Intermediate":
        	selectedQ.addAll(mathIntermediateQuestions);
        	selectedQ.addAll(csFoundationsIntermediateQuestions);
        	selectedQ.addAll(compOrgIntermediateQuestions);
        	break;
        	
        case "Expert":
        	selectedQ.addAll(compOrgExpertQuestions);
        	selectedQ.addAll(csFoundationsExpertQuestions);
        	selectedQ.addAll(mathExpertQuestions);
        	break;
        	
        case "All questions":
        	selectedQ.addAll(csFoundationsNoviceQuestions);
        	selectedQ.addAll(compOrgNoviceQuestions);
        	selectedQ.addAll(mathNoviceQuestions);
        	selectedQ.addAll(mathIntermediateQuestions);
        	selectedQ.addAll(csFoundationsIntermediateQuestions);
        	selectedQ.addAll(compOrgIntermediateQuestions);
        	selectedQ.addAll(compOrgExpertQuestions);
        	selectedQ.addAll(csFoundationsExpertQuestions);
        	selectedQ.addAll(mathExpertQuestions);
        	break;
        
        default:
        	break;
        } 
        
        return selectedQ; 
        
		
		
		
	}
	
	public static List<Question> Random(List<Question> questionList) {
        // Select and shuffle random questions
        List<Question> selectedQuestions = new ArrayList<>(questionList);
        Collections.shuffle(selectedQuestions);
        return selectedQuestions;
	}
	
	
		
		
		
	
	
	   
		
}