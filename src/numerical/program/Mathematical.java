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
public class Mathematical {
  
    private QuestionHolder mQuestionHolder;
    private static final short INITTIAL_INDEX = 1;
    private static final short INITIAL_FACTORIAL = 1; 
    
    public Mathematical(QuestionHolder questionHolder){
        mQuestionHolder = questionHolder;
        init();
    }
    
    private void init(){
        //TODO ... Set Table.
    }
    
    public Double applyNewtonForward(double value){
        double pValue = calculateP_Forward(
                                value,
                                mQuestionHolder.getTable().xValue(0),
                                mQuestionHolder.getTable().distanceEqual()
                        );
        
        newtonForwardProcess(
                        mQuestionHolder.getTable(), 
                        pValue,
                        INITTIAL_INDEX,
                        INITIAL_FACTORIAL,
                        mQuestionHolder.getTable().deltaValue(0, 0),
                        pValue
        );
        return mQuestionHolder.getNewtonForwardResult();
    }
    
    private void newtonForwardProcess(Table table, double newP_Value, int index, long factorial, Double result, double pValue){
        
        if(table.containDelta(index)){
        Util.println("P = " + newP_Value + " factorial = " + factorial + " delta= " + table.deltaValue(index, 0) + "result = " + result);
            newtonForwardProcess(table, newP_Value * (pValue - index), index + 1, factorial * (index + 1),
                    result + ((newP_Value * table.deltaValue(index, 0))/factorial), pValue);
        }else{
        Util.println("result = " + result);
            mQuestionHolder.setNewtonForwardResult(result);
        }
        
    }
    
    private double calculateP_Forward(double value, double xNode, double distance){
        return (value - xNode)/ distance;
    }
}
