
/**
 * Base class of Main and Sub Question
 *
 * @author dhruv
 */
public class Question {
    private String statement;
    private int weightage;
    private int allocatedQuestionNumber;
    public Question(String statement,int weightage){
        this.statement=statement;
        this.weightage=weightage;
    }
    public void allotQuestionNumber(int allocatedQuestionNumber){
        this.allocatedQuestionNumber=allocatedQuestionNumber;
    }
    public int getAllotedQuestionNumber(){
    return this.allocatedQuestionNumber;
    }
    public String getStatement(){
        return this.statement;
    }
    public int getWeightage(){
        return this.weightage;
    }
    public void setStatement(String statement){
        this.statement=statement;
    }
    public void setWeightage(int weightage){
        this.weightage=weightage;
    }
}
