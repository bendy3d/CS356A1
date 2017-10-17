/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs356a1;

/**
 *
 * @author Ben
 */
public class iVoteService {
    
    private Question question;
    private String[] choices;
    private int[][] stAnswers;
    private int[] answerReport;
    
    public iVoteService (Question question, String[] choices, int numOfStudents) {
        this.question = question;
        this.choices = new String[choices.length];
        System.arraycopy(choices, 0, this.choices, 0, choices.length);
        stAnswers = new int[numOfStudents][choices.length];
        answerReport = new int[choices.length];
    }
    
    private void setChoices(String[] choices) {
        
    }
    
    public void acceptAnswer(int[] submission, int id) {
        System.arraycopy(submission, 0, stAnswers[id], 0, submission.length);
    }
    
    public void acceptAnswer(int submission, int id) {
        stAnswers[id][0] = submission;
    }
    
    public void generateAnswerReport() {
        for (int i = 0; i < stAnswers.length; i++) {
            boolean flag = false;
            for (int j = 0; j < stAnswers[i].length; j++) {
                int answerLoc = stAnswers[i][j];
                if ((!flag && (answerLoc == 0)) || (answerLoc != 0)) {
                    answerReport[answerLoc]++;
                }
                if (answerLoc == 0) {
                    flag = true;
                } 
            }
        }
    }
    
    public void printAnswerReport() {
        for (int i = 0; i < answerReport.length; i++) {
            System.out.println(choices[i] + ": " + answerReport[i]);
        }
    }
    
}
