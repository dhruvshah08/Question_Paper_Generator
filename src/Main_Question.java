
import java.util.Map;
import java.util.TreeMap;

/**
 *This class depicts the main questions
 * which would consist of a set of sub questions!
 * @author dhruv
 * his class is a subclass of Question class
 * It represents the main question that the user has created
 * It holds the map of subquestions in it as well!
 */
public class Main_Question extends Question{
    private String statement;
    private int totalWeightage,weightagePerQuestion,noOfQuestions,questionNumber;
    private int subQuestionCount=0;
    private Map<Integer,Sub_Question> mapOfSubQuestions=new TreeMap<>();
    public Main_Question(String statement,int weightagePerQuestion,int noOfQuestions,int questionNumber) {
        super(statement,(weightagePerQuestion*noOfQuestions));
        super.allotQuestionNumber(questionNumber);
        this.weightagePerQuestion=weightagePerQuestion;
        this.questionNumber=questionNumber;
        this.noOfQuestions=noOfQuestions;
        this.totalWeightage=weightagePerQuestion*noOfQuestions;
    }
    public int getNoOfQuestions(){
        return this.noOfQuestions;
    }
    public int getWeightagePerQuestion(){
        return this.weightagePerQuestion;
    }
    public void setWeightagePerQuestion(int weightagePerQuestion){
        this.weightagePerQuestion=weightagePerQuestion;
    }
    public void setNoOfQuestions(int noOfQuestions){
        this.noOfQuestions=noOfQuestions;
    }
    public void addSubQuestion(Sub_Question subQuestion){
        this.subQuestionCount++;
        this.mapOfSubQuestions.put(subQuestionCount,subQuestion);
    }
    public Sub_Question getSubQuestion(int question_number){
        return this.mapOfSubQuestions.get(question_number);
    }
    public Map<Integer,Sub_Question> getMapOfSubquestions(){
        return new TreeMap<>(this.mapOfSubQuestions);
    }
    public void clearList(){
        this.mapOfSubQuestions.clear();
    }
    public boolean isQuestionAdded(String statement){
        Sub_Question subQuestion=getSubQuestionByStatement(statement);
        return this.mapOfSubQuestions.containsValue(subQuestion);
    }
    public Sub_Question getSubQuestionByStatement(String statement){
        for(Sub_Question sub_question:this.mapOfSubQuestions.values()){
            if(sub_question.getStatement().equals(statement)){
                return sub_question;
            }
        }
        return null;
    }
}
