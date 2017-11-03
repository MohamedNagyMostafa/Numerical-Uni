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
        double pValue = calculateP(
                                value,
                                mQuestionHolder.getTable().xValue(0),
                                mQuestionHolder.getTable().distanceEqual()
                        );
        
        newtonForwardProcess(
                        mQuestionHolder.getTable(), 
                        pValue,
                        INITTIAL_INDEX,
                        INITIAL_FACTORIAL,
                        mQuestionHolder.getTable().deltaNodeValue(0),
                        pValue
        );
        
        return mQuestionHolder.getNewtonForwardResult();
    }
    
    public Double applyNewtonBackward(double value){
        double pValue = calculateP(
                                value,
                                mQuestionHolder.getTable().max_xValue(),
                                mQuestionHolder.getTable().distanceEqual()
                        );
        
        newtonBackwardProcess(
                        mQuestionHolder.getTable(), 
                        pValue,
                        INITTIAL_INDEX,
                        INITIAL_FACTORIAL,
                        mQuestionHolder.getTable().inverseDeltaValue(0),
                        pValue
        );
        
        return mQuestionHolder.getNewtonBackwardResult();
    }
    
    private void newtonForwardProcess(Table table, double newP_Value, int index, long factorial, Double result, double pValue){
        
        if(table.containDelta(index)){
            newtonForwardProcess(table, newP_Value * (pValue - index), index + 1, factorial * (index + 1),
                    result + ((newP_Value * table.deltaNodeValue(index))/factorial), pValue);
        }else{
            mQuestionHolder.setNewtonForwardResult(result);
        }
        
    }
    
    private void newtonBackwardProcess(Table table, double newP_Value, int index, long factorial, Double result, double pValue){
        
        if(table.containDelta(index)){
            newtonBackwardProcess(table, newP_Value * (pValue + index), index + 1, factorial * (index + 1),
                    result + ((newP_Value * table.inverseDeltaValue(index))/factorial), pValue);
        }else{
            mQuestionHolder.setNewtonBackwardResult(result);
        }
        
    }
    
    private double calculateP(double value, double xNode, double distance){
        return (value - xNode)/ distance;
    }
    
   
}
