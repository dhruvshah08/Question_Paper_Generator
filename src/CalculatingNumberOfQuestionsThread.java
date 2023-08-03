/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author dhruv
 * This class is a Thread
 * This thread is used to calculate the number of Main Questions in the Paper
 * The execution of the SelectingSubQuestionsThread begins only once the complete execution of this thread is done!
 */
public class CalculatingNumberOfQuestionsThread implements Runnable{
    int totalNoOfQuestions=0;
    @Override
    public void run(){
        for(Main_Question main_Question:Paper.getListOfMainQuestions()){
            totalNoOfQuestions+=main_Question.getNoOfQuestions();
        }
        Paper.setTotalNumberOfQuestions(totalNoOfQuestions);
        System.out.println(totalNoOfQuestions);
    }
}
