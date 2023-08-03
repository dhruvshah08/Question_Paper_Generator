
import com.sun.javafx.css.converters.ColorConverter;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;


/**
 *
 * @author dhruvshah619
 * This class represents the Login form which is used for the user to login if they have already created an account
 */
public class Login extends javax.swing.JFrame {
    public static String username,password;
    /**
     * Creates new form Login
     */
    public Login() {
        initComponents();
//        Dimension dimension1=Toolkit.getDefaultToolkit().getScreenSize();
//        setLocation(dimesion1.width/2,dimesion1.height/2);
//        txtTimePass.setBorder(BorderFactory.createCompoundBorder(txtTimePass.getBorder(),BorderFactory.createEmptyBorder(5,5,5,5));
//        
//        try{
//          stmt=conn.createStatement();   
//        }catch(SQLException ex){
//          JOptionPane.showMessageDialog(null, "Problem while creating Statement Object!");  
//        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        txtUsername = new javax.swing.JTextField();
        sepUsername = new javax.swing.JSeparator();
        txtPassword = new javax.swing.JPasswordField();
        sepPassword = new javax.swing.JSeparator();
        lblSubmit = new javax.swing.JLabel();
        lblSignUpOpt = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/annie-spratt-5cFwQ-WMcJU-unsplash.jpg"))); // NOI18N

        jPanel1.setBackground(new java.awt.Color(245, 234, 186));

        txtUsername.setBackground(new java.awt.Color(245, 234, 186));
        txtUsername.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 18)); // NOI18N
        txtUsername.setForeground(new java.awt.Color(102, 102, 102));
        txtUsername.setText("Username");
        txtUsername.setBorder(null);
        txtUsername.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtUsernameFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtUsernameFocusLost(evt);
            }
        });

        sepUsername.setForeground(new java.awt.Color(146, 134, 84));

        txtPassword.setBackground(new java.awt.Color(245, 234, 186));
        txtPassword.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 18)); // NOI18N
        txtPassword.setBorder(null);

        sepPassword.setForeground(new java.awt.Color(146, 134, 84));

        lblSubmit.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 24)); // NOI18N
        lblSubmit.setForeground(new java.awt.Color(146, 134, 84));
        lblSubmit.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSubmit.setText("Login");
        lblSubmit.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lblSubmit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblSubmitMouseClicked(evt);
            }
        });

        lblSignUpOpt.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 14)); // NOI18N
        lblSignUpOpt.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblSignUpOpt.setText("Don't have an account? Sign Up!");
        lblSignUpOpt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblSignUpOptMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblSignUpOptMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblSignUpOptMouseExited(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setText("Password");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 84, Short.MAX_VALUE)
                        .addComponent(lblSignUpOpt, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtPassword, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(sepUsername)
                            .addComponent(sepPassword)
                            .addComponent(txtUsername)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(54, 54, 54)
                                .addComponent(lblSubmit, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sepUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sepPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblSubmit, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(lblSignUpOpt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(51, 51, 51))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lblSubmitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSubmitMouseClicked
        // TODO add your handling code here:
        String username = txtUsername.getText();
        String password = txtPassword.getText();
        if(Database_Operations.checkUser(username,password)){
            Login.username=username;
            Login.password=password;
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    new ChoosingSubject().setVisible(true);
                }
                });
            dispose();
        }
    }//GEN-LAST:event_lblSubmitMouseClicked

    private void lblSignUpOptMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSignUpOptMouseClicked
        // TODO add your handling code here:
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SignUp().setVisible(true);
            }
            });
            dispose();
    }//GEN-LAST:event_lblSignUpOptMouseClicked

    private void lblSignUpOptMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSignUpOptMouseEntered
        // TODO add your handling code here:
        lblSignUpOpt.setForeground(Color.DARK_GRAY);
    }//GEN-LAST:event_lblSignUpOptMouseEntered

    private void lblSignUpOptMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSignUpOptMouseExited
        // TODO add your handling code here:
        lblSignUpOpt.setForeground(Color.BLACK);
    }//GEN-LAST:event_lblSignUpOptMouseExited

    private void txtUsernameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtUsernameFocusGained
        // TODO add your handling code here:
        if("Username".equals(txtUsername.getText())){
         txtUsername.setText("");
         txtUsername.setForeground(Color.BLACK);
        }
    }//GEN-LAST:event_txtUsernameFocusGained

    private void txtUsernameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtUsernameFocusLost
        // TODO add your handling code here:
        if("".equals(txtUsername.getText())){
            txtUsername.setText("Username");
             txtUsername.setForeground(Color.DARK_GRAY);
        }
    }//GEN-LAST:event_txtUsernameFocusLost

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblSignUpOpt;
    private javax.swing.JLabel lblSubmit;
    private javax.swing.JSeparator sepPassword;
    private javax.swing.JSeparator sepUsername;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
