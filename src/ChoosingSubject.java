
import java.awt.event.ItemEvent;
import java.util.List;
import javax.swing.DefaultListModel;


/**
 *
 * @author dhruv
 * This class represents the ChoosingSubject form
 * This would be displayed exactly  after the user has logged/signed in
 * If the user has already added subjects,they would be loaded first
 * The user can also update the question bank of the chosen subject by choosing the subject from the list
 * The user can also add a new subject
 */
public class ChoosingSubject extends javax.swing.JFrame {
    String selectedItem="";
    DefaultListModel<String> dm1;
    List<String> list;
    /**
     * Creates new form ChoosingSubject
     */
    public ChoosingSubject() {
        dm1=new DefaultListModel<>();
        list=Database_Operations.fillComboBoxWithSubjects(Login.username);
        for(String subject:list){
            dm1.addElement(subject);
        }
        initComponents();
        btnUpdateQB.setEnabled(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnNewSubject = new javax.swing.JButton();
        btnUpdateQB = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        listOfSubjects = new javax.swing.JList<>(dm1);
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(245, 234, 186));

        btnNewSubject.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnNewSubject.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/new-icon.png"))); // NOI18N
        btnNewSubject.setText("New Subject");
        btnNewSubject.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewSubjectActionPerformed(evt);
            }
        });

        btnUpdateQB.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnUpdateQB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/update.png"))); // NOI18N
        btnUpdateQB.setText("Update QB");
        btnUpdateQB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateQBActionPerformed(evt);
            }
        });

        listOfSubjects.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        listOfSubjects.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        listOfSubjects.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listOfSubjectsValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(listOfSubjects);

        jLabel1.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setText("My Subjects");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(100, 100, 100)
                                .addComponent(btnUpdateQB))
                            .addComponent(jScrollPane2))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnNewSubject)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnUpdateQB)
                    .addComponent(jLabel1))
                .addGap(20, 20, 20)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 477, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnNewSubject, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnUpdateQBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateQBActionPerformed
        // TODO add your handling code here:
        //set Papers subject to selected item;
        Paper.setSubjectName(selectedItem);//setting the papers subject to the selected item!
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Admin_DashBoard().setVisible(true);
            }
        });
        dispose();
    }//GEN-LAST:event_btnUpdateQBActionPerformed

    private void btnNewSubjectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewSubjectActionPerformed
        // TODO add your handling code here:
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new New_Subject().setVisible(true);
            }
        });
        dispose();
    }//GEN-LAST:event_btnNewSubjectActionPerformed

    private void listOfSubjectsValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listOfSubjectsValueChanged
        // TODO add your handling code here:
        if("".equals(selectedItem)){
            btnUpdateQB.setEnabled(true);
        }
        selectedItem=listOfSubjects.getSelectedValue();
        Paper.setSubjectName(selectedItem);
    }//GEN-LAST:event_listOfSubjectsValueChanged

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
            java.util.logging.Logger.getLogger(ChoosingSubject.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ChoosingSubject.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ChoosingSubject.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ChoosingSubject.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnNewSubject;
    private javax.swing.JButton btnUpdateQB;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList<String> listOfSubjects;
    // End of variables declaration//GEN-END:variables
}
