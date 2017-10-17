/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs356a1;

import java.util.Random;

/**
 *
 * @author Ben
 */
public class SimulationDriver {

    private Random dice = new Random();
    
    private Student[] students;
    private iVoteService iVote;
    private Question question;
    private int numOfChoices;

    
    public SimulationDriver() {
       students = new Student[dice.nextInt(20) + 1];
       numOfChoices = dice.nextInt(4) + 2;
       generateStudents();
       question = generateQuestion(numOfChoices);
       String[] choices = generateChoices(numOfChoices);
       iVote = new iVoteService(question, choices, students.length);
    }
    
    public void runTest() {
        if (question.isSingleAns()) {
            for (int i = 0; i < students.length; i++) {
                iVote.acceptAnswer(students[i].generateAnswer(numOfChoices), students[i].getID());
            }
        } else {
            for (int i = 0; i < students.length; i++) {
                iVote.acceptAnswer(students[i].generateAnswers(numOfChoices), students[i].getID());
            }
        }
        
        iVote.generateAnswerReport();
        iVote.printAnswerReport();
    }
    
    private void generateStudents() {
        for (int i = 0; i < students.length; i++) {
               Student stu = new Student(i);
               students[i] = stu;
           }
    }
    
    private Question generateQuestion(int numOfChoices) {
        Question question;
        if (numOfChoices == 1) {
            question = new Question("This is a test question.", true);
        } else {
            question = new Question("This is a test question.", false);
        }
        return question;
    }
    
    private String[] generateChoices(int numOfChoices) {
        String[] choices = new String[numOfChoices];
        for (int i = 0; i < numOfChoices; i++) {
            choices[i] = "Answer " + (i+1);
        }
        return choices;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SimulationDriver sim = new SimulationDriver();
        sim.runTest();
    }
    
}
