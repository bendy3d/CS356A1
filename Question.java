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
public class Question {
    
    private String questionText;
    private boolean singleAns = false;

    public Question(String questionText, boolean singleAns) {
        this.questionText = questionText;
        this.singleAns = singleAns;
    }
    
    public String getQuestionText() {
        return questionText;
    }
    
    public boolean isSingleAns() {
        return singleAns;
    }
}
