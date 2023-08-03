
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author dhruv
 * This class denotes the paper that would be generated
 * It holds all the details of the paper format as well consisting of the subject name,difficulty level and time allocated
 * It also holds the total marks and the setOfMainQuestions that consists of all the main questions 
 */
public class Paper {
    static String subject_name,difficulty,time;
    static int totalMarks;
    static List<Main_Question> setOfMainQuestions=new LinkedList<>();
    static int totalNumberOfQuestions;
    public Paper(String subject_name,int totalMarks,String difficulty,String time){
        this.subject_name=subject_name;
        this.totalMarks=totalMarks;
        this.time=time;
        this.difficulty=difficulty;
    }
    public static String getSubjectName(){
        return subject_name;
    }
    public static String getTime(){
        return time;
    }
    public static int getTotalMarks(){
        return totalMarks;
    }
    public static String getDifficulty(){
        return difficulty;
    }
    public static int getTotalNumberOfQuestions(){
        return totalNumberOfQuestions;
    }
    public static void setSubjectName(String subjectName){
        subject_name=subjectName;
    }
    public static void setTimeAllocated(String timeAllocated){
        time=timeAllocated;
    }
    public static void setDifficulty(String paperDifficulty){
        difficulty=paperDifficulty;
    }
    public static void setTotalMarks(int marks){
        totalMarks=marks;
    }
    public static List<Main_Question> getListOfMainQuestions(){
        return new ArrayList<>(setOfMainQuestions);
    }
    public static void setTotalNumberOfQuestions(int totalNoOfQuestions){
        totalNumberOfQuestions=totalNoOfQuestions;
    }
    public static void addMainQuestion(Main_Question mainQuestion){
        setOfMainQuestions.add(mainQuestion);
    }
    public static void removeMainQuestion(Main_Question mainQuestion){
        setOfMainQuestions.remove(mainQuestion);
    }
    public static void removeMainQuestionByNumber(int questionNumber){
        Main_Question mainQuestion=getMainQuestionByNumber(questionNumber);
        if(mainQuestion!=null)
            setOfMainQuestions.remove(mainQuestion);
    }
    public static boolean isQuestionAdded(String statement){
        Main_Question mainQuestion=getMainQuestionByStatement(statement);
        if(mainQuestion!=null){
            return true;
        }
        return false;
    }
    public static boolean isQuestionAdded(int questionNumber){
        Main_Question mainQuestion=getMainQuestionByNumber(questionNumber);
        if(mainQuestion!=null){
            return true;
        }
        return false;
    }
    public static Main_Question getMainQuestionByStatement(String statement){
        for(Main_Question main_question:setOfMainQuestions){
            if(main_question.getStatement().equals(statement)){
                return main_question;
            }
        }
        return null;
    }
    public static Main_Question getMainQuestionByNumber(int questionNumber){
        for(Main_Question main_question:setOfMainQuestions){
            if(main_question.getAllotedQuestionNumber() == questionNumber){
                return main_question;
            }
        }
        return null;
    }
    
}
