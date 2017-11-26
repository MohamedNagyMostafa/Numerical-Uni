/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package numerical.program;

import javax.swing.JTextArea;

/**
 *
 * @author Mohamed Nagy
 */
public class LogField {
    public static final String NEWTON_FORWARD_X = "Newton Forward x: ";
    public static final String NEWTON_BACKWARD_X = "Newton Backward x:";
    public static final String NEWTON_FORWARD_INVERSE_X = "Newton Forward Inverse y: ";
    public static final String NEWTON_BACKWARD_INVERSE_X = "Newton Backward Inverse y: ";
    public static final String LAGRANGE_X = "Lagrange x: ";
    public static final String LAGRANGE_INVERSE_Y = "Lagrange inverse y: ";
    public static final String ITERACTION = "Iteration x: ";
    public static final String TRUNCTION_ERROR = "Trunction Error : ";
    public static final String NEWTON_ERROR = "Newton Error : ";
    public static final String EXACT_APPROXIMATE_ERROR = "Exact Approximate Error: ";
    public static final String FILE_IMPORT_SUCCESS = "File loaded successfully";
    public static final String READING_DATA = "Reading file data ...";
    public static final String READING_DATA_COMPLETED = "Reading file data is completed";
    public static final String FILE_IMPORT_CANCEL = "Importing process is cancelled";
    public static final String FILE_CAN_NOT_IMPORT = "There's an error in file format";
    public static final String TABLE_TYPE_EQUAL = "Table detected as equal table";
    public static final String TABLE_TYPE_INEQUAL = "Table detected as inequal table";
    public static final String TABLE_CREATED = "Table file is created in location ";
    
    private final int processId;
    private final JTextArea logFieldArea;
    
    public LogField(int processID, JTextArea fieldArea){
        this.processId = processID;
        this.logFieldArea = fieldArea;
    }

    public int getProcessId() {
        return processId;
    }
    
    public void addMessage(String message, double value){
        logFieldArea.setText(logFieldArea.getText() + "Process " + processId + " : " + message + value + "\n");
    }
    
    public void addMessage(String message, String value){
        logFieldArea.setText(logFieldArea.getText() + "Process " + processId + " : " + message + value + "\n");
    }
    
    public void addMessage(String message){
        logFieldArea.setText(logFieldArea.getText() + "Process " + processId + " : " + message + "\n");
    }
}

