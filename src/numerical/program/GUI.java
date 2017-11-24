/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package numerical.program;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.util.Pair;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import numerical.program.methods.tools.QuestionHolder;
import numerical.program.methods.tools.Table;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

/**
 *
 * @author Mohamed Nagy
 */
public class GUI extends javax.swing.JFrame {

    private File file;
    private QuestionHolder questionHolder;
    /**
     * Creates new form GUI
     */
    public GUI() {
        initComponents();

    }

    private void handlingFile() throws IOException, InvalidFormatException{
        logField.setText("aa");

        LogField log = new LogField(1, this.logField);
        ExcelFile ef = new ExcelFile(new File("C:\\Users\\Mohamed Nagy\\Desktop\\data.xlsx"));
        Pair<Double[], Double[]> data = ef.readFile();
       
        Table table = new Table(data.getKey(), data.getValue());
        questionHolder = new QuestionHolder(table);
        
        if(questionHolder.getTable().tableType() == Table.EQUAL_TABLE){
            originalRadioButton.setEnabled(true);
            inverseRadioButton.setEnabled(true);
            log.addMessage(LogField.FILE_IMPORT_SUCCESS, file.getAbsolutePath());
        }else{
            log.addMessage(LogField.FILE_IMPORT_CANCEL, file.getAbsolutePath());
            originalRadioButton.setEnabled(true);
        }
        
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        importFileLabel = new javax.swing.JLabel();
        originalRadioButton = new javax.swing.JRadioButton();
        inverseRadioButton = new javax.swing.JRadioButton();
        iterationCheckbox = new javax.swing.JCheckBox();
        newtonForwardCheckbox = new javax.swing.JCheckBox();
        lagrangeCheckbox = new javax.swing.JCheckBox();
        trunctionErrorCheckbox = new javax.swing.JCheckBox();
        exactApproximateErrorCheckbox = new javax.swing.JCheckBox();
        newtonErrorCheckbox = new javax.swing.JCheckBox();
        newtonBackwardCheckbox = new javax.swing.JCheckBox();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        logField = new javax.swing.JTextArea();
        progressBar = new javax.swing.JProgressBar();
        startButton = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        importFileButton = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel6 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Numerical");
        setBackground(new java.awt.Color(255, 51, 51));
        setBounds(new java.awt.Rectangle(0, 0, 5, 5));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setResizable(false);

        jPanel1.setBackground(java.awt.SystemColor.controlLtHighlight);

        importFileLabel.setFont(new java.awt.Font("Times New Roman", 1, 11)); // NOI18N
        importFileLabel.setForeground(new java.awt.Color(50, 208, 138));
        importFileLabel.setText("File Name");

        buttonGroup1.add(originalRadioButton);
        originalRadioButton.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        originalRadioButton.setForeground(new java.awt.Color(0, 197, 202));
        originalRadioButton.setText("Original ");
        originalRadioButton.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        originalRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                originalRadioButtonActionPerformed(evt);
            }
        });

        buttonGroup1.add(inverseRadioButton);
        inverseRadioButton.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        inverseRadioButton.setForeground(new java.awt.Color(0, 197, 202));
        inverseRadioButton.setText("Inverse");
        inverseRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inverseRadioButtonActionPerformed(evt);
            }
        });

        iterationCheckbox.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        iterationCheckbox.setForeground(new java.awt.Color(0, 197, 202));
        iterationCheckbox.setText("Iteration");
        iterationCheckbox.setEnabled(false);

        newtonForwardCheckbox.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        newtonForwardCheckbox.setForeground(new java.awt.Color(0, 197, 202));
        newtonForwardCheckbox.setText("Newton Forward");
        newtonForwardCheckbox.setEnabled(false);
        newtonForwardCheckbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newtonForwardCheckboxActionPerformed(evt);
            }
        });

        lagrangeCheckbox.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lagrangeCheckbox.setForeground(new java.awt.Color(0, 197, 202));
        lagrangeCheckbox.setText("Lagrange");
        lagrangeCheckbox.setEnabled(false);

        trunctionErrorCheckbox.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        trunctionErrorCheckbox.setForeground(new java.awt.Color(0, 197, 202));
        trunctionErrorCheckbox.setText("Trunction Error");
        trunctionErrorCheckbox.setEnabled(false);

        exactApproximateErrorCheckbox.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        exactApproximateErrorCheckbox.setForeground(new java.awt.Color(0, 197, 202));
        exactApproximateErrorCheckbox.setText("Exact Approximate Error");
        exactApproximateErrorCheckbox.setEnabled(false);

        newtonErrorCheckbox.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        newtonErrorCheckbox.setForeground(new java.awt.Color(0, 197, 202));
        newtonErrorCheckbox.setText("Newton Error");
        newtonErrorCheckbox.setEnabled(false);

        newtonBackwardCheckbox.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        newtonBackwardCheckbox.setForeground(new java.awt.Color(0, 197, 202));
        newtonBackwardCheckbox.setText("Newton Backward");
        newtonBackwardCheckbox.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        newtonBackwardCheckbox.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        newtonBackwardCheckbox.setEnabled(false);
        newtonBackwardCheckbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newtonBackwardCheckboxActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("MS Reference Sans Serif", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(50, 208, 138));
        jLabel4.setText("Error:");

        logField.setColumns(20);
        logField.setRows(5);
        jScrollPane1.setViewportView(logField);

        startButton.setBackground(new java.awt.Color(255, 255, 255));
        startButton.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        startButton.setForeground(new java.awt.Color(0, 186, 212));
        startButton.setText("Start");
        startButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(255, 255, 102), new java.awt.Color(255, 69, 224), new java.awt.Color(255, 51, 51), new java.awt.Color(51, 51, 255)));
        startButton.setBorderPainted(false);
        startButton.setEnabled(false);

        jLabel5.setFont(new java.awt.Font("MS Reference Sans Serif", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(50, 208, 138));
        jLabel5.setText("Settings:");

        importFileButton.setBackground(new java.awt.Color(255, 255, 255));
        importFileButton.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        importFileButton.setForeground(new java.awt.Color(0, 186, 212));
        importFileButton.setText("Import File");
        importFileButton.setActionCommand("");
        importFileButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(255, 255, 102), new java.awt.Color(255, 69, 224), new java.awt.Color(255, 51, 51), new java.awt.Color(51, 51, 255)));
        importFileButton.setBorderPainted(false);
        importFileButton.setEnabled(false);
        importFileButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                importFileButtonMouseClicked(evt);
            }
        });
        importFileButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                importFileButtonActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("MS Reference Sans Serif", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(50, 208, 138));
        jLabel6.setText("Technique");

        jTextField1.setForeground(new java.awt.Color(71, 134, 215));
        jTextField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField1.setText("0");
        jTextField1.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(50, 208, 138)));
        jTextField1.setCaretColor(new java.awt.Color(238, 14, 14));
        jTextField1.setEnabled(false);
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jTextField2.setForeground(new java.awt.Color(71, 134, 215));
        jTextField2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField2.setText("0");
        jTextField2.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(50, 208, 138)));
        jTextField2.setCaretColor(new java.awt.Color(238, 14, 14));
        jTextField2.setEnabled(false);
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(newtonBackwardCheckbox)
                                    .addComponent(exactApproximateErrorCheckbox)
                                    .addComponent(lagrangeCheckbox)
                                    .addComponent(trunctionErrorCheckbox))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(47, 47, 47)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(iterationCheckbox)
                                            .addComponent(newtonForwardCheckbox)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(45, 45, 45))))
                            .addComponent(newtonErrorCheckbox)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(originalRadioButton)
                        .addGap(47, 47, 47)
                        .addComponent(inverseRadioButton)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(importFileLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(importFileButton, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(10, 10, 10))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(progressBar, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(startButton, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(importFileButton, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(importFileLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 7, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inverseRadioButton)
                    .addComponent(originalRadioButton))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSeparator3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 7, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(newtonForwardCheckbox)
                    .addComponent(newtonBackwardCheckbox, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lagrangeCheckbox)
                    .addComponent(iterationCheckbox))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 7, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(newtonErrorCheckbox)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(exactApproximateErrorCheckbox)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(16, 16, 16)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField2, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
                            .addComponent(trunctionErrorCheckbox))
                        .addGap(36, 36, 36)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22)
                        .addComponent(progressBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(startButton, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 1, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void newtonForwardCheckboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newtonForwardCheckboxActionPerformed
        // TODO add your handling code here:
        exactApproximateErrorCheckbox.setEnabled(true);
        trunctionErrorCheckbox.setEnabled(true);
        newtonErrorCheckbox.setEnabled(true);
    }//GEN-LAST:event_newtonForwardCheckboxActionPerformed

    private void importFileButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_importFileButtonActionPerformed
        
    }//GEN-LAST:event_importFileButtonActionPerformed

    private void importFileButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_importFileButtonMouseClicked
        // TODO add your handling code here:
        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Excel files","xlsx","excel");       
        fileChooser.setFileFilter(filter);
        fileChooser.setFileSelectionMode(fileChooser.FILES_AND_DIRECTORIES);
        fileChooser.setDialogTitle("Import File");
        
        int result = fileChooser.showOpenDialog(jPanel1);
        
        if(result == JFileChooser.APPROVE_OPTION ){
            file = fileChooser.getSelectedFile();
            importFileLabel.setText(file.getName());
            progressBar.setValue(0);
            try {
            // TODO add your handling code here:
                handlingFile();
            } catch (IOException ex) {
                Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InvalidFormatException ex) {
                Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else if(file == null){
            importFileLabel.setText("No file is selected");
        }
        
    }//GEN-LAST:event_importFileButtonMouseClicked

    private void originalRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_originalRadioButtonActionPerformed
        // TODO add your handling code here:
        iterationCheckbox.setEnabled(false);
        iterationCheckbox.setSelected(false);
        lagrangeCheckbox.setEnabled(true);
        newtonForwardCheckbox.setEnabled(true);
        newtonBackwardCheckbox.setEnabled(true);
    }//GEN-LAST:event_originalRadioButtonActionPerformed

    private void inverseRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inverseRadioButtonActionPerformed
        // TODO add your handling code here:
        iterationCheckbox.setEnabled(true);
        lagrangeCheckbox.setEnabled(true);
        newtonForwardCheckbox.setEnabled(false);
        newtonForwardCheckbox.setSelected(false);
        newtonBackwardCheckbox.setEnabled(false);
        newtonBackwardCheckbox.setSelected(false);
    }//GEN-LAST:event_inverseRadioButtonActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void newtonBackwardCheckboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newtonBackwardCheckboxActionPerformed
        // TODO add your handling code here:
        exactApproximateErrorCheckbox.setEnabled(true);
        trunctionErrorCheckbox.setEnabled(true);
        newtonErrorCheckbox.setEnabled(true);
    }//GEN-LAST:event_newtonBackwardCheckboxActionPerformed

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
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JCheckBox exactApproximateErrorCheckbox;
    private javax.swing.JButton importFileButton;
    private javax.swing.JLabel importFileLabel;
    private javax.swing.JRadioButton inverseRadioButton;
    private javax.swing.JCheckBox iterationCheckbox;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JCheckBox lagrangeCheckbox;
    private javax.swing.JTextArea logField;
    private javax.swing.JCheckBox newtonBackwardCheckbox;
    private javax.swing.JCheckBox newtonErrorCheckbox;
    private javax.swing.JCheckBox newtonForwardCheckbox;
    private javax.swing.JRadioButton originalRadioButton;
    private javax.swing.JProgressBar progressBar;
    private javax.swing.JButton startButton;
    private javax.swing.JCheckBox trunctionErrorCheckbox;
    // End of variables declaration//GEN-END:variables
}
