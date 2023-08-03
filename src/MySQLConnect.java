
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 * @author dhruvshah619
 * This class is used for the initial connection to the database
 */
public class MySQLConnect {
    private static final String CONNECTION_STRING="jdbc:mysql://localhost:3306/auto_paper_gen";
    //                                                                  portno/database_name
    private static final String USERNAME="dhruv";
    private static final String PASSWORD="dhruv";
    /**
     * @return
     * returns a valid Connection to employee_management DB if it can,otherwise it returns null.
     */
    
    public static Connection getConnection(){
        Connection conn=null;
        try{
            conn=DriverManager.getConnection(CONNECTION_STRING,USERNAME,PASSWORD);
        }
        catch(SQLException se){
            JOptionPane.showMessageDialog(null,"Connection Failed:"+se.getMessage());
        }
        return conn;
    }
}
