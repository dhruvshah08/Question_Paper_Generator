
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author dhruv
 * This class is used to implement database functionalities
 */
public class Database_Operations {
    static PreparedStatement ps;
    static Connection conn;
    static ResultSet rs;
    static 
    {
        conn=MySQLConnect.getConnection();
    }
     //INSERT A QUESTION INTO QB
    public static boolean insertSub(Sub_Question sub_Question){
        try{
            String subject=Paper.getSubjectName();
            String statement=sub_Question.getStatement();
            int weightage=sub_Question.getWeightage();
            String difficulty=sub_Question.getDifficulty();
            String sql="SELECT * FROM "+subject + " WHERE statement=? AND weightage=? AND difficulty=?";
            ps=conn.prepareStatement(sql);
            ps.setString(1,statement);
            ps.setString(2,difficulty);
            ps.setInt(3,weightage);
            rs=ps.executeQuery();
            if(!rs.next()){
                sql="INSERT INTO "+subject+"(statement,difficulty,weightage) VALUES (?,?,?)";
                ps=conn.prepareStatement(sql);
                ps.setString(1,statement);
                ps.setString(2,difficulty);
                ps.setInt(3,weightage); 
                ps.execute();
                return true;
            }else{
                JOptionPane.showMessageDialog(null, "Question already exists!");
                return false;
            }
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
            return false;
        }
    }
     //UPDATE A QUESTION FROM QB
    public static boolean updateSub(Sub_Question sub_Question){
        String subject=Paper.getSubjectName();
        String sql="UPDATE "+subject+" set statement=?,weightage=?,difficulty=? WHERE question_number=?";
        try{
            ps=conn.prepareStatement(sql);
            ps.setString(1,sub_Question.getStatement());
            ps.setInt(2,sub_Question.getWeightage());
            ps.setString(3,sub_Question.getDifficulty());
            ps.setInt(4,sub_Question.getAllotedQuestionNumber());
            ps.execute();
            return true;
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
            return false;
        }
    }
    //DELETE A QUESTION FROM QB
    public static boolean deleteSub(int question_number){
        String subject=Paper.getSubjectName();
        String sql="DELETE FROM "+subject+" WHERE question_number= ?";
            try{
                ps=conn.prepareStatement(sql);
                ps.setInt(1,question_number);
                ps.execute();
                return true;
            }catch(SQLException e){
                JOptionPane.showMessageDialog(null, e.getMessage());
                return false;
            }
    }
    private static DefaultTableModel getMyTableModel(TableModel dtm,String arr[]){
        int nRow = dtm.getRowCount();
        int nCol = dtm.getColumnCount();
        
        Object[][] tableData = new Object[nRow][nCol];
        for(int i = 0; i<nRow; i++){
            for(int j=0; j<nCol; j++){
                tableData[i][j] = dtm.getValueAt(i, j);
            }
        }
        String[] colHeads = arr;
        DefaultTableModel myModel = new DefaultTableModel(tableData, colHeads){
            @Override
            public boolean isCellEditable(int row, int col){
                return false;
            }
        };
        return myModel;
    }
    private static void updateTableData(String sql,int condition,JTable jTableData,String arr[]){   
        try{
            ps = conn.prepareStatement(sql);
            ps.setInt(1, condition);
            rs = ps.executeQuery();
            jTableData.setModel(getMyTableModel(DbUtils.resultSetToTableModel(rs),arr));
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Issue Here is: " + e.getMessage());
        }
    }
    //REFRESH THE TABLE DISPLAYING THE QUESTIONS OF THE QUESTION BANK
     private static void updateTableData(String sql,JTable jTableData,String arr[]){   
        try{
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            jTableData.setModel(getMyTableModel(DbUtils.resultSetToTableModel(rs),arr));
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Issue Here is: " + e.getMessage());
        }
    }
     //REFRESH THE TABLE DISPLAYING THE QUESTIONS OF THE QUESTION BANK
    public static void refreshAdminDashboard(String username,JTable jTableData){
        String subject=Paper.getSubjectName();
        String sql="SELECT * FROM "+subject;
        String[] colHeads = {"Question Number","Statement", "Difficulty", "Weightage"};
        updateTableData(sql,jTableData,colHeads);
    }
    //INSERT NEW SUBJECT
    public static boolean addSubject(String username,int subjectId,String subjectName){
        try{
            //check if subject id hasnt been added yet!
            String check="SELECT * FROM "+username+" WHERE subject_id="+subjectId;
            ps=conn.prepareStatement(check);
            rs=ps.executeQuery();
            if(!rs.next()){
                String sql="INSERT into "+username+" VALUES(?,?)";
                ps=conn.prepareStatement(sql);
                ps.setInt(1, subjectId);
                ps.setString(2, subjectName);
                ps.execute();
                String subject=subjectName+"_"+subjectId;
                sql="CREATE TABLE "+subject+"(question_number int AUTO_INCREMENT PRIMARY KEY,statement varchar(100),difficulty varchar(25),weightage int)";
                ps = conn.prepareStatement(sql);
                ps.execute();
                return true;
            }else{
                JOptionPane.showMessageDialog(null, "Subject-ID already exists!");
            }
            return false;
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
            return false;
        }
    }
    //FILL THE LIST WITH SUBJECTS OF WHOSE PAPER HAS BEEN MADE!
    public static List<String> fillComboBoxWithSubjects(String username){
        String sql="SELECT * from "+username;
        List<String> list=new ArrayList<>();
        try{
            ps=conn.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                String subjectName=rs.getString("subject_name");
                int subjectId=rs.getInt("subject_id");
                String subject=subjectName+"_"+subjectId;
                list.add(subject);
            }
            return list;
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
            return list;
        }
    }
    //SIGN-UP CONDITION
    public static boolean insertUser(String username,String password){
       try{
            String sql = "SELECT * FROM user WHERE username = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            ps.executeQuery();
            rs = ps.executeQuery();
            //check if username
            if(rs.next()){
                JOptionPane.showMessageDialog(null, "Username already exists!");
                return false;
            }else{
                String sql1="INSERT into user VALUES (?,?)";
                ps = conn.prepareStatement(sql1);
                ps.setString(1, username);
                ps.setString(2, password);
                ps.execute();
                sql1="CREATE TABLE "+username+"(subject_id int,subject_name varchar(100))";
                ps = conn.prepareStatement(sql1);
                ps.execute();
                return true;
            }      
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
            return false;
        } 
    }
    //LOGIN CONDITION
    public static boolean checkUser(String username,String password){
        try{    
            String sql = "SELECT * FROM user WHERE username = ? AND password = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            ps.executeQuery();
            rs = ps.executeQuery();
            //always load the UIi not in the main thread but in a seperate thread as the main thread must be as light as possible
            if(rs.next()){
                return true;
            }else{
                JOptionPane.showMessageDialog(null, "Wrong Username/Password");
                return false;
            }      
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
            return false;
        }
    }
}
