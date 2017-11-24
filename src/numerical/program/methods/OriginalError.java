/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package numerical.program.methods;

import numerical.program.Converter;
import numerical.program.QuestionHolder;
import numerical.program.Table;

/**
 *
 * @author Mohamed Nagy
 */
public abstract class OriginalError {
    public static double applyExactApproximateError(double exact, double approximate){
        return Converter.apply(Math.abs(exact - approximate));
    }
    public static double trunctionError(QuestionHolder questionHolder, double exactDifferentiation, double xValue){
        return Converter.apply(trunctionErrorProcess(xValue, 1, 0, 1, questionHolder.getTable()) * exactDifferentiation);
    }
    
    private static double trunctionErrorProcess(double xValue, int factorial, int node, double error, Table table){
        if(node < table.xValuesNumber() - 1){
            return trunctionErrorProcess(xValue,
                    factorial * (node + 1), 
                    node + 1, 
                    Converter.apply(error * Converter.apply(xValue - table.xValue(node))),
                    table);
        }else{
            return Converter.apply(error/ factorial);
        }
    }
}
