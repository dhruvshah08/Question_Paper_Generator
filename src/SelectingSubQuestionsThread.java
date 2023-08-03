
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author dhruv
 * This class is a Callable returning a List of subquestions
 * It is implementation is done to randomly chose the questions from the db according to the constraints defined
 */
public class SelectingSubQuestionsThread implements Callable<List<Sub_Question>>{
    Thread thread;
    String difficulty;
    int numberOfQuestions,weightage;
    PreparedStatement ps;
    ResultSet rs;
    Connection conn;
    Sub_Question sub_Question;
    Main_Question main_Question;
    List<Sub_Question> listOfSubQuestions;
    List<Sub_Question> listOfSelectedSubQuestions;
    public SelectingSubQuestionsThread(Main_Question main_Question){
        this.main_Question=main_Question;
        conn=MySQLConnect.getConnection();
        listOfSubQuestions=new ArrayList<>();
        listOfSelectedSubQuestions=new ArrayList<>();
    }
    @Override
    public List<Sub_Question> call(){
        difficulty=Paper.difficulty;
        weightage=main_Question.getWeightagePerQuestion();
        numberOfQuestions=main_Question.getNoOfQuestions();
        String sql="Select statement,weightage,difficulty from "+Paper.getSubjectName()+" where difficulty=? and weightage=?";
        try{
            ps=conn.prepareStatement(sql);
            ps.setString(1,difficulty);
            ps.setInt(2,weightage);
            rs=ps.executeQuery();
            while(rs.next()){
                String statement=rs.getString("statement");
                sub_Question=new Sub_Question(statement, weightage, difficulty);
                listOfSubQuestions.add(sub_Question);
            }
            //now randomly selecting
            while(numberOfQuestions>0){
                int index=ThreadLocalRandom.current().nextInt(0,listOfSubQuestions.size());
                sub_Question=listOfSubQuestions.get(index);
                listOfSelectedSubQuestions.add(sub_Question);
                listOfSubQuestions.remove(sub_Question);
                numberOfQuestions--;
            }
            return listOfSelectedSubQuestions;
        }catch(SQLException e){
            return null;
        }
    }
}
