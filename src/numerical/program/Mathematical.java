/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package numerical.program;

/**
 *
 * @author mohamednagy
 */
public class Mathematical {
  
    private final QuestionHolder mQuestionHolder;
    private static final short INITTIAL_INDEX = 1;
    private static final short INITIAL_FACTORIAL = 1; 
    
    public Mathematical(QuestionHolder questionHolder){
        mQuestionHolder = questionHolder;
    }
    
    public Double applyNewtonForward(double value){
        mQuestionHolder.setP_value(calculateP(
                                value,
                                mQuestionHolder.getTable().xValue(0),
                                mQuestionHolder.getTable().distanceEqual()
                        )
        );
        
        newtonForwardProcess(
                        mQuestionHolder.getTable(), 
                        mQuestionHolder.getP_value(),
                        INITTIAL_INDEX,
                        INITIAL_FACTORIAL,
                        mQuestionHolder.getTable().deltaNodeValue(0),
                        mQuestionHolder.getP_value()
        );
        
        return mQuestionHolder.getNewtonForwardResult();
    }
    
    public Double applyNewtonBackward(double value){
        mQuestionHolder.setP_value(calculateP(
                                value,
                                mQuestionHolder.getTable().max_xValue(),
                                mQuestionHolder.getTable().distanceEqual()
                        )
        );
        
        newtonBackwardProcess(
                        mQuestionHolder.getTable(), 
                        mQuestionHolder.getP_value(),
                        INITTIAL_INDEX,
                        INITIAL_FACTORIAL,
                        mQuestionHolder.getTable().inverseDeltaValue(0),
                        mQuestionHolder.getP_value()
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
    
    public double applyNewtonError(){
        newtonError(
                mQuestionHolder.getTable().tableType(),
                mQuestionHolder.getP_value(),
                mQuestionHolder.getTable().deltaNewtonErrorValue().getKey(),
                mQuestionHolder.getTable().deltaNewtonErrorValue().getValue(),
                mQuestionHolder.getTable().deltaNewtonErrorValue().getValue(),
                1);
        
        return mQuestionHolder.getNewtonError();
    }
    
    private void newtonError(int tableType, double pValue, double deltaValue, int n, int nNew, double result){
        if(nNew <= n){
            newtonError(tableType, pValue, deltaValue, n, nNew + 1, result * (pValue + (nNew * tableType))/nNew);
        }else{
            result = result * (deltaValue/(n + 1));
            mQuestionHolder.setNewtonError(result);
        }
    }
    
    private double calculateP(double value, double xNode, double distance){
        return (value - xNode)/ distance;
    }
    
   
}
