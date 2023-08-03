

/**
 * Represents sub questions contained within each main question
 * @author dhruv
 * This class is a subclass of Question class
 * It represents the sub question that the user has created
 */
public class Sub_Question extends Question{
    private String statement,difficulty;
    private int weightage;
    public Sub_Question(String statement, int weightage,String difficulty) {
        super(statement,weightage);
        this.difficulty=difficulty;
    }
    public String getDifficulty(){
        return this.difficulty;
    }
}
