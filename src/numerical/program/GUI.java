/*
 * Copyright 2017 Mohamed Nagy Mostafa Mohamed
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package numerical.program;

import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Util.println;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.util.Pair;
import javax.swing.JFileChooser;
import javax.swing.JFormattedTextField;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;
import methods.GThread;
import methods.ScheduleGThread;
import numerical.program.methods.Iteration;
import numerical.program.methods.Lagrange;
import numerical.program.methods.Mathematical;
import numerical.program.methods.Newton;
import numerical.program.methods.tools.Converter;
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
    private final Progress progress;
    /**
     * Creates new form GUI
     */
    public GUI() {
        initComponents();
        progress = new Progress(progressBar);
    }
  

    private void handlingFile(){
        final LogField log = new LogField(2, logField);
        initialState();
        new GThread<String>() {
            @Override
            public String onProgress() {
                try {
                    log.addMessage(LogField.READING_DATA);
                    progress.increaseBy(30);
                    ExcelFile excelFile = new ExcelFile(new File(file.getAbsolutePath()));
                    Pair<Double[], Double[]> data = excelFile.readFile();
                    progress.increaseBy(60);
                    Table table = new Table(data.getKey(), data.getValue());
                    progress.increaseBy(80);
                    questionHolder = new QuestionHolder(table);
                    
                    return excelFile.writeFile(questionHolder.getTable().getTableAsArrayList());
                } catch (IOException ex) {
                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InvalidFormatException ex) {
                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                }
                return LogField.FILE_CAN_NOT_IMPORT;
            }

            @Override
            public void onFinished(String filePath) {
                if(questionHolder.getTable().tableType() == Table.EQUAL_TABLE){
                    originalRadioButton.setEnabled(true);
                    inverseRadioButton.setEnabled(true);
                    log.addMessage(LogField.TABLE_TYPE_EQUAL);
                }else{
                    log.addMessage(LogField.TABLE_TYPE_INEQUAL);
                    originalRadioButton.setEnabled(true);
                }
                log.addMessage(LogField.TABLE_CREATED, filePath);
                progress.increaseBy(100);
                log.addMessage(LogField.READING_DATA_COMPLETED);
                
                originalRadioButton.setSelected(true);
                originalRadioButton.setEnabled(true);
                inverseRadioButton.setEnabled(true);
                originalProcess();
            }
        }.start();
        
    }
    
    private void checkErrorState(){
        newtonErrorCheckbox.setEnabled(newtonBackwardCheckbox.isSelected() || newtonForwardCheckbox.isSelected());
        exactApproximateErrorCheckbox.setEnabled(newtonErrorCheckbox.isEnabled() || lagrangeCheckbox.isSelected());
        trunctionErrorCheckbox.setEnabled((newtonErrorCheckbox.isEnabled() || exactApproximateErrorCheckbox.isEnabled()) & originalRadioButton.isSelected());
        iterationErrorPowerCheckbox.setEnabled(iterationCheckbox.isSelected());
        
        if(!newtonErrorCheckbox.isEnabled())
            newtonErrorCheckbox.setSelected(false);
        if(!exactApproximateErrorCheckbox.isEnabled())
            exactApproximateErrorCheckbox.setSelected(false);
        if(!trunctionErrorCheckbox.isEnabled())
            trunctionErrorCheckbox.setSelected(false);
        if(!iterationErrorPowerCheckbox.isEnabled())
            iterationErrorPowerCheckbox.setSelected(false);
        
        checkErrorSelection(exactApproximateEditText, exactApproximateErrorCheckbox.isSelected());
        checkErrorSelection(trunctionEditText, trunctionErrorCheckbox.isSelected());
        checkErrorSelection(iterationErrorPowerEditText, iterationErrorPowerCheckbox.isSelected());
        
    }
    
    private void checkErrorSelection(JTextField textField, boolean value){
        textField.setEnabled(value);
        if(!value)
            textField.setText("0");
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
        valueEditText = new javax.swing.JTextField();
        trunctionEditText = new javax.swing.JTextField();
        iterationErrorPowerEditText = new javax.swing.JTextField();
        iterationErrorPowerCheckbox = new javax.swing.JCheckBox();
        exactApproximateEditText = new javax.swing.JTextField();
        importFileLabel1 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

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
        originalRadioButton.setEnabled(false);
        originalRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                originalRadioButtonActionPerformed(evt);
            }
        });

        buttonGroup1.add(inverseRadioButton);
        inverseRadioButton.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        inverseRadioButton.setForeground(new java.awt.Color(0, 197, 202));
        inverseRadioButton.setText("Inverse");
        inverseRadioButton.setEnabled(false);
        inverseRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inverseRadioButtonActionPerformed(evt);
            }
        });

        iterationCheckbox.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        iterationCheckbox.setForeground(new java.awt.Color(0, 197, 202));
        iterationCheckbox.setText("Iteration");
        iterationCheckbox.setEnabled(false);
        iterationCheckbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                iterationCheckboxActionPerformed(evt);
            }
        });

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
        lagrangeCheckbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lagrangeCheckboxActionPerformed(evt);
            }
        });

        trunctionErrorCheckbox.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        trunctionErrorCheckbox.setForeground(new java.awt.Color(0, 197, 202));
        trunctionErrorCheckbox.setText("Trunction Error");
        trunctionErrorCheckbox.setEnabled(false);
        trunctionErrorCheckbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                trunctionErrorCheckboxActionPerformed(evt);
            }
        });

        exactApproximateErrorCheckbox.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        exactApproximateErrorCheckbox.setForeground(new java.awt.Color(0, 197, 202));
        exactApproximateErrorCheckbox.setText("Exact Approximate Error");
        exactApproximateErrorCheckbox.setEnabled(false);
        exactApproximateErrorCheckbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exactApproximateErrorCheckboxActionPerformed(evt);
            }
        });

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

        logField.setEditable(false);
        logField.setColumns(20);
        logField.setRows(5);
        logField.setFocusable(false);
        jScrollPane1.setViewportView(logField);

        startButton.setBackground(new java.awt.Color(255, 255, 255));
        startButton.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        startButton.setForeground(new java.awt.Color(0, 186, 212));
        startButton.setText("Start");
        startButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(255, 255, 102), new java.awt.Color(255, 69, 224), new java.awt.Color(255, 51, 51), new java.awt.Color(51, 51, 255)));
        startButton.setBorderPainted(false);
        startButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startButtonActionPerformed(evt);
            }
        });

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

        valueEditText.setForeground(new java.awt.Color(71, 134, 215));
        valueEditText.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        valueEditText.setText("0");
        valueEditText.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(50, 208, 138)));
        valueEditText.setCaretColor(new java.awt.Color(238, 14, 14));
        valueEditText.setEnabled(false);
        valueEditText.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                valueEditTextFocusGained(evt);
            }
        });
        valueEditText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                valueEditTextActionPerformed(evt);
            }
        });
        valueEditText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                valueEditTextKeyTyped(evt);
            }
        });

        trunctionEditText.setForeground(new java.awt.Color(71, 134, 215));
        trunctionEditText.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        trunctionEditText.setText("0");
        trunctionEditText.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(50, 208, 138)));
        trunctionEditText.setCaretColor(new java.awt.Color(238, 14, 14));
        trunctionEditText.setEnabled(false);
        trunctionEditText.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                trunctionEditTextFocusGained(evt);
            }
        });
        trunctionEditText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                trunctionEditTextActionPerformed(evt);
            }
        });
        trunctionEditText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                trunctionEditTextKeyTyped(evt);
            }
        });

        iterationErrorPowerEditText.setForeground(new java.awt.Color(71, 134, 215));
        iterationErrorPowerEditText.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        iterationErrorPowerEditText.setText("0");
        iterationErrorPowerEditText.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(50, 208, 138)));
        iterationErrorPowerEditText.setCaretColor(new java.awt.Color(238, 14, 14));
        iterationErrorPowerEditText.setEnabled(false);
        iterationErrorPowerEditText.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                iterationErrorPowerEditTextFocusGained(evt);
            }
        });
        iterationErrorPowerEditText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                iterationErrorPowerEditTextActionPerformed(evt);
            }
        });
        iterationErrorPowerEditText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                iterationErrorPowerEditTextKeyTyped(evt);
            }
        });

        iterationErrorPowerCheckbox.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        iterationErrorPowerCheckbox.setForeground(new java.awt.Color(0, 197, 202));
        iterationErrorPowerCheckbox.setText("Iteration Stop At 10 Power");
        iterationErrorPowerCheckbox.setEnabled(false);
        iterationErrorPowerCheckbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                iterationErrorPowerCheckboxActionPerformed(evt);
            }
        });

        exactApproximateEditText.setForeground(new java.awt.Color(71, 134, 215));
        exactApproximateEditText.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        exactApproximateEditText.setText("0");
        exactApproximateEditText.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(50, 208, 138)));
        exactApproximateEditText.setCaretColor(new java.awt.Color(238, 14, 14));
        exactApproximateEditText.setEnabled(false);
        exactApproximateEditText.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                exactApproximateEditTextFocusGained(evt);
            }
        });
        exactApproximateEditText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exactApproximateEditTextActionPerformed(evt);
            }
        });
        exactApproximateEditText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                exactApproximateEditTextKeyTyped(evt);
            }
        });

        importFileLabel1.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        importFileLabel1.setForeground(new java.awt.Color(50, 208, 138));
        importFileLabel1.setText("Value : ");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(50, 208, 138));
        jLabel1.setText("© mohamednagy2015@outlook.com");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(importFileLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(100, 100, 100)
                                        .addComponent(importFileButton, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(10, 10, 10))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(progressBar, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(93, 93, 93)
                        .addComponent(startButton, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(originalRadioButton)
                        .addGap(47, 47, 47)
                        .addComponent(inverseRadioButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(importFileLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(valueEditText, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(newtonBackwardCheckbox)
                                            .addComponent(exactApproximateErrorCheckbox)
                                            .addComponent(lagrangeCheckbox)
                                            .addComponent(trunctionErrorCheckbox))
                                        .addGap(47, 47, 47)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(iterationCheckbox)
                                            .addComponent(newtonForwardCheckbox)
                                            .addComponent(exactApproximateEditText, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(trunctionEditText, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(newtonErrorCheckbox)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(iterationErrorPowerCheckbox)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(iterationErrorPowerEditText, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
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
                    .addComponent(originalRadioButton)
                    .addComponent(valueEditText, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(importFileLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                .addComponent(newtonErrorCheckbox)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(exactApproximateErrorCheckbox)
                    .addComponent(exactApproximateEditText, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(trunctionEditText, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
                    .addComponent(trunctionErrorCheckbox))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(iterationErrorPowerEditText, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(iterationErrorPowerCheckbox))
                .addGap(41, 41, 41)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(progressBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(startButton, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addGap(7, 7, 7))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void newtonForwardCheckboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newtonForwardCheckboxActionPerformed
        // TODO add your handling code here:
        checkErrorState();

    }//GEN-LAST:event_newtonForwardCheckboxActionPerformed

    private void importFileButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_importFileButtonActionPerformed
        
    }//GEN-LAST:event_importFileButtonActionPerformed

    private void importFileButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_importFileButtonMouseClicked
        LogField importLog = new LogField(1, logField);
        
        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Excel files","xlsx","excel");       
        fileChooser.setFileFilter(filter);
        fileChooser.setFileSelectionMode(fileChooser.FILES_AND_DIRECTORIES);
        fileChooser.setDialogTitle("Import File");
        
        int result = fileChooser.showOpenDialog(jPanel1);
        
        if(result == JFileChooser.APPROVE_OPTION ){
            importLog.addMessage(LogField.FILE_IMPORT_SUCCESS);
            file = fileChooser.getSelectedFile();
            importFileLabel.setText(file.getName());
            progress.clear();
            
            handlingFile();
  
        }else if(file == null){
            importFileLabel.setText("No file is selected");
            importLog.addMessage(LogField.FILE_IMPORT_CANCEL);

        }
        
    }//GEN-LAST:event_importFileButtonMouseClicked

    private void originalRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_originalRadioButtonActionPerformed
        // TODO add your handling code here:
        originalProcess();
    }//GEN-LAST:event_originalRadioButtonActionPerformed
    
    private void originalProcess(){
        iterationCheckbox.setEnabled(false);
        iterationCheckbox.setSelected(false);
        lagrangeCheckbox.setEnabled(true);
        if(questionHolder.getTable().tableType() == Table.EQUAL_TABLE){
            newtonForwardCheckbox.setEnabled(true);
            newtonBackwardCheckbox.setEnabled(true);
        }
        valueEditText.setEnabled(true);
    }
    private void inverseRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inverseRadioButtonActionPerformed
        // TODO add your handling code here:
        if(questionHolder.getTable().tableType() == Table.EQUAL_TABLE){
            iterationCheckbox.setEnabled(true);
        }
        lagrangeCheckbox.setEnabled(true);
        newtonForwardCheckbox.setEnabled(false);
        newtonForwardCheckbox.setSelected(false);
        newtonBackwardCheckbox.setEnabled(false);
        newtonBackwardCheckbox.setSelected(false);
        valueEditText.setEnabled(true);
    }//GEN-LAST:event_inverseRadioButtonActionPerformed

    private void valueEditTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_valueEditTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_valueEditTextActionPerformed

    private void trunctionEditTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_trunctionEditTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_trunctionEditTextActionPerformed

    private void newtonBackwardCheckboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newtonBackwardCheckboxActionPerformed
        // TODO add your handling code here:
        checkErrorState();
    }//GEN-LAST:event_newtonBackwardCheckboxActionPerformed

    private void lagrangeCheckboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lagrangeCheckboxActionPerformed
        // TODO add your handling code here:
        checkErrorState();
    }//GEN-LAST:event_lagrangeCheckboxActionPerformed

    private void iterationCheckboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_iterationCheckboxActionPerformed
        // TODO add your handling code here:
        checkErrorState();
    }//GEN-LAST:event_iterationCheckboxActionPerformed

    private void iterationErrorPowerEditTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_iterationErrorPowerEditTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_iterationErrorPowerEditTextActionPerformed

    private void exactApproximateErrorCheckboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exactApproximateErrorCheckboxActionPerformed
        // TODO add your handling code here:
        checkErrorSelection(exactApproximateEditText, exactApproximateErrorCheckbox.isSelected());
    }//GEN-LAST:event_exactApproximateErrorCheckboxActionPerformed

    private void iterationErrorPowerCheckboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_iterationErrorPowerCheckboxActionPerformed
        // TODO add your handling code here:
        checkErrorSelection(iterationErrorPowerEditText, iterationErrorPowerCheckbox.isSelected());
    }//GEN-LAST:event_iterationErrorPowerCheckboxActionPerformed

    private void trunctionErrorCheckboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_trunctionErrorCheckboxActionPerformed
        // TODO add your handling code here:
        checkErrorSelection(trunctionEditText, trunctionErrorCheckbox.isSelected());
    }//GEN-LAST:event_trunctionErrorCheckboxActionPerformed

    private void valueEditTextKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_valueEditTextKeyTyped
        char character = evt.getKeyChar();
        if(valueEditText.getText().length() > 11 ||(!Character.isDigit(character) && 
                !(character == '.' && !valueEditText.getText().contains("."))
                )){
            evt.consume();
        }
    }//GEN-LAST:event_valueEditTextKeyTyped

    private void trunctionEditTextKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_trunctionEditTextKeyTyped
        // TODO add your handling code here:
        char character = evt.getKeyChar();
        if(trunctionEditText.getText().length() > 11 ||(!Character.isDigit(character) && 
                !(character == '.' && !trunctionEditText.getText().contains("."))
                )){
            evt.consume();
        }
    }//GEN-LAST:event_trunctionEditTextKeyTyped

    private void iterationErrorPowerEditTextKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_iterationErrorPowerEditTextKeyTyped
        // TODO add your handling code here:
        char character = evt.getKeyChar();
        if(iterationErrorPowerEditText.getText().length() > 2 ||(!Character.isDigit(character) && 
                !(character == '.' && !iterationErrorPowerEditText.getText().contains("."))
                )){
            evt.consume();
        }
    }//GEN-LAST:event_iterationErrorPowerEditTextKeyTyped

    private void valueEditTextFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_valueEditTextFocusGained
        // TODO add your handling code here:
        if("0".equals(valueEditText.getText()))
            valueEditText.setText("");
    }//GEN-LAST:event_valueEditTextFocusGained

    private void trunctionEditTextFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_trunctionEditTextFocusGained
        // TODO add your handling code here:
        if("0".equals(trunctionEditText.getText()))
            trunctionEditText.setText("");
    }//GEN-LAST:event_trunctionEditTextFocusGained

    private void iterationErrorPowerEditTextFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_iterationErrorPowerEditTextFocusGained
        // TODO add your handling code here:
        if("0".equals(iterationErrorPowerEditText.getText()))
            iterationErrorPowerEditText.setText("");
    }//GEN-LAST:event_iterationErrorPowerEditTextFocusGained

    private Pair<GThread<Double>, Mathematical> handleNewtonBackwardGThread(final LogField processLog){
        final Newton newtonBackward = new Newton(questionHolder);
        
        return new Pair<GThread<Double>, Mathematical>(new GThread<Double>() {
                @Override
                public Double onProgress() {
                    return newtonBackward.apply(Newton.NEWTON_BACKWARD, Double.valueOf(valueEditText.getText()));
                }

                @Override
                public void onFinished(final Double value) {
                    processLog.addMessage(LogField.NEWTON_BACKWARD_X, value);
                    progress.increasingByOne();
                    if(exactApproximateErrorCheckbox.isSelected()){
                        new GThread<Double>() {
                            @Override
                            public Double onProgress() {
                                return Newton.Error.applyExactApproximateError(value, Double.valueOf(exactApproximateEditText.getText()));
                            }

                            @Override
                            public void onFinished(Double t) {
                                processLog.addMessage(LogField.EXACT_APPROXIMATE_NEWTON_BACKWARD_ERROR, t);
                                progress.increasingByOne();
                            }
                        }.start();
                        
                    }
                }
            }, newtonBackward);
    }
    
    private Pair<GThread<Double>, Mathematical> handleNewtonForwardGThread(final LogField processLog){
        final Newton newtonForward = new Newton(questionHolder);
        
        return new Pair<GThread<Double>, Mathematical>(new GThread<Double>() {
                @Override
                public Double onProgress() {
                    return newtonForward.apply(Newton.NEWTON_FORWARD, Double.valueOf(valueEditText.getText()));
                }

                @Override
                public void onFinished(final Double value) {
                    processLog.addMessage(LogField.NEWTON_FORWARD_X, value);
                    progress.increasingByOne();
                    if(exactApproximateErrorCheckbox.isSelected()){
                        new GThread<Double>() {
                            @Override
                            public Double onProgress() {
                                return Newton.Error.applyExactApproximateError(value, Double.valueOf(exactApproximateEditText.getText()));
                            }

                            @Override
                            public void onFinished(Double t) {
                                processLog.addMessage(LogField.EXACT_APPROXIMATE_NEWTON_FORWARD_ERROR, t);
                                progress.increasingByOne();
                            }
                        }.start();
                        
                    }
                }
            }, newtonForward);
    }
    
    private GThread<Double> handleLagrangeGThread(final LogField processLog){
        return new GThread<Double>() {
            @Override
            public Double onProgress() {
                return new Lagrange(questionHolder).apply(Lagrange.NORMAL_LAGRANGE, Double.valueOf(valueEditText.getText()));
            }

            @Override
            public void onFinished(final Double value) {
                processLog.addMessage(LogField.LAGRANGE_X, value);
                progress.increasingByOne();
                if(exactApproximateErrorCheckbox.isSelected()){
                    new GThread<Double>() {
                        @Override
                        public Double onProgress() {
                            return Lagrange.Error.applyExactApproximateError(value, Double.valueOf(exactApproximateEditText.getText()));
                        }

                        @Override
                        public void onFinished(Double value) {
                            processLog.addMessage(LogField.EXACT_APPROXIMATE_LAGRANGE_ERROR, value);
                            progress.increasingByOne();
                        }
                    }.start();
                }
            }
        };
    }

    private GThread<Double> handleLagrangeInverseGThread(final LogField processLog){
        return new GThread<Double>() {
            @Override
            public Double onProgress() {
                return new Lagrange(questionHolder).apply(Lagrange.INVERSE_LAGRANGE, Double.valueOf(valueEditText.getText()));
            }

            @Override
            public void onFinished(final Double value) {
                processLog.addMessage(LogField.LAGRANGE_INVERSE_Y, value);
                progress.increasingByOne();
                if(exactApproximateErrorCheckbox.isSelected()){
                    new GThread<Double>() {
                        @Override
                        public Double onProgress() {
                            return Lagrange.Error.applyExactApproximateError(value, Double.valueOf(exactApproximateEditText.getText()));
                        }

                        @Override
                        public void onFinished(Double value) {
                            processLog.addMessage(LogField.EXACT_APPROXIMATE_LAGRANGE_ERROR, value);
                            progress.increasingByOne();
                        }
                    }.start();
                }
            }
        };
    }
    
    private Pair<GThread<Double>, Mathematical> handleIterationGThread(final LogField processLog){
        final Iteration iteration = new Iteration(questionHolder);
        
        return new Pair<GThread<Double>, Mathematical>(new GThread<Double>() {
            @Override
            public Double onProgress() {
                if(iterationErrorPowerCheckbox.isSelected())
                    return iteration.apply(Integer.valueOf(iterationErrorPowerEditText.getText()), 
                            Double.valueOf(valueEditText.getText()));
                else
                    return iteration.apply(Iteration.DEFAULT_VALUE, Double.valueOf(valueEditText.getText()));
            }

            @Override
            public void onFinished(Double t) {
                processLog.addMessage(LogField.ITERACTION, t);
                progress.increasingByOne();
            }
        }, iteration);
    }
    
    private GThread<Double> handleNewtonForwardErrorGThread(final LogField processLog){
        return new GThread<Double>() {
            @Override
            public Double onProgress() {
                return Newton.Error.apply(Newton.NEWTON_FORWARD, Double.valueOf(valueEditText.getText()));
            }

            @Override
            public void onFinished(Double t) {
                processLog.addMessage(LogField.NEWTON_FORWARD_ERROR, t);
                progress.increasingByOne();
            }
        };
    }
    
    private GThread<Double> handleNewtonBackwardErrorGThread(final LogField processLog){
        return new GThread<Double>() {
            @Override
            public Double onProgress() {
                return Newton.Error.apply(Newton.NEWTON_BACKWARD, Double.valueOf(valueEditText.getText()));
            }

            @Override
            public void onFinished(Double t) {
                processLog.addMessage(LogField.NEWTON_BACKWARD_ERROR, t);
                progress.increasingByOne();
            }
        };
    }
    
    private GThread<Double> handleTrunctionErrorGThread(final LogField processLog){
        return new GThread<Double>() {
            @Override
            public Double onProgress() {
                return Newton.Error.applyTrunctionError(Double.valueOf(valueEditText.getText()),
                        Double.valueOf(trunctionEditText.getText()));
            }

            @Override
            public void onFinished(Double t) {
                processLog.addMessage(LogField.TRUNCTION_ERROR, t);
                progress.increasingByOne();
            }
        };
    }
    
    private void startButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startButtonActionPerformed
        // TODO add your handling code here:
        progress.clear();
        ArrayList<GThread<Double>> gThreads = new ArrayList<>();
        int counter = 0;
        Pair<GThread<Double>, Mathematical> newtonForwardGThreadPair = null;
        Pair<GThread<Double>, Mathematical> newtonBackwardGThreadPair = null;
        Pair<GThread<Double>, Mathematical> iterationGThreadPair = null;
        GThread<Double> lagrangeGThread;
        GThread<Double> lagrangeInverseGThread;
        GThread<Double> newtonForwardErrorGThread;
        GThread<Double> newtonBackwardErrorGThread;
        GThread<Double> trunctionErrorGThread;
        
        final LogField processLog = new LogField(3, logField);
        
        if(originalRadioButton.isSelected()){
            if(newtonForwardCheckbox.isSelected()){
                newtonForwardGThreadPair = handleNewtonForwardGThread(processLog);
                gThreads.add(newtonForwardGThreadPair.getKey());
                counter += increaseCounter();
            }

            if(newtonBackwardCheckbox.isSelected()){
                newtonBackwardGThreadPair = handleNewtonBackwardGThread(processLog);
                gThreads.add(newtonBackwardGThreadPair.getKey());
                counter += increaseCounter();
                println("" + counter);
            }
            
            if(newtonErrorCheckbox.isSelected() && newtonForwardCheckbox.isSelected()){
                newtonForwardErrorGThread = handleNewtonForwardErrorGThread(processLog);
                gThreads.add(newtonForwardErrorGThread);
                counter++;
            }

            if(newtonErrorCheckbox.isSelected() && newtonBackwardCheckbox.isSelected()){
                newtonBackwardErrorGThread = handleNewtonBackwardErrorGThread(processLog);
                gThreads.add(newtonBackwardErrorGThread);
                counter++;
            }
            
            if(lagrangeCheckbox.isSelected()){
                lagrangeGThread = handleLagrangeGThread(processLog);
                gThreads.add(lagrangeGThread);
                counter += increaseCounter();
            }
        }else if(inverseRadioButton.isSelected()){
            if(iterationCheckbox.isSelected()){
                iterationGThreadPair = handleIterationGThread(processLog);
                gThreads.add(iterationGThreadPair.getKey());
                counter++;
            }
            
            if(lagrangeCheckbox.isSelected()){
                lagrangeInverseGThread = handleLagrangeInverseGThread(processLog);
                gThreads.add(lagrangeInverseGThread);
                counter++;
            }
        }     
        
        if(trunctionErrorCheckbox.isSelected()){
            trunctionErrorGThread = handleTrunctionErrorGThread(processLog);
            gThreads.add(trunctionErrorGThread);
            counter++;
        }
        
        println(""+100/counter);
        progress.setIncreasingValue(100/counter);
       
        final Pair<GThread<Double>, Mathematical> newtonForwardPair = 
                newtonForwardGThreadPair;
        final Pair<GThread<Double>, Mathematical> newtonBackwardPair = 
                newtonBackwardGThreadPair;
        final Pair<GThread<Double>, Mathematical> iterationPair = 
                iterationGThreadPair;
        
        ScheduleGThread scheduleGThread = new ScheduleGThread(5, gThreads.toArray(new GThread[gThreads.size()])) {
            @Override
            public void onScheduleFinished() {
                HashMap<Integer, ArrayList<Double>> hashMap = new HashMap<>();
                
                if(newtonForwardPair != null)
                    hashMap.put( 
                            Mathematical.NEWTON_FORWARD_METHOD,
                            ((Newton) newtonForwardPair.getValue())
                            .getValues(Newton.NEWTON_FORWARD)
                    );
                if(newtonBackwardPair != null)
                    hashMap.put(
                            Mathematical.NEWTON_BACKWARD_METHOD,
                            ((Newton) newtonBackwardPair.getValue())
                            .getValues(Newton.NEWTON_BACKWARD)
                    );
                if(iterationPair != null)
                    hashMap.put(
                            Mathematical.ITERATION_METHOD,
                            ((Iteration) iterationPair.getValue())
                            .getValues()
                    );
                
                try {
                    String filePath = ExcelFile.writeComparisonFile(hashMap);
                    if(!filePath.isEmpty())
                        processLog.addMessage(LogField.COMPARISON_CREATED, filePath);
                } catch (IOException ex) {
                    Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        };
        scheduleGThread.start();
    }//GEN-LAST:event_startButtonActionPerformed

    private int increaseCounter(){
        if(exactApproximateErrorCheckbox.isSelected()){
            return 2;
        }else{
            return 1;
        }
    }
    private void exactApproximateEditTextFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_exactApproximateEditTextFocusGained
        // TODO add your handling code here:
        if("0".equals(exactApproximateEditText.getText()))
            exactApproximateEditText.setText("");
    }//GEN-LAST:event_exactApproximateEditTextFocusGained

    private void exactApproximateEditTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exactApproximateEditTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_exactApproximateEditTextActionPerformed

    private void exactApproximateEditTextKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_exactApproximateEditTextKeyTyped
        // TODO add your handling code here:
        char character = evt.getKeyChar();
        if(exactApproximateEditText.getText().length() > 11 ||(!Character.isDigit(character) && 
                !(character == '.' && !exactApproximateEditText.getText().contains("."))
                )){
            evt.consume();
        }
    }//GEN-LAST:event_exactApproximateEditTextKeyTyped

    
    private void initialState(){
        originalRadioButton.setSelected(false);
        originalRadioButton.setEnabled(false);
        
        inverseRadioButton.setSelected(false);
        inverseRadioButton.setEnabled(false);
        
        newtonForwardCheckbox.setSelected(false);
        newtonForwardCheckbox.setEnabled(false);
        
        newtonBackwardCheckbox.setSelected(false);
        newtonBackwardCheckbox.setEnabled(false);
        
        iterationCheckbox.setSelected(false);
        iterationCheckbox.setEnabled(false);
        
        lagrangeCheckbox.setSelected(false);
        lagrangeCheckbox.setEnabled(false);
        
        valueEditText.setEnabled(false);
        valueEditText.setText("0");
        checkErrorState();
        
    }
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
    private javax.swing.JTextField exactApproximateEditText;
    private javax.swing.JCheckBox exactApproximateErrorCheckbox;
    private javax.swing.JButton importFileButton;
    private javax.swing.JLabel importFileLabel;
    private javax.swing.JLabel importFileLabel1;
    private javax.swing.JRadioButton inverseRadioButton;
    private javax.swing.JCheckBox iterationCheckbox;
    private javax.swing.JCheckBox iterationErrorPowerCheckbox;
    private javax.swing.JTextField iterationErrorPowerEditText;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JCheckBox lagrangeCheckbox;
    private javax.swing.JTextArea logField;
    private javax.swing.JCheckBox newtonBackwardCheckbox;
    private javax.swing.JCheckBox newtonErrorCheckbox;
    private javax.swing.JCheckBox newtonForwardCheckbox;
    private javax.swing.JRadioButton originalRadioButton;
    private javax.swing.JProgressBar progressBar;
    private javax.swing.JButton startButton;
    private javax.swing.JTextField trunctionEditText;
    private javax.swing.JCheckBox trunctionErrorCheckbox;
    private javax.swing.JTextField valueEditText;
    // End of variables declaration//GEN-END:variables
}
