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
    public static final String NEWTON_FORWARD_ERROR = "Newton Forwad Error : ";
    public static final String NEWTON_BACKWARD_ERROR = "Newton Backward Error : ";
    public static final String EXACT_APPROXIMATE_NEWTON_BACKWARD_ERROR = "Exact Approximate Newton Backward Error: ";
    public static final String EXACT_APPROXIMATE_NEWTON_FORWARD_ERROR = "Exact Approximate Newton Forward Error: ";
    public static final String EXACT_APPROXIMATE_LAGRANGE_ERROR = "Exact Approximate Lagrange Error: ";
    public static final String FILE_IMPORT_SUCCESS = "File loaded successfully";
    public static final String READING_DATA = "Reading file data ...";
    public static final String READING_DATA_COMPLETED = "Reading file data is completed";
    public static final String FILE_IMPORT_CANCEL = "Importing process is cancelled";
    public static final String FILE_CAN_NOT_IMPORT = "There's an error in file format";
    public static final String TABLE_TYPE_EQUAL = "Table detected as equal table";
    public static final String TABLE_TYPE_INEQUAL = "Table detected as unequal table";
    public static final String TABLE_CREATED = "Table file is created in location ";
    public static final String COMPARISON_CREATED = "Comparison file is created in location ";
    
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

