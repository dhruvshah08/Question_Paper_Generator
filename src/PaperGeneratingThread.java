

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.List;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadLocalRandom;
import javax.swing.JOptionPane;

/**
 *
 * @author dhruv
 * This is a Callable returning boolean depending upon the success of the paper creation
 * It is called once the Prepare Paper button is clicked!
 */
public class PaperGeneratingThread implements Callable<Boolean>{
    Thread thread;
    PrintStream ofstream;
    static Thread noOfQtscalculatorThread;
    static String difficulty;
    static ExecutorService executorService;
    List<Future<List<Sub_Question>>> list;
    public PaperGeneratingThread(){
         list=new ArrayList<>();
    }
    @Override
    public Boolean call(){
        try{
            String fileName=Paper.getSubjectName();
            File f=new File(fileName+".txt");
            while(f.exists()){
                fileName= Paper.getSubjectName()+ThreadLocalRandom.current().nextInt();
                f=new File(fileName+".txt");
            }
            noOfQtscalculatorThread=new Thread(new CalculatingNumberOfQuestionsThread());
            noOfQtscalculatorThread.start();            
            noOfQtscalculatorThread.join();
            //working perfectly fine uptil now!
            executorService=Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
            for(Main_Question main_Question:Paper.getListOfMainQuestions()){
                Future<List<Sub_Question>> future=executorService.submit(new SelectingSubQuestionsThread(main_Question));
                list.add(future);
            }
            int counter=0,noOfSubQuestions=0;
            while(counter<Paper.getListOfMainQuestions().size()){
                Main_Question main_Question=Paper.getListOfMainQuestions().get(counter);//got main question
                for(Sub_Question sub_Question:list.get(counter).get()){//would get the list of subQuestions!
                   main_Question.addSubQuestion(sub_Question);
                   noOfSubQuestions++;
                }
                counter++;
            }
            executorService.shutdown();
            //now checking number of questions
            if(noOfSubQuestions !=Paper.getTotalNumberOfQuestions()){
                return false;
            }else{
            //code for file writing!
                ofstream=new PrintStream(new FileOutputStream(f));
                ofstream.println("Subject: " + Paper.getSubjectName());
                ofstream.println("Difficulty: " +Paper.getDifficulty());
                ofstream.println("Max Marks: " + Paper.getTotalMarks());
                ofstream.println("Time Allocated: " + Paper.getTime()+"hrs");
                for(Main_Question main_Question:Paper.getListOfMainQuestions()){
                    ofstream.println("");
                    ofstream.println("Q"+main_Question.getAllotedQuestionNumber()+". "+main_Question.getStatement()+"\t["+main_Question.getWeightagePerQuestion()+" x "+main_Question.getNoOfQuestions()+"]");
                    for(Integer questionNumber:main_Question.getMapOfSubquestions().keySet()){
                        ofstream.println("\t"+questionNumber+". "+main_Question.getSubQuestion(questionNumber).getStatement()+"\t"+"[ "+main_Question.getSubQuestion(questionNumber).getWeightage()+" ]");
                    }
                }
                ofstream.println("\n\n\t\t\t********END OF QUESTION PAPER HERE********");
                ofstream.println("\t\t\t\t\tALL THE BEST!");
                return true;
            }
        }catch(IOException|InterruptedException|ExecutionException e){
            return false;
        }
    }   
}

