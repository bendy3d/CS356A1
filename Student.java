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
public class Student {
    
    private int id;
    private Random dice = new Random();
    
    
    public Student(int id) {
        this.id = id;
    }
    
    public int getID() {
        return id;
    }
    
    public int[] generateAnswers(int numOfChoices) {
        int numOfAnswers = dice.nextInt(numOfChoices) + 1;
        int[] submission = new int[numOfAnswers];
        boolean[] used = new boolean[numOfChoices];
        
        for (int i = 0; i < submission.length; i++) {
            int choice = dice.nextInt(numOfChoices); 
            if (used[choice]) {
                i--;
            }
            used[choice] = true;
            submission[i] = choice;
        }
        
        return submission;
    }
    
    public int generateAnswer(int numOfChoices) {
        int submission = dice.nextInt(numOfChoices);
        
        return submission;
    }
}
