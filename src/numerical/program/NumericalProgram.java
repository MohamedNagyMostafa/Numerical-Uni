/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package numerical.program;

import com.sun.org.apache.xalan.internal.xsltc.compiler.util.Util;

/**
 *
 * @author mohamednagy
 */
public class NumericalProgram {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Table table = new Table(new Double[]{8.0, 10.0, 12.0, 14.0, 16.0},
        new Double[]{1000.0, 1900.0, 3250.0, 5400.0, 8950.0});
        QuestionHolder questionHolder = new QuestionHolder(table);
        Mathematical mathematical = new Mathematical(questionHolder);
        Util.println("value = " + mathematical.applyNewtonForward(9));
    }
 
    
}
